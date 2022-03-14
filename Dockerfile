FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-mail-sender.jar
ENTRYPOINT ["java","-jar","/ms-mail-sender.jar"]