# Use Tomcat 9 with Java 25
FROM tomcat:9.0-jdk25-temurin

# Set maintainer label
LABEL maintainer="shiva@example.com"

# Remove the default ROOT application
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Create a non-root user
RUN useradd -m bookmyplan

# Copy the application JAR
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

# Expose Tomcat port
EXPOSE 8080

# Run as a non-root user
USER bookmyplan

# Start Tomcat
CMD ["catalina.sh", "run"]