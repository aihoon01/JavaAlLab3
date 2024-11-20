FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/user-service.jar
ENV SPRING_PROFILES_ACTIVE=docker-cloud
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/user-service.jar"]
