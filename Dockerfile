FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} prices-1.0.0-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/prices-1.0.0-SNAPSHOT.jar"]
