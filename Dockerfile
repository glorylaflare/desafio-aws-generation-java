FROM maven:3.8.6-eclipse-temurin-17 as build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -X -DskipTests

FROM openjdk:17-jdk-slim
EXPOSE 8080
WORKDIR /app
COPY --from=build ./app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]