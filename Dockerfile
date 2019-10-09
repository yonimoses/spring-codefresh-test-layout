FROM maven:3.6.2-jdk-8  AS build
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn package

#
FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY --from=build /tmp/target/*.jar hello.jar
ENTRYPOINT ["java","-jar","/hello.jar"]

