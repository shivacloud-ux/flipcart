pipeline {

    agent any

    options {
        buildDiscarder(logRotator(numToKeepStr: '3', artifactNumToKeepStr: '3'))
    }

    tools {
        maven 'mvn_3.9.16'
    }

    stages {

        stage('Code Compilation') {
            steps {
                echo 'Starting Code Compilation...'
                sh 'mvn clean compile'
                echo 'Code Compilation Completed Successfully!'
            }
        }

        stage('Code QA Execution') {
            steps {
                echo 'Running JUnit Test Cases...'
                sh 'mvn clean test'
                echo 'JUnit Test Cases Completed Successfully!'
            }
        }

        stage('Code Package') {
            steps {
                echo 'Creating WAR Artifact...'
                sh '''
                    mvn clean package
                    cp target/*.war target/flipcart-v1.0.1-${BUILD_NUMBER}.war
                '''
                echo 'WAR Artifact Created Successfully!'
            }
        }

        stage('Build & Tag Docker Image') {
            steps {
                echo 'Building Docker Image and Tagging'
                sh 'docker build -t shivacloud168/bookmyplan:latest -t bookmyplan:latest .'
                echo 'Docker Image Build Completed!'
            }
        }

        stage('Push Docker Image to Amazon ECR') {
            steps {
                script {
                    withDockerRegistry(
                        credentialsId: 'ecr:us-east-1:ecr-credentials',
                        url: 'https://802854082547.dkr.ecr.us-east-1.amazonaws.com'
                    ) {

                        echo 'Tagging and Pushing Docker Image to Amazon ECR...'

                        sh '''
                            docker images
                            docker tag bookmyplan:latest 802854082547.dkr.ecr.us-east-1.amazonaws.com/bookmyplan:latest
                            docker push 802854082547.dkr.ecr.us-east-1.amazonaws.com/bookmyplan:latest
                        '''

                        echo 'Docker Image Pushed to Amazon ECR Successfully!'
                    }
                }
            }
        }

        stage('Clean Up Local Docker Images') {
            steps {
                echo 'Cleaning Up Local Docker Images...'

                sh '''
                    docker rmi shivacloud168/bookmyplan:latest || true
                    docker rmi bookmyplan:latest || true
                    docker rmi 802854082547.dkr.ecr.us-east-1.amazonaws.com/bookmyplan:latest || true

                    docker image prune -f
                '''

                echo 'Local Docker Images Cleaned   Successfully!'
            }
        }

    }
}