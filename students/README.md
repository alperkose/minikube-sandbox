# Students service


## Deployment
First deploy the [postgres](../postgres) server

Before deploying student service, push the secrets to kubernetes cluster:
```shell
kubectl create secret generic db-credentials --from-literal='username=testUser' --from-literal='password=testPassword'
```

Then you can deploy the application:
```shell
kubectl apply -f deploy/deployment.yaml -f deploy/service.yaml
```