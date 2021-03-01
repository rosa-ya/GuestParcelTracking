# Guest Microservice Tracker
#General info
* It is Java  Micro-Service Application, utilizing Spring Boot
* It has test automation for unit testing and integration testing
* Spring data jpa (JpaRepository) is used to perform save and searching .
* Update the access keys in application.properties file

# Swagger api  
* SwaggerConfiguration.java can be connected on http://localhost:8081/swagger-ui/index.html# when application is running.

#Technologies
1. Spring boot jpa, starter, tomcat etc.
2. Junit for testing
3. H2 for database.
4. Springfox for swagger api.
5. Netflix Eureka service registry 
6. lombok
7. mapstruct
8. Spring Cloud Netflix Feign Client
9. Maven

#How it builds
* mvn package OR mvn clean compile package install.
It will create guestMicroservice-0.0.1.jar in target folder.
* java -jar guestMicroservice-0.0.1.jar
* It is a SpringBoot project and can be simply executed as a java project from GuestMicroserviceApplication.java class. 

 
# Methods
## Check Guest Availability for Taking Parcel
### http://localhost:8081/checkGuest/{firstName}/{lastName}
Sample Request Body
```json
{
   "guestId": 2,
   "parcelCode": "Parcel356",
   "delivered": false
}
```

## check Parcel and Deliver it
### http://localhost:8082/checkAndDeliverParcel/{firstName}/{lastName}
 
 

 
# H2 DATABASE  
### JDBC URL - jdbc:h2:mem:hrsdb
* DB configuration is available in application.properties.
*On startup spring boot will read the [data.sql](src/main/resources/data.sql) file and execute the contents.

#TESTING   
Mockito is used fot unit testing.



