# substar-api

This is an API for Substar. Substar client will call this endpoint to fetch data.

## Installation
Follow the steps given below to get started with this project's development environment.

## Quickstart
Once you have finished installations above, you can run the application as follows:
1. Clone this repository
```shell script
git clone https://github.com/sinharitwick/substar-api.git
cd substar-api
```
2. Run application in dev mode.
```shell script
./mvnw compile quarkus:dev
```
3. You should get 200 OK status.
```shell script
curl -v http://localhost:8080/q/health
```
## Technology Stack
- Java 21
- [Quarkus](https://quarkus.io/) - base framework
- [Maven](https://maven.apache.org/) - build tool
