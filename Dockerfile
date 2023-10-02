FROM openjdk:21-jdk-slim
COPY build/libs/spring-hazelcast-distributed-lock-1.0.0.jar application.jar
EXPOSE 8080
CMD java -jar application.jar