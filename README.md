# Employee Service - Build, Docker, Kubernetes & Helm Commands

## Prerequisites

-   Java 17
-   Maven 3.9+
-   Docker Desktop / Docker Engine
-   Kubernetes (Minikube or Kind)
-   kubectl
-   Helm 3.x

------------------------------------------------------------------------

# 1. Maven Commands

## Clean project

``` bash
mvn clean
```

## Compile

``` bash
mvn compile
```

## Run unit tests

``` bash
mvn test
```

## Package application

``` bash
mvn clean package
```

## Install to local Maven repository

``` bash
mvn clean install
```

## Skip tests

``` bash
mvn clean package -DskipTests
```

## Dependency tree

``` bash
mvn dependency:tree
```

------------------------------------------------------------------------

# 2. Docker Commands

## Build image

``` bash
docker build -t employee-service:1.0 .
```

## List images

``` bash
docker images
```

## Run container

``` bash
docker run -d --name employee-service -p 8081:8081 employee-service:1.0
```

## Running containers

``` bash
docker ps
```

## All containers

``` bash
docker ps -a
```

## View logs

``` bash
docker logs employee-service
```

## Follow logs

``` bash
docker logs -f employee-service
```

## Enter container

``` bash
docker exec -it employee-service sh
```

## Stop container

``` bash
docker stop employee-service
```

## Remove container

``` bash
docker rm employee-service
```

## Remove image

``` bash
docker rmi employee-service:1.0
```

------------------------------------------------------------------------

# 3. Docker Hub

## Login

``` bash
docker login
```

## Tag image

``` bash
docker tag employee-service:1.0 <dockerhub-user>/employee-service:1.0
```

## Push image

``` bash
docker push <dockerhub-user>/employee-service:1.0
```

## Pull image

``` bash
docker pull <dockerhub-user>/employee-service:1.0
```

# Common Docker commands
``` 
# Show running containers
docker ps

# Show all containers
docker ps -a

# View logs
docker logs employee-service

# Follow logs continuously
docker logs -f employee-service

# Stop container
docker stop employee-service

# Start container
docker start employee-service

# Restart container
docker restart employee-service

# Remove container
docker rm employee-service

# Execute shell inside container
docker exec -it employee-service bash
```

------------------------------------------------------------------------

# 4. Minikube Commands

## Start

``` bash
minikube start
```

## Status

``` bash
minikube status
```

## Dashboard

``` bash
minikube dashboard
```

## Stop

``` bash
minikube stop
```

## Delete cluster

``` bash
minikube delete
```

------------------------------------------------------------------------

# 5. kubectl Commands

## Cluster information

``` bash
kubectl cluster-info
```

## Nodes

``` bash
kubectl get nodes
```

## Namespaces

``` bash
kubectl get ns
```

## Apply resources

``` bash
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml
```

## Get resources

``` bash
kubectl get all
kubectl get pods
kubectl get svc
kubectl get deployments
kubectl get ingress
```

## Describe resources

``` bash
kubectl describe pod <pod-name>
kubectl describe deployment employee-service
kubectl describe svc employee-service
```

## Logs

``` bash
kubectl logs <pod-name>
kubectl logs -f <pod-name>
```

## Execute into pod

``` bash
kubectl exec -it <pod-name> -- sh
```

## Delete resources

``` bash
kubectl delete -f deployment.yaml
kubectl delete -f service.yaml
```

## Port forward

``` bash
kubectl port-forward svc/employee-service 8081:8081
```

## Restart deployment

``` bash
kubectl rollout restart deployment employee-service
```

## Rollout status

``` bash
kubectl rollout status deployment employee-service
```

## Rollback

``` bash
kubectl rollout undo deployment employee-service
```

------------------------------------------------------------------------

# 6. Helm Commands

## Create chart

``` bash
helm create employee-chart
```

## Validate chart

``` bash
helm lint employee-chart
```

## Render templates

``` bash
helm template employee employee-chart
```

## Install chart

``` bash
helm install employee employee-chart
```

## List releases

``` bash
helm list
```

## Upgrade release

``` bash
helm upgrade employee employee-chart
```

## Rollback

``` bash
helm rollback employee 1
```

## Uninstall

``` bash
helm uninstall employee
```

## Package chart

``` bash
helm package employee-chart
```

## Show values

``` bash
helm show values employee-chart
```

------------------------------------------------------------------------

# 7. End-to-End Workflow

``` bash
mvn clean package

docker build -t employee-service:1.0 .

docker tag employee-service:1.0 <dockerhub-user>/employee-service:1.0

docker push <dockerhub-user>/employee-service:1.0

minikube start

kubectl get nodes

helm install employee employee-chart

kubectl get all

kubectl logs -f <pod-name>

kubectl port-forward svc/employee-service 8081:8081
```
