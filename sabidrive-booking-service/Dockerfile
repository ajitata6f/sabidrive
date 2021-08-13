FROM openjdk:8
LABEL maintainer='ajitata_dev'
VOLUME /tmp
ADD /build/libs/sabidrive-booking-service-1.0.0.jar sabidrive-booking-service.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "sabidrive-booking-service.jar"]
