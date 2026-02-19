# Build stage
FROM maven:3.9-eclipse-temurin-21-alpine AS builder
WORKDIR /build

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src src
RUN mvn package -B -DskipTests

# Run stage
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

ARG JAR_FILE=/build/target/*.jar
COPY --from=builder ${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
