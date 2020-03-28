#!/usr/bin/env bash

GREEN="\033[0;32m"
RED="\033[0;31m"
NO_COLOR="\033[0m"

colored_print(){
    echo -e "$1 $2 $NO_COLOR"

}

colored_print ${GREEN} "Check if docker and kubenetes are enabled"
sudo service docker start &&
sudo service kubelet start
systemctl is-active --quiet docker && \
systemctl is-active --quiet kubelet || \
colored_print ${RED} "Docker and kubernetes are disabled or not installed, \
      visit https://github.com/danghh-1998/common_stuff/blob/master/fix_docker.md for more details"

colored_print ${GREEN} "Install curl"
sudo apt install curl -y

colored_print ${GREEN} "Run docker without sudo privileges"
sudo usermod -aG docker ${USER}
id -nG

colored_print ${GREEN} "Dockerhub login"
docker login

colored_print ${GREEN} "Clone repository"
eval $(ssh-agent -s)
[[ ! -d ${PROJECT_DIR} ]] && git clone https://github.com/anhth318/microservices-demo.git ${PROJECT_DIR}
cd ${PROJECT_DIR}

colored_print ${GREEN} "Make mvnw file executable"
chmod +x mvnw
colored_print ${GREEN} "Compile and install sub modules"
./mvnw clean package -Dmaven.test.skip=true

colored_print ${GREEN} "Build apache service and push to dockerhub"
docker build --tag=microservice-kubernetes-demo-apache apache
docker tag microservice-kubernetes-demo-apache ${DOCKER_USER}/microservice-kubernetes-demo-apache:latest
docker push ${DOCKER_USER}/microservice-kubernetes-demo-apache

colored_print ${GREEN} "Build catalog service and push to dockerhub"
docker build --tag=microservice-kubernetes-demo-catalog microservice-kubernetes-demo-catalog
docker tag microservice-kubernetes-demo-catalog ${DOCKER_USER}/microservice-kubernetes-demo-catalog:latest
docker push ${DOCKER_USER}/microservice-kubernetes-demo-catalog

colored_print ${GREEN} "Build customer service and push to dockerhub"
docker build --tag=microservice-kubernetes-demo-customer microservice-kubernetes-demo-customer
docker tag microservice-kubernetes-demo-customer ${DOCKER_USER}/microservice-kubernetes-demo-customer:latest
docker push ${DOCKER_USER}/microservice-kubernetes-demo-customer

colored_print ${GREEN} "Build order service and push to dockerhub"
docker build --tag=microservice-kubernetes-demo-order microservice-kubernetes-demo-order
docker tag microservice-kubernetes-demo-order ${DOCKER_USER}/microservice-kubernetes-demo-order:latest
docker push ${DOCKER_USER}/microservice-kubernetes-demo-order

colored_print ${GREEN} "Download custom microservices.yaml file into project directory"
curl -o ${PROJECT_DIR}/microservices.yaml https://raw.githubusercontent.com/danghh-1998/distributed_systems/chapter_2/architecture/src/microservices.yaml

colored_print ${GREEN} "Open browser and visit dockerhub"
xdg-open https://hub.docker.com/repositories

colored_print ${GREEN} "Run kubernetes locally"
minikube start
kubectl apply -f microservices.yaml
kubectl get all
