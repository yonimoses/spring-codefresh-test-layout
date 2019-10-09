#!/bin/bash

DOCKER_USER=yonimoses
APP_NAME=spring-codefresh-test-layout
APP_VERSION=1.0.0


#mvn clean package

docker build --no-cache -t ${DOCKER_USER}/${APP_NAME}:${APP_VERSION} .
#docker push ${DOCKER_USER}/${APP_NAME}:${APP_VERSION}

#helm install --name spring-codefresh-test-layout ./chart

