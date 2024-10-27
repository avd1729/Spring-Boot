# Use a base image that contains Java
FROM openjdk:21-jdk-slim
LABEL authors="Aravind"

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/blog-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]