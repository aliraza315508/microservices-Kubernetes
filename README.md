# Currency System Microservices

Public GitHub-ready version of a Spring Boot microservices project with Docker and Kubernetes manifests, cleaned to remove personal Docker, AWS, Kubernetes, and local machine information.

## Services

- **naming-server** — Eureka service registry
- **api-gateway** — Spring Cloud Gateway entry point
- **currency-exchange-service** — exchange-rate service backed by PostgreSQL
- **currency-conversion-service** — conversion service that calls the exchange service

## Tech stack

- Java 17
- Spring Boot
- Spring Cloud Netflix Eureka
- Spring Cloud Gateway
- Maven
- Docker
- Kubernetes with Kustomize
- PostgreSQL

## Project structure

```text
.
├── naming-server/
├── api-gateway/
├── currency-exchange-service/
├── currency-conversion-service/
└── k8s/
    ├── common/
    ├── naming-server/
    ├── api-gateway/
    ├── currency-exchange/
    ├── currency-conversion/
    └── ingress/
```

## Before you publish or deploy

This repo is already cleaned for public GitHub, but you still need to replace the placeholders below with your own values before deploying:

- `YOUR_REGISTRY/naming-server:latest`
- `YOUR_REGISTRY/api-gateway:latest`
- `YOUR_REGISTRY/currency-exchange-service:latest`
- `YOUR_REGISTRY/currency-conversion-service:latest`
- `CHANGE_ME_DB_HOST`
- `CHANGE_ME_DB_NAME`
- `CHANGE_ME_DB_USERNAME`
- `CHANGE_ME_DB_PASSWORD`

## Local run order

Start these services in this order:

1. `naming-server`
2. `currency-exchange-service`
3. `currency-conversion-service`
4. `api-gateway`

## Build each service

```bash
cd naming-server && ./mvnw clean package
cd ../currency-exchange-service && ./mvnw clean package
cd ../currency-conversion-service && ./mvnw clean package
cd ../api-gateway && ./mvnw clean package
```

## Docker image example

Build and tag with your own registry:

```bash
docker build -t YOUR_REGISTRY/naming-server:latest ./naming-server
docker build -t YOUR_REGISTRY/currency-exchange-service:latest ./currency-exchange-service
docker build -t YOUR_REGISTRY/currency-conversion-service:latest ./currency-conversion-service
docker build -t YOUR_REGISTRY/api-gateway:latest ./api-gateway
```

## Kubernetes deploy order

```bash
kubectl apply -k k8s/common
kubectl apply -k k8s/naming-server
kubectl apply -k k8s/currency-exchange
kubectl apply -k k8s/currency-conversion
kubectl apply -k k8s/api-gateway
kubectl apply -k k8s/ingress
```

## Notes

- `k8s/common/secrets.yaml` now contains placeholders only.
- AWS account IDs, ECR registry URLs, RDS endpoint values, local logs, and Git metadata were removed.
- This repo is intended to be a safe starting point for a public portfolio project.
