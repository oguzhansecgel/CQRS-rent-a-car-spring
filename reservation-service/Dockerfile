FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk
COPY --from=build /app/target/reservation-service-0.0.1-SNAPSHOT.jar /app/reservation-service.jar
CMD ["java", "-jar", "/app/reservation-service.jar"]