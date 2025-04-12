# Usa Maven com Java 22
FROM maven:3.9.6-eclipse-temurin-22 AS build

WORKDIR /app/work/
COPY pom.xml ./
COPY src ./src

RUN --mount=type=cache,target=/root/.m2  mvn clean package -Dmaven.test.skip

FROM openjdk:22-jdk
COPY --from=build /app/work/target/*-exec.jar /app/work/app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/work/app.jar"]