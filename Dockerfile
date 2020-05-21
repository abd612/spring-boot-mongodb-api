FROM java:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY target/spring-boot-mongodb-api-1.0.0.jar app.jar
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /app.jar