FROM openjdk:11-slim

COPY ./target/multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar .

EXPOSE 8080

CMD java -jar multiple-entry-points-with-dependency-injection-1.0-SNAPSHOT.jar