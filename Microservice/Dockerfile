# Stage 1: Build the eureka-server
FROM maven:3.8.4-openjdk-17-slim AS eureka-server-build
WORKDIR /app
COPY eurekaServer/pom.xml /app/
RUN mvn dependency:go-offline -B
COPY EurekaServer /app
RUN mvn clean package -DskipTests

# Stage 2: Build the api-gateway
FROM maven:3.8.4-openjdk-17-slim AS api-gateway-build
WORKDIR /app
COPY Gateway/pom.xml /app/
RUN mvn dependency:go-offline -B
COPY Gateway /app
RUN mvn clean package -DskipTests

# Stage 3: Build the user-service
FROM maven:3.8.4-openjdk-17-slim AS user-service-build
WORKDIR /app
COPY UserService/pom.xml /app/
RUN mvn dependency:go-offline -B
COPY UserService /app
RUN mvn clean package -DskipTests

# Stage 4: Build the post-service
#FROM maven:3.8.4-openjdk-17-slim AS post-service-build
#WORKDIR /app
#COPY post-service/pom.xml /app/
#RUN mvn dependency:go-offline -B
#COPY post-service /app
#RUN mvn clean package -DskipTests

# Stage 5: Build the comment-service
#FROM maven:3.8.4-openjdk-17-slim AS comment-service-build
#WORKDIR /app
#COPY comment-service/pom.xml /app/
#RUN mvn dependency:go-offline -B
#COPY comment-service /app
#RUN mvn clean package -DskipTests

# Stage 6: Create the runtime image for eureka-server
FROM openjdk:17-jdk-slim as eureka-server-Runtime
WORKDIR /app
COPY --from=eureka-server-build /app/target/*.jar /app/eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "/app/eureka-server.jar"]

# Stage 7: Create the runtime image for api-gateway
FROM openjdk:17-jdk-slim as api-gateway-runtime
WORKDIR /app
COPY --from=api-gateway-build /app/target/*.jar /app/gateway.jar
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "/app/gateway.jar"]

# Stage 8: Create the runtime image for user-service
FROM openjdk:17-jdk-slim as user-service-runtime
WORKDIR /app
COPY --from=user-service-build /app/target/*.jar /app/user-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app/user-service.jar"]

# Stage 9: Create the runtime image for post-service
#FROM openjdk:17-jdk-slim as post-service-runtime
#WORKDIR /app
#COPY --from=post-service-build /app/target/post-service.jar /app/post-service.jar
#ENTRYPOINT ["java", "-jar", "/app/post-service.jar"]

# Stage 10: Create the runtime image for comment-service
#FROM openjdk:17-jdk-slim as comment-service-runtime
#WORKDIR /app
#COPY --from=comment-service-build /app/target/comment-service.jar /app/comment-service.jar
#ENTRYPOINT ["java", "-jar", "/app/comment-service.jar"]
