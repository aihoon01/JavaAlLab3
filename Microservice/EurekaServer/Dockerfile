FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/*.jar /app/eureka-server.jar
ENV SPRING_PROFILES_ACTIVE=docker-cloud
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/app/eureka-server.jar"]
