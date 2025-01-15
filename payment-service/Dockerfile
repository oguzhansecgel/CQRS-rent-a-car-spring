# Maven ve OpenJDK içeren bir imaj kullanıyoruz
FROM maven:3.8.3-openjdk-17 AS build

# Ana çalışma dizinini belirle
WORKDIR /app

COPY common-event /app/common-event/
WORKDIR /app/common-event
RUN mvn clean install


COPY ./payment-service /app/payment-service/
WORKDIR /app/payment-service
RUN mvn clean install -DskipTests

FROM openjdk:17-jdk

WORKDIR /app/payment-service
COPY --from=build /app/payment-service/target/payment-service-0.0.1-SNAPSHOT.jar /app/payment-service.jar

CMD ["java", "-jar", "/app/payment-service.jar"]
