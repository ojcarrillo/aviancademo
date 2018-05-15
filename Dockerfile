FROM openjdk:8-jdk-alpine
VOLUME ["/tmp","/var/netgloo_blog/logs/application.log"]
ADD target/aviancaDemo-0.0.1-SNAPSHOT.jar app.jar
CMD java -jar app.jar
EXPOSE 7001
