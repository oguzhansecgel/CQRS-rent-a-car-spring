FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . /app/
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk
COPY --from=build /app/target/common-event-0.0.1-SNAPSHOT.jar /app/common-event.jar
CMD ["java", "-jar", "/app/common-event.jar"]