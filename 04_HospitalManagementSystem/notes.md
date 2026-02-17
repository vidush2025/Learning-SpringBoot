# SPRING DATA JPA
JPA stands for Jakarta Persistence Layer for Java Springboot which helps us to communicate qwith the backend.
It is a Springboot library, and a dependency through which we can easily run queries and communicate with the database whenevery required.
It helps to CRUD data in different tables in a database configured for our application.

# Testing on Springboot
We can easily run tests for code and also perform DB queries for testing using the "@SpringbootTest" annotation. It represents that the mentioned class is a test class. To run any test function, we just need to add the "@Test" annotation above its definition. A test function runs directly in the code as a script and does not need the to be called using entities/DTOs etc. 

NOTE: The return typeof any test function must be void because the test functions just read data and cannot return anything specifically. 


# @ToString annotation
This annotation helps to easily print or return our Entity data in string format. By default, for a statement like:

    List<Patient> patients = patientRepository.findAll();

The patients will have data a link and a hexcode for the entities that the backend returns. We mostly don't want a returned data like this. The @ToString annotation above any Entity helps SpringBoot to understand that we need data in a mapped form for easier reading, updating and understanding.

If we have the annotation above the Patient schema definition, will return data like:
    
    List of Patients:[Patient(id=1, name=Vidush1, sex=male, email=vidush1@gmail.com)]

We can exclude any field to NOT be returned, we can explicitly put the "@ToString.Exclude" annotation, and that field will NOT be returned in the above response. 

