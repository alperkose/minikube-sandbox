# Local Docker Registry for minikube

## For mac
Summarised version of [handbook/registry#docker-on-macos](https://minikube.sigs.k8s.io/docs/handbook/registry/#docker-on-macos)

```
# run it once per cluster
# exposes 5000 port on the minikube's virtual machine
minikube addons enable registry

# every time you want to push an image
# redirect 5000 port to minikube's registry
docker run --rm -it --network=host alpine ash -c "apk add socat && socat TCP-LISTEN:5000,reuseaddr,fork TCP:$(minikube ip):5000"

docker tag my/image localhost:5000/myimage
docker push localhost:5000/myimage

```
## Docker Engine in VM (Windows/colima)

Summarised version of [handbook/registry#docker-on-windows](https://minikube.sigs.k8s.io/docs/handbook/registry/#docker-on-windows)

```
# run it once per cluster
# exposes 5000 port on the minikube's virtual machine
minikube addons enable registry


# every time you want to push an image
# Since docker engine is running on VM, we need an extra layer of redirection
kubectl port-forward --namespace kube-system service/registry 5000:80

# redirect 5000 port to minikube's registry
docker run --rm -it --network=host alpine ash -c "apk add socat && socat TCP-LISTEN:5000,reuseaddr,fork TCP:host.docker.internal:5000"

docker tag my/image localhost:5000/myimage
docker push localhost:5000/myimage
```

