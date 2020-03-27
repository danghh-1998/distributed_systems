#!/usr/bin/env bash

echo "Run docker without sudo privileges"
sudo usermod -aG docker ${USER}
su - ${USER}
id -nG

eval $(ssh-agent -s)
echo "Clone microservices-demo into ${PROJECT_DIR}"
git clone https://github.com/anhth318/microservices-demo.git ${PROJECT_DIR}
cd ${PROJECT_DIR}

echo "Make mvnw file executable"
chmod +x mvnw
./mvnw clean package -Dmaven.test.skip=true

echo "Build apache service and push to dockerhub"
docker build --tag=microservice-kubernetes-demo-apache apache
docker tag microservice-kubernetes-demo-apache ${DOCKER_USER}/microservice-kubernetes-demo-apache:latest
docker push ${DOCKER_USER}/microservice-kubernetes-demo-apache

echo "Build catalog service and push to dockerhub"
docker build --tag=microservice-kubernetes-demo-catalog microservice-kubernetes-demo-catalog
docker tag microservice-kubernetes-demo-catalog ${DOCKER_USER}/microservice-kubernetes-demo-catalog:latest
docker push ${DOCKER_USER}/microservice-kubernetes-demo-catalog

echo "Build customer service and push to dockerhub"
docker build --tag=microservice-kubernetes-demo-customer microservice-kubernetes-demo-customer
docker tag microservice-kubernetes-demo-customer ${DOCKER_USER}/microservice-kubernetes-demo-customer:latest
docker push ${DOCKER_USER}/microservice-kubernetes-demo-customer

echo "Build order service and push to dockerhub"
docker build --tag=microservice-kubernetes-demo-order microservice-kubernetes-demo-order
docker tag microservice-kubernetes-demo-order ${DOCKER_USER}/microservice-kubernetes-demo-order:latest
docker push ${DOCKER_USER}/microservice-kubernetes-demo-order

