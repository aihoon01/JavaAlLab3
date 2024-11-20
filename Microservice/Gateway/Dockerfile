FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/gateway.jar
ENV SPRING_PROFILES_ACTIVE=docker-cloud
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "/app/gateway.jar"]
