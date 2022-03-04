FROM openjdk:16

COPY . .

RUN mvn clean package -DskipTests

EXPOSE 8080
ENTRYPOINT [ "./target/ms-mail-sender-0.0.1-SNAPSHOT" ]