# Spring Boot Transaction Rollback Checked Exception

This sample demonstrate transaction rollback on checked exception use case.

## Prerequisites

* Installed java 17 or above.
* Docker engine & cli.
* Mysql Client or Mysql Workbench would work.

## Run Locally

```shell
# Will bring mysql docker container up
./db-up.sh

# Will run the application
mvn spring-boot:run
```

## Test

```shell
curl -X POST -H "Content-Type:multipart/form-data" http://localhost:8080/v1.0/api/csvorders --form file=@sample.csv
```

> [!NOTE]
> `sample.csv` can be found in project repo itself.