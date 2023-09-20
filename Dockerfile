FROM openjdk:17-alpine
RUN mkdir app
COPY target/*.jar app/app.jar
WORKDIR app
CMD ["java","-jar","app.jar"]
