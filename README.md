# Drools poc
This project is intended to demonstrate integration of drools and pcf.

#How to deploy to pcf
To deploy this app use following command:

```
cf login -a http://api.pcfhost.com -u user@mail.com
cf push drools-template -f manifest/manifest.yml
```
#How to run locally

From project root directory use following command:
```
mvn spring-boot:run

```

#How to test
Get request to:

```
curl -X GET http://localhost:8080/12345
```
