# Use the official OpenJDK 21 image as the base image
FROM openjdk:21-jdk

ADD target/entgra-backend.jar entgra-backend.jar

# Run the jar file
ENTRYPOINT ["java","-jar","entgra-backend.jar"]

# Expose the application port
EXPOSE 8080

