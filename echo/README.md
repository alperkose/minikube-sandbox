# Playing with Echo service

Deploy echo service to a namespace called `demo`

```shell
kubectl apply -n demo -f namespace.yaml -f deployment.yaml -f service.yaml -f ingress.yaml
```

After the deployment, you need to update your network hosts file and add IP of minikube (_run_ `minikube ip`). 
The ingress controller defines the host name as `echo.minikube` so adding a mapping to your hosts file 
will act like a local DNS.

Assuming the IP of minikube is `192.168.105.2`, your hosts file should look like similar to below:
```
127.0.0.1	localhost
255.255.255.255	broadcasthost
::1             localhost

192.168.105.2	echo.minikube
```
After that you can open your browser and go to http://echo.minikube and see the response

For Linux or Mac users, curl let's you send a request without editing hosts file
```shell
 curl --resolve "echo.minikube:80:$( minikube ip )" -i http://echo.minikube
```
## Experimentation
Check the deployment
```shell
# shows running pods
kubectl get pods -n demo
# shows deployments
kubectl get deployments -n demo
# shows services
kubectl get services -n demo
# shows ingress setup
kubectl get ingress -n demo
```
Delete the pod and observe that a new one will be provisioned
```shell
# use pod name from the command `kubectl get pods`
kubectl delete -n demo pod echo-......
```
Change number of running pods (i.e `replicas`) by modifying deployment yaml and re-deploying

Or change it via command line
```shell
kubectl scale -n demo --replicas=3 deployment/echo
```