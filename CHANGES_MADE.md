# CHANGES_MADE.md

I reviewed the uploaded project and produced a public GitHub-safe version.

## Changes made

- Sanitized k8s/common/configmap.yaml by replacing the real RDS endpoint and database name with placeholders.
- Sanitized k8s/common/secrets.yaml by removing the real database credentials and unused AWS credential placeholders.
- Replaced all hard-coded AWS ECR image URLs with generic registry placeholders in every Kubernetes deployment.
- Cleaned Kubernetes manifests by removing unnecessary DB secret environment variables from api-gateway and currency-conversion, and added the missing DB_NAME variable to currency-exchange.


- Removed `.git/` so your commit history, remote configuration, and local repository metadata are not included.
- Removed `.idea/` so no local IDE metadata is published.
- Removed every `target/` folder and generated jar so compiled artifacts are not uploaded.
- Removed local runtime logs like `run.log` and `run.err`.
- Added a root `.gitignore` suitable for a public Java + Docker + Kubernetes repository.
- Added a public `README.md` explaining the project, placeholders, and deployment order.
- Added `PUBLIC_GITHUB_NOTES.md` as a quick checklist.
- Added `k8s/common/secrets.example.yaml` so there is a template for secret creation.
- Left application source code and Dockerfiles intact because they do not expose your personal credentials.

## Important
This cleaned version is safe to publish as a template or portfolio project, but it is not deployment-ready until you replace the placeholder image names and database values with your own infrastructure values.
