currency-conversion-Kubernetes-steps

1.Intelli j

mvn spring-boot:build-image -DskipTests  (build the image)

2.Docker Desktop
enable kubernetes


3.PowerShell
docker login

docker push 03155082725/md1-currency-conversion-service:0.0.11-SNAPSHOT(Image id from docker images)


4.Go to aws cloud shell

install kubectl

kubectl version (for safety check )


kubectl create deployment currency-conversion --image=03155082725/md1-currency-conversion-service:0.0.11-SNAPSHOT

kubectl expose deployment currency-conversion --type=LoadBalancer --port=8100



through YAML declaration
from the root folder run
kubectl apply -f k8s/currency-conversion/
