FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /target/customerLoginSignup-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8181
ENV JAVA_OPTS=""
RUN sh -c "touch customerLoginSignup-0.0.1-SNAPSHOT.jar"
ENTRYPOINT [ "java", "-jar", "customerLoginSignup-0.0.1-SNAPSHOT.jar" ]
