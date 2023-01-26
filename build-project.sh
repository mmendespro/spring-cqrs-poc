#!/bin/bash

# build the app
mvn clean package
# stop container
docker stop spring-cqrs-poc-jvm
# remove container
docker rm spring-cqrs-poc-jvm
# remove container image
docker rmi spring/spring-cqrs-poc-jvm:latest
# build container image
docker build -f docker/Dockerfile.jvm -t spring/spring-cqrs-poc-jvm .
# run container
docker run -id --network=metrics --name spring-cqrs-poc-jvm -p 8080:8080 spring/spring-cqrs-poc-jvm