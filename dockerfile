FROM eclipse-temurin:17-jdk

LABEL maintainer="Gana"
LABEL application="employee-service"
LABEL version="1.0"

RUN groupadd --system spring && \
    useradd --system --gid spring spring

WORKDIR /app

COPY target/emp-service-0.0.1-SNAPSHOT.jar emp-service.jar

RUN chown spring:spring /app/emp-service.jar

USER spring

EXPOSE 8081

ENTRYPOINT ["java","-XX:MaxRAMPercentage=75","-jar","/app/emp-service.jar"]