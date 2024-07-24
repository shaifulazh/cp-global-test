Demo Spring Boot for JAVA programming using JAVA SRPING with HIBERNATE ORM and H2 in-memory DB


Requirment to run

maven version 3.9.1
java 22


To run spring boot

```
    mvn spring-boot:run
```


RestAPI for Employee CRUD

1. Create Employee

```
curl --request POST \
  --url http://localhost:8080/api/employee \
  --header 'Content-Type: application/json' \
  --data '{
	"employeeID": "00001",
	"employeeName": "myname",
	"department": "IT",
	"dateOfBirth": "04-09-2023",
	"email": "test@test.com",
	"phoneNumber": "0123456789"
}'
```

2. Get All Employee

```
curl --request GET --url http://localhost:8080/api/employee 
```

3. Get 1 by id 

```
curl --request GET --url http://localhost:8080/api/employee/1 
```

4. Update by Id

```
curl --request PUT \
  --url http://localhost:8080/api/employee/1 \
  --header 'Content-Type: application/json' 
  --data '{
	"employeeID": "00001",
	"employeeName": "udpate name",
	"department": "udpate IT",
	"dateOfBirth": "01-01-2003",
	"email": "test@test.com",
	"phoneNumber": "0123456789"
}'
```

5. Remove/Delete by ID
```
curl --request DELETE --url http://localhost:8080/api/employee/1 
```