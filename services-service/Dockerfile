FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} services-service.jar
ENTRYPOINT ["java","-jar","/services-service.jar"]
EXPOSE 9008