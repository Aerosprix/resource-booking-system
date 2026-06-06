# Stage 1: Build the application using Maven and Java 25
FROM maven:3-eclipse-temurin-25-alpine AS builder
WORKDIR /app

# Optimize cache: Copy pom.xml first to lock dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source and compile
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Create the lightweight runtime image with Java 25
FROM eclipse-temurin:25-jre-alpine AS runner
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-jar", "app.jar"]
