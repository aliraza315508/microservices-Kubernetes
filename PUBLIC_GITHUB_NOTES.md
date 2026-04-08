# PUBLIC_GITHUB_NOTES

This project has been prepared for public GitHub publication.

## What you must replace before deploying

### Docker / registry image names
Update these image values in the deployment files:

- `YOUR_REGISTRY/naming-server:latest`
- `YOUR_REGISTRY/api-gateway:latest`
- `YOUR_REGISTRY/currency-exchange-service:latest`
- `YOUR_REGISTRY/currency-conversion-service:latest`

### Database values
Update these values in `k8s/common/configmap.yaml` and `k8s/common/secrets.yaml`:

- `CHANGE_ME_DB_HOST`
- `CHANGE_ME_DB_NAME`
- `CHANGE_ME_DB_USERNAME`
- `CHANGE_ME_DB_PASSWORD`

## Safe to publish
The cleaned repo no longer contains:
- Git metadata from your local repository
- IntelliJ project metadata
- compiled `target/` artifacts
- local run logs
- your AWS account ID
- your ECR registry URLs
- your RDS endpoint
- your stored DB password

## Suggested next step
Create a new empty GitHub repository and upload the contents of this cleaned folder, not the original zip.
