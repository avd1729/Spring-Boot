# Use a base image that contains Java
FROM openjdk:21-jdk-slim
LABEL authors="Aravind"

ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]