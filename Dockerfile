# Use an official OpenJDK runtime as a parent image
FROM openjdk:latest

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY /target/ingressDB-0.0.1-SNAPSHOT.jar /app/ingressDB-0.0.1-SNAPSHOT.jar

# Run the JAR file when the container starts
CMD ["java", "-jar", "ingressDB-0.0.1-SNAPSHOT.jar"]
