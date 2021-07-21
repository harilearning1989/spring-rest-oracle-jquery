FROM adoptopenjdk/openjdk11:alpine-jre
#VOLUME /tmp
MAINTAINER haritech.com
ARG JAR_FILE=build/libs/spring-rest-oracle-demo.war
#WORKDIR /opt/app
#COPY ${JAR_FILE} /var/lib/jenkins/workspace/spring-gradle-docker
ADD ${JAR_FILE} spring-rest-oracle-demo.war
ENTRYPOINT ["java","-jar","spring-rest-oracle-demo.war"]
EXPOSE 8081
#docker run -d --restart=always -p 8081:8081 harilearning1989/spring-rest-oracle-demo