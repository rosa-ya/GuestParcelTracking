# Parcel Microservice Tracker
#General info
* It is Java  Micro-Service Application, utilizing Spring Boot
* It has test automation for unit testing and integration testing
* Spring data jpa (JpaRepository) is used to perform save and searching .
* Update the access keys in application.properties file

# Swagger api  
* SwaggerConfiguration.java can be connected on http://localhost:8082/swagger-ui/index.html# when application is running.

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
It will create parcelMicroservice-0.0.1.jar in target folder.
* java -jar parcelMicroservice-0.0.1.jar
* It is a SpringBoot project and can be simply executed as a java project from ParcelMicroserviceApplication.java class. 

 
# Methods
## check parcel availability for guest and get list of parcels
### http://localhost:8082/parcel-microservice/parcel/{guestId}

## add parcel to Database
### http://localhost:8082/parcel-microservice/parcel
Sample Request Body
```json
{
   "guestId": 2,
   "parcelCode": "Parcel356",
   "delivered": false
}
```
 

 
# H2 DATABASE  
### JDBC URL - jdbc:h2:mem:hrsdb
* DB configuration is available in application.properties.
*On startup spring boot will read the [data.sql](src/main/resources/data.sql) file and execute the contents.

#TESTING   
Mockito is used fot unit testing.



