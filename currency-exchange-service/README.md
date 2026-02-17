1.Docker Desktop
enable kubernetes


2.PowerShell
docker login

docker push 03155082725/md1-currency-exchange-service:0.0.11-SNAPSHOT(Image id from docker images)


3.Go to aws cloud shell

install kubectl

kubectl version (for safety check )


kubectl create deployment currency-exchange --image=03155082725/md1-currency-exchange-service:0.0.11-SNAPSHOT

kubectl expose deployment currency-exchange --type=LoadBalancer --port=8000



4.Through YAML declaration
from the root folder run
kubectl apply -f k8s/currency-exchnage/