FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
ARG JAR_FILE=target/eebria-service-1.0.0.jar
COPY ${JAR_FILE}  eebria-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","eebria-service.jar"]


