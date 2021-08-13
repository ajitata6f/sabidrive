FROM openjdk:8
LABEL maintainer='ajitata_dev'
VOLUME /tmp
ADD /build/libs/sabidrive-taxi-service-1.0.0.jar sabidrive-taxi-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sabidrive-taxi-service.jar"]
