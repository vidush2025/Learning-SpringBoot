# Internal Working of Spring

1. we avoid using direct objects for every class to avoid tight coupling.
    Ex:
    we won't do something like:
      - private RazorPayPaymentService paymentService = new RazorPayPaymentService();
2. To avoid this, we use "Beans". they let the prog. store beans of all classes, and use them when necessary.
   - "@Component" is used to make Spring framework know that we want to create the bean of a class.
   Ex: see RazorPayPaymentService.java
   - @Component is a kind of "Annotation" (discussed later).

3. we can also use "dependency" for the main class to avoid null pointer exceptions when the bean obj is undefined
"Dependency" means Obj1 must not run or be created without Obj2 as Obj1 is dependent on Obj2.
Thus, to implement this, we created a constructor of the main class in "InternalWorkingOfSpringApplication" with a parameter of "RazorPayPaymentService". This makes sure that the obj. of main class must not be created in the 1st place without the latter. This avoids any Null Exception activity.
// This is an example of "Constructor Dependency Injection".
4. Another kind of dependency injection is "Field Injection". It is done using the "@Autowired" Annotation.
Usage example: we can remove any "@Component" annotation from the definition class and just add
"@Autowired" annotation where the object creation is required. ex- remove @Component from RazorPayPayementService.java and just do (in main file)
@Autowired
private RazorPayPaymentService payementService;
5. You don't need to form a constructor (with params) for main class when you are using Autowired annotation.
6. When we use Constructor DI, we can make any object (like paymentService) as "private final", this maintains complete security for the variable and makes it constant throughout the program. 
BUT we can't do the same while using Autowired DI.
7. DI helps to avoid tight coupling.
8. We use interface to introduce loose coupling between components. 
Here we initially only had RazorPayPaymentService as a service but if we wanted to create a new PaymentService, we would need to change the paymentService everywhere.... This is the effect of tight coupling.

To avoid this, we create the interface PaymentService and implement it on RazorPay and Stripe...

9. We can only have bean of 1 component of the same interface... we initially had @Component on both RazorPay and Stripe, which would cause error as the Spring would not understand which bean to create.
Thus we need to either give @Primary to one class, or remove @Component from one.
This way we introduce loose coupling to our system.
10. Loose Coupling is very very important for easy and efficient necessity for scalable applicaitions.
