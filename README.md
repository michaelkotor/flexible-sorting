# Student sorting

### Backend

Java, Spring.

http://localhost:8080/swagger.html - easily access Swagger UI

To add a new implementation of sorting follows SOLID open-closed principle, 
just add a new implementation of **SortingService**, 
register with annotation **@Service("name at the UI")**.

That is basically it.

You can start it as a java application or in docker. 

```./mvnw spring-boot:build-image``` - this will create an image


### Frontend

Has the ability to upload file and see the result after hitting the button.

http://localhost:8081/