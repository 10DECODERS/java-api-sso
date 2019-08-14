FROM java:8-jdk-alpine

COPY ./target/rbc-bank-api-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch rbc-bank-api-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","rbc-bank-api-0.0.1-SNAPSHOT.jar"] 