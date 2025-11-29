FROM maven:latest

#RUN apt-get update && apt-get install maven openjdk-21-jdk -y
RUN apt-get update -y

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src /app/src
RUN mvn clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/thymeleaf-fragments-custom.jar"]