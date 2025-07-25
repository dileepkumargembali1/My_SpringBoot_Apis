# Use lightweight JDK base image
FROM eclipse-temurin:17-jre-alpine

# Set working directory inside the container
WORKDIR /app

# Copy your built jar file into the container
COPY target/my-application.jar app.jar

# Expose port used by the Spring Boot application
EXPOSE 8085

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
