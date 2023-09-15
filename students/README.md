# Students service


## Deployment
First deploy the [postgres](../postgres) server


Before you deploy anything, the docker image should be pushed to registry. Follow [instructions](../minikube-registry.md) to enable registry. Then push the docker image after building a fresh one:
```shell
docker build -t localhost:5000/demo-students .
docker push localhost:5000/demo-students
```

Then you can deploy the application:
```shell
# one time task: create the namespace
kubectl apply -f deploy/namespace.yaml

# one time task: Before deploying student service, push the secrets to kubernetes cluster:
kubectl create secret generic db-credentials --from-literal='username=testUser' --from-literal='password=testPassword' -n students

# deploy the application
kubectl apply -f deploy/config.yaml -f deploy/deployment.yaml -f deploy/service.yaml -n students
```