FROM maven:3.9-eclipse-temurin-21 AS build
LABEL authors="Jzang"
WORKDIR /src
COPY pom.xml .
RUN mvn -B dependency:go-offline
COPY src ./src
RUN mvn -B clean package -DskipTests

FROM eclipse-temurin:21-jre
COPY --from=build /src/target/*.jar /app.jar
CMD ["java", "-jar", "/app.jar"]