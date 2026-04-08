- v1 (Main Branch): Basic Kubernetes deployment 
- v2 (aws-eks-updated): Production-ready AWS EKS architecture with Ingress , Eureka and API Gateway 




This project demonstrates how to build, containerize, and deploy a scalable microservices system using modern DevOps and cloud-native practices.

The system consists of multiple Spring Boot microservices connected via service discovery and routed through a centralized API Gateway.

---

## 🏗️ Architecture

```text
Client
   ↓
AWS ALB Ingress
   ↓
API Gateway (Spring Cloud Gateway)
   ↓
Microservices (ClusterIP Services)
   ↓
PostgreSQL (RDS)
⚙️ Technologies Used
🧠 Backend
Java 17
Spring Boot 3
Spring Cloud
Eureka (Service Discovery)
Spring Cloud Gateway (API Gateway)
Spring Data JPA
🏗️ Architecture
Microservices Architecture
Service Discovery Pattern
API Gateway Pattern
🗄️ Database
PostgreSQL (AWS RDS)
H2 (for local development)
🐳 Containerization
Docker (Multi-stage builds)
☸️ Orchestration
Kubernetes
Deployments
Services (ClusterIP)
ConfigMaps
Secrets
Ingress
☁️ Cloud (AWS)
Amazon EKS (Kubernetes cluster)
Amazon ECR (Docker registry)
Amazon RDS (PostgreSQL)
IAM (Access control)
🔧 DevOps
GitHub Actions (CI/CD)
Maven (Build tool)
🌐 Networking & Routing
AWS ALB Ingress used as the external entry point
All traffic routed to API Gateway
API Gateway performs path-based routing to microservices
🔐 Configuration & Security
Environment variables for configuration
Kubernetes ConfigMaps for non-sensitive data
Kubernetes Secrets for credentials
📦 Microservices
naming-server (Eureka)
api-gateway
currency-exchange-service
currency-conversion-service


kubectl steps required


☸️ Kubernetes & AWS Commands Guide (ALB + Ingress Added)

AWS Load Balancer Controller Setup

**aws sts get-caller-identity**

Verifies AWS authentication.

**aws eks list-clusters --region us-east-1**

Lists EKS clusters.

**kubectl config current-context**

Shows current cluster context.

**kubectl get nodes**

Checks worker nodes.

**helm version**

Checks Helm installation.

**eksctl version**

Checks eksctl installation.

**helm repo add eks https://aws.github.io/eks-charts**

Adds AWS Helm repo.

**helm repo update**

Updates Helm repos.

**eksctl utils associate-iam-oidc-provider --region us-east-1 --cluster
currency-system-cluster --approve**

Enables IAM roles for service accounts (IRSA).

**Invoke-WebRequest -Uri
"https://raw.githubusercontent.com/kubernetes-sigs/aws-load-balancer-controller/v2.14.1/docs/install/iam_policy.json"
-OutFile "iam_policy.json"**

Downloads IAM policy.

**dir iam_policy.json**

Verifies file download.

**aws iam create-policy --policy-name AWSLoadBalancerControllerIAMPolicy
--policy-document file://iam_policy.json**

Creates IAM policy.

**eksctl create iamserviceaccount --cluster=currency-system-cluster
--namespace=kube-system --name=aws-load-balancer-controller
--attach-policy-arn=arn:aws:iam::295504962032:policy/AWSLoadBalancerControllerIAMPolicy
--override-existing-serviceaccounts --region us-east-1 --approve**

Creates IAM role and service account.

**kubectl get serviceaccount -n kube-system
aws-load-balancer-controller**

Verifies service account.

**kubectl describe serviceaccount -n kube-system
aws-load-balancer-controller**

Checks IAM role binding.

**aws eks describe-cluster --name currency-system-cluster --region
us-east-1 --query "cluster.resourcesVpcConfig.vpcId" --output text**

Gets VPC ID.

**helm install aws-load-balancer-controller
eks/aws-load-balancer-controller -n kube-system --set
clusterName=currency-system-cluster --set serviceAccount.create=false
--set serviceAccount.name=aws-load-balancer-controller --set
region=us-east-1 --set vpcId=vpc-0a9a288f28b5af63b --version 1.14.0**

Installs ALB controller.

**helm upgrade aws-load-balancer-controller
eks/aws-load-balancer-controller -n kube-system --set
clusterName=currency-system-cluster --set serviceAccount.create=false
--set serviceAccount.name=aws-load-balancer-controller --set
region=us-east-1 --set vpcId=vpc-0a9a288f28b5af63b --version 1.14.0**

Fix/update install.

**kubectl get deployment -n kube-system aws-load-balancer-controller**

Checks deployment.

**kubectl get pods -n kube-system \| findstr
aws-load-balancer-controller**

Verifies pods.

🧪 Validate Kustomize (Dry Run)

**kubectl apply --dry-run=client -k k8s/common**

**kubectl apply --dry-run=client -k k8s/naming-server**

**kubectl apply --dry-run=client -k k8s/currency-exchange**

**kubectl apply --dry-run=client -k k8s/currency-conversion**

**kubectl apply --dry-run=client -k k8s/api-gateway**

Validates YAML before deployment.

🚀 Deploy to Kubernetes

**kubectl apply -k k8s/common**

**kubectl apply -k k8s/naming-server**

**kubectl apply -k k8s/currency-exchange**

**kubectl apply -k k8s/currency-conversion**

**kubectl apply -k k8s/api-gateway**

Deploys microservices.

📦 Pod Monitoring

**kubectl get pods -n currency-system**

**kubectl get pods -n currency-system -w**

🌐 Services

**kubectl get svc -n currency-system**

**kubectl get endpoints -n currency-system**

🌍 Ingress (ALB)

**kubectl apply -f k8s/api-gateway/ingress.yaml**

Creates ALB via Ingress.

**kubectl get ingress -n currency-system**

**kubectl describe ingress -n currency-system**

**kubectl get ingress -n currency-system -o wide**

Gets ALB DNS.

📊 Cluster Overview

**kubectl get all -n currency-system**

💡 Notes

Make sure api-gateway service is ClusterIP.

Ingress creates ALB, not service.

Wait 1--2 minutes for ALB provisioning.



api-gateway
currency-exchange-service
currency-conversion-service
