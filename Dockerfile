# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jdk-slim
# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY ./target/ingressDB-0.0.1-SNAPSHOT.jar /app/ingressDB-0.0.1-SNAPSHOT.jar
COPY ./target/dependencies /app/target/dependencies
EXPOSE 8089

# Run the JAR file when the container starts
ENTRYPOINT ["java", "-jar", "ingressDB-0.0.1-SNAPSHOT.jar"]
