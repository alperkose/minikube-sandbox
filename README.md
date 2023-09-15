# minikube-sandbox
Minikube sanbdox for experimentation


# minikube setup
Standard `minikube start` command caused some problems while dealing with ingress and docker push 

On mac, [qemu](https://minikube.sigs.k8s.io/docs/drivers/qemu/) based setup worked:
```shell
brew install socket_vmnet
sudo brew services start socket_vmnet

minikube start --driver qemu2 --network=socket_vmnet
```
For Windows using [Hyper-V](https://minikube.sigs.k8s.io/docs/drivers/hyperv/) is solved the issues
```shell
# requires administrator access and will cause restart
Enable-WindowsOptionalFeature -Online -FeatureName Microsoft-Hyper-V -All

minikube start --driver=hyperv 
```

Install addons:
```shell
minikube addons enable registry
minikube addons enable ingress
```



