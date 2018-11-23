FROM anapsix/alpine-java:8_jdk
ADD app.jar app.jar
ADD docker-app.yml docker-app.yml
RUN sh -c 'touch /app.jar'
EXPOSE 8080
CMD ["java","-Dspring.config.location=file:docker-app.yml", "-jar", "/app.jar"]