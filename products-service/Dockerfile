FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} productss-service.jar
ENTRYPOINT ["java","-jar","/productss-service.jar.jar"]
EXPOSE 9007