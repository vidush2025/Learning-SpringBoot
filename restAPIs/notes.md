# 3 Layered Architecture framework

The client requests goes through to the server and all buisness logic including communication with database can be wrapped up into 3 layers:

1. Presentation Layer -> also called "Controller". Client first sends to request to this layer directly. Client may send request including data like form-data, and fetch calls. It forwards the information to the Service layer using DTO(Data Transfer object).

2. Service Layer -> It uses the DTO to run the main buisness logic for the backend. It analyses, authenticates, verifies  the DTO, and also communicates with the DB using "Entity" or "Model.

3. Persistence Layer -> also called Data-access layer. This Layer communicates directly with the database, and sends, or fetcehs data from the db. It again returns an "Entity" of the db data to the service layer, which returns a new(or updated) DTO to the presentation layer. 

4. Finally the Presentation layer converts the DTO into JSON and sends back to the frontend/client.

-- This method helps in encapsulation and isolation  of data (and the database).

# Lombok annotations
- @Data: helps to create contructors, getters, setters etc and ignore all boiler plate code for all controllers
- @AllArgsConstructor: simply creates a constructur with ALL of the arguments in a DTO/java class.

# @RestController annotation

- creates a bean and helps in mapping of a controller.

- @GetMapping is just like a get request on the desired server port which will return a JSON response to the client. It helps to determine the routes, ex: "/student" 
- 