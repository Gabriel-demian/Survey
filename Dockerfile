FROM openjdk:8-jre
MAINTAINER GABRIEL
VOLUME /tmp
EXPOSE 8080
COPY target/survey-0.0.1-SNAPSHOT.jar survey.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/survey.jar"]