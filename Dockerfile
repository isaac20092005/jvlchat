# Step 1: Build the Application
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Step 2: Run the Application
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
# Restrict JVM memory usage so Render's 512MB RAM limit isn't exceeded
ENTRYPOINT ["java", "-Xmx384m", "-jar", "app.jar"]