# Use a base image that contains Java
FROM openjdk:21-jdk-slim
LABEL authors="Aravind"

VOLUME /tmp
COPY todo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]