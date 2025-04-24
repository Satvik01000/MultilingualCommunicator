FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/MultilingualCommunicator-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS

ENTRYPOINT ["java", "-jar", "app.jar"]
