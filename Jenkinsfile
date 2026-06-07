pipeline {
    agent any

    parameters {
        string(name: 'maven_version', defaultValue: '3.8.9', description: 'Pass the version of Maven')
        string(name: 'terraform_version', defaultValue: '1.6.5', description: 'Pass the version of Terraform')
    }

    stages {
        stage('Download Maven') {
            steps {
                sh """
                    cd /var/lib/jenkins/
                    wget https://archive.apache.org/dist/maven/maven-3/${maven_version}/binaries/apache-maven-${maven_version}-bin.tar.gz
                    tar -xvzf apache-maven-${maven_version}-bin.tar.gz
                """
            }
        }
}
}