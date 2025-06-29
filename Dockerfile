# Start from a lightweight OpenJDK 17 runtime
FROM eclipse-temurin:17-jdk-alpine

# Set a working directory inside the container
WORKDIR /app

# Copy the Spring Boot application JAR file
COPY target/springsec.jar app.jar

# Optional: Expose port 8080
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
