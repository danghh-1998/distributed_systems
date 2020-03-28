#!/usr/bin/env bash

kubectl delete service apache catalog customer order
kubectl delete deployments apache catalog customer order

sudo service kubelet stop
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
