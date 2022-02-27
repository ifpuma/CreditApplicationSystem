FROM openjdk:9-jdk

MAINTAINER Pınar Özdil <pinarrozdil@gmail.com>
EXPOSE 8080
ADD target/CreditApplicationSystem-0.0.1-SNAPSHOT.jar CreditApplicationSystem.jar

ENTRYPOINT ["java","-jar","CreditApplicationSystem.jar"]