# Stage 1: Build the project
FROM maven:3.9.7 as builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
# RUN mvn dependency:go-offline

# Copy the project source code
COPY src ./src

# build the project
RUN mvn package

# Stage 2: Run the application
FROM eclipse-temurin:21-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file from the first stage
# COPY --from=builder app/target/*.jar entgra-backend.jar
ADD target/entgra-backend.jar entgra-backend.jar

# Define the command to run the application
ENTRYPOINT ["java", "-jar", "entgra-backend.jar"]