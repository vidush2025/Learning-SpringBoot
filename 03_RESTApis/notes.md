# 3 Layered Architecture framework

The client requests goes through to the server and all business logic including communication with database can be wrapped up into 3 layers:

1. Presentation Layer → also called "Controller". Client first sends to request to this layer directly. Client may send request including data like form-data, and fetch calls. It forwards the information to the Service layer using DTO(Data Transfer object).

2. Service Layer → It uses the DTO to run the main business logic for the backend. It analyzes, authenticates, verifies  the DTO, and also communicates with the DB using "Entity" or "Model.

3. Persistence Layer → also called Data-access layer. This Layer communicates directly with the database, and sends, or fetches data from the db. It again returns an "Entity" of the db data to the service layer, which returns a new(or updated) DTO to the presentation layer. 

4. Finally, the Presentation layer converts the DTO into JSON and sends back to the frontend/client.

-- This method helps in encapsulation and isolation  of data (and the database).

# Lombok annotations
- @Data: helps to create contractors, getters, setters etc and ignore all boiler plate code for all controllers
- @AllArgsConstructor: simply creates a constructor with ALL the arguments in a DTO/java class.

# @RestController annotation

- creates a bean and helps in mapping of a controller.

- @GetMapping is just like a get request on the desired server port which will return a JSON response to the client. It helps to determine the routes, ex: "/student" 

# @RequiredArgsConstructor
- creates a constructor automatically for all "private final -" variables


# BASIC FLOW OF CLIENT <-> DB 

- The client sends a request to persistent layer using a RestAPI(get, post etc.),which is handled by a controller, here StudentController.
- The controller is like a route file and NOT like a JavaScript controller where we have all business logic in the controller. The controller ONLY MAPS the client request to the correct service.
- When a service interface is called, the service class performs all business logic and functions, and connects with the repository (database) for data communication.
- This helps in maintaining a block between client and database.
- Finally, the repository directly handles database quires, and sends data to the service, which sends DTO to the controller.
- The controller then sends back the data to the client as a JSON response.

CLIENT --RestAPI → CONTROLLER --Mapping & DTO → SERVICE --Entity→ REPOSITORY --Query→ DATABASE --Query Results→ REPOSITORY --Entity→ SERVICE --Result DTO→ CONTROLLER --Response JSON→ CLIENT


# @PathVariable

- Used to send dynamic parameter requests in api calls, for example, sending "id" for a getStudentById api call
- Can be used to fetch only relevant and filtered data from the database

# ModelMapper

- This maps one Database schema/entity to another(ex: Student → StudentDto)
- It uses the field names in the entity definition to map the elements, that's why the two entities must have similar/same field names in the class definition.
- It also requires the "@NoArgsConstructor" annotation to map the entities properly, otherwise throws error
- ModelMapper is a very reusable and efficient Springboot library/dependency, thus can be placed in the "config" folder so that it may be accessed by all the service classes when needed.

# ResponseEntity<>
A response entity is a JAVA class used to send structured responses to the frontend. We can combine this with modelMapper to create instant new DTOs and send our response to the frontend for further processing. A Response entity can send our desired HTTP status code (like 200, 401, 404 etc.), with a response body containing the response dto, and also a message if we want. Nothing is required, a responseEntity can also be of void type. So it is very flexible to use and communicate with the frontend.

# HTTP Codes
Important HTTP codes are required to maintain structure and a consistent, no-confusion communication with the frontend. HTTP codes can be sent directly using the ResponseEntity<> and can be read about in the HttpStatus.class.
Some popular and commonly used HTTP codes are:
1. 200: OK,
2. 201: CREATED,
3. 401: UNAUTHORIZED, etc.


# Validity Annotations
These are used to validate incoming input correctly and consistently before performing any heavy backend operations. 
Some validity related annotations like @Email, @Size, @NotBlank etc. can be used in the class definition of any DTO, or entity, which represent the validity constraints of the fields in the class.

Ex: @Size(min = 3, max = 30, message = "Name should consist of 3-30 characters")
    String name

This denotes that the name field in the class MUST contain 3-30 letters only. Using the validity annotations, we can also directly send the error message with complete consistency and flexibility as we can design our own Error messages.

@Valid annotation is used to Validate the input given from client BEFORE even the controller function is executed. This finds out if the current input properly matches the validity annotations described in the DTO/Class, and throw Errors if required. This happens before any line of that controller function is even executed, performing immediate error response.
