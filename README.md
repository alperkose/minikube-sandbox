# minikube-sandbox
Minikube sanbdox for experimentation


# minikube setup

On mac setup socket_vmnet:
```shell
brew install socket_vmnet
sudo brew services start socket_vmnet
minikube start --driver qemu2 --network=socket_vmnet
```
For other follow standard setup:
```shell
minikube start
```

Install addons:
```shell
minikube addons enable registry
minikube addons enable ingress
```



