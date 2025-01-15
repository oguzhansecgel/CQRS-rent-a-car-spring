# Maven ve OpenJDK içeren bir imaj kullanıyoruz
FROM maven:3.8.3-openjdk-17 AS build

# Ana çalışma dizinini belirle
WORKDIR /app

# common-event'i doğru konumdan kopyala ve build et
COPY common-event /app/common-event/
WORKDIR /app/common-event
RUN mvn clean install

# reservation-service'yi kopyala ve build et
COPY ./reservation-service /app/reservation-service/
WORKDIR /app/reservation-service
RUN mvn clean install -DskipTests


# Uygulama için openjdk kullanıyoruz
FROM openjdk:17-jdk

# reservation-service dizinine geçiş
WORKDIR /app/reservation-service

# Maven komutunu çalıştırıyoruz, çünkü Maven imajını kullanıyoruz
COPY --from=build /app/reservation-service/target/reservation-service-0.0.1-SNAPSHOT.jar /app/reservation-service.jar

# Uygulamayı çalıştır
CMD ["java", "-jar", "/app/reservation-service.jar"]
