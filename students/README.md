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
kubectl apply -f deploy/config.yaml -f deploy/deployment.yaml -f deploy/service.yaml -f deploy/ingress.yaml -n students
```

Before sending a request to the application, you have to edit the `/etc/hosts` (or equivalent hosts file on Windows) 
and add the minikube ip for the domain `students.minikube`. Assuming the IP of minikube is `192.168.105.2`, your hosts file should look like similar to below:
```
127.0.0.1	localhost
255.255.255.255	broadcasthost
::1             localhost

192.168.105.2	students.minikube
```

## Sending requests to the application
Go to the [http file](students-rest.http) if you're using IntelliJ

Create a new student:
```http request
POST http://students.minikube/students
Content-Type: application/json

{
  "id": 1,
  "name": "Primus"
}

```

Query a student:
```http request
GET http://students.minikube/students/1
```