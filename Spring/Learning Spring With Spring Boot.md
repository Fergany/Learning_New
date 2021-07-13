Course Link:
https://www.linkedin.com/learning/learning-spring-with-spring-boot-2/

Spring Framework:
=================
- Framework for providing comperhensive infrastructural support for developing Java applications.
- Provides the plumbing (focus on the buz)  
- OOP best practices built-in.
- DRY principle.

Some Definitions:
==================
- POJO - object that has state and behavior.
- JavaBeans - Simple objects with only getters and setters.
- Spring Beans - POJOs configures in the applicaiton context.
- DTO - Bean used to move state between layers.
- IoC 
  ====
  - One of the core aspects of the Spring Framework.
  - IoC provides mechanism of dependency injection.
  - ApplicaitonContext (IoC container), wraps the BeanFactory, which serves the beans to the runtime of the application.
  - Spring Boot provides auto-configuration of the ApplicationContext.


So, we’ve to create an object with new keyword. But Spring has a magical annotation called Autowired. 
Basically, Spring has an ApplicationContext where it already stores objects of the classes which are marked with annotations like Service, Component, etc. 
Whenever you need objects of such classes, use Autowired, it’ll give them to you.


java.lang.IllegalStateException: Failed to load ApplicationContext
No identifier specified for entity: com.example.todo.ToDo
This is because Hibernate is unable to interact with our Entity. To make it interact: create default, parametrized constructers and getters-setters for both the fields. 
Create a primary key id which gets generated each time by the JPA.

Spring Boot:
============
- Supports rapid development.
- Remove boilerplate of application setup.
- Many uses.
  Spring Boot only applies to web applications, 
  While it does fit in this model of web applications very well, Spring Boot can be used for batch processing, cron jobs, ETL type work, asynchronous messaging systems, and the list goes on.
- Cloud native support.

Key Components:
- Embedded Tomcat (or others).
- Embedded databases support and hibernate / JBS dialect.
- Auto-configuration of ApplicationContext.
- Automatic servlet mappings.
- Automatic controller mappings.


Create a prj with Spring Initializr
- start.spring.io
- dependencies

Create a prj with IDE
- in the cmd line:
```
    mvn clean package
    java -jar target/bla-bla-1.0.0.jar
```

Spring Boot Skelton
====================
- pom.xml 
- the main class src/main
- test folder src/test

- src/main/resources/application.properties
- target

And this is the Maven Spring Boot plugin. This plugin is what actually generated the JAR file that we previously used to execute our application. 

- @SpringBootApplication
This annotation designates this file as a configuration file,
as well as the starting of all of component scanning. 
It also initiates auto-configuration that is part of Spring Boot itself.

- application.properties
	u can replace it by .yml file.

Embedded DB with Spring Boot:
----------------------------
in pom.xml:



in the properties file:
spring.jpa.hibernate.ddl-auto=none
#tell the hibernate don't generate any table we already done this for you.


Spring Data
===========
- Provides a common set of interfaces for interacting with SQL or NoSQL data store.
- Provides a common naming convention.
- Provides aspected behavior. (Aspecting or Proxies are how Spring Data provides behavior.)
- Provides repostiory and data mapping convention.

- Remove boilerplate code.
- Makes swapping data sources easier.
- Allows you to focus on buz logic.

There are two primary components for all Spring Data operations. 
The first is the repository interface. This is a primary construct for interacting with data access across Spring Data. 
The second is the entity object. This provides the data object from representing the table or document from the database. 

The repository relies on the entity for its template definition. So the two are tied together, but both serve a distinct purpose in Spring Data.

Embedded databases should not be used for production workloads as they only live as long as the application.

**Entity**

```
    package com.frankmoley.lil.learningspring.data.entity;

    import javax.persistence.*;
    
    @Entity
    @Table(name="ROOM")
    public class Room {
        @Id
        @Column(name="ROOM_ID")
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long roomId;
        @Column(name="NAME")
        private String roomName;
```

**Repository**

```
    package com.frankmoley.lil.learningspring.data.repository;
    
    import org.springframework.data.repository.CrudRepository;
    import org.springframework.stereotype.Repository;
    
    @Repository
    public interface RoomRepository extends CrudRepository<Room, Long> {
    }
```

**Controller**

```
    @SpringBootApplication
    public class LearningSpringApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(LearningSpringApplication.class, args);
        }
    
        @RestController
        @RequestMapping("/rooms")
        public class RoomController{
            @Autowired
            private RoomRepository roomRepository;
    
            @GetMapping
            public Iterable<Room> getRooms(){
                return this.roomRepository.findAll();
            }
    
        }
```

### Service Tier

#### Dependency Injection

- Allows you to focus on the contracts.
- Develop buz code only, leave the construction to the container.
- Build intermediate abstraction.
- Produce clean code.

How Spring Does Dependency Injection?
- IoC container is configured by developer.	
this configuration can be through Java config, component scanning with annotations, auto-configuration, or through XML
- Developer only configures ApplicationContext.

- Spring maintains handles to objects contructed at startup.
- Spring serves singletons to classes during construction.
- Spring maintains lifecycle of beans.


Service Abstraction
-------------------

Service Object
--------------
So, we're just going to allow it to be component scanned. So, I'm going to set this to be an @Service. Now, @Service is just a stereotype of @Component, which allows component scanning to occur. 

But, again, you could also just do @Component, it will work just fine. 
The other thing that I like to do is go ahead and auto-wire my constructor. Now, this is technically not required. Since there's only one constructor, Spring will use it by default and assume it has all of the beans to find in the application context. 
However, I get a couple benefits by specifying the @Autowired on my constructor. 
Number one, my IDE is smart enough to know if I've defined that bean in the application context that would run with this application, so it would give me a warning that it doesn't know of that bean type. 
The other benefit that I get from that is it's very clear to me which constructor is being called at any point in time and if someone comes in and adds another constructor, they would have to make that change to make that the auto-wired constructor.

Controller
==========
MVC => Fundamental pattern for web application development.
Model (data).
View (visual display that is populated).
Controller (wires the view with the model).

Spring Controller
-----------------
(The heart of spring application.)
Spring Bean
Annotated for the servlet mapping.
Respond to incoming web requests.
Output a view or raw data.

Template Engines
----------------
- Spring support several.
- Thymeleaf - most popular.
- Provides a DSL for HTML, leaving raw HTML documents.




Build your first controller
===========================


Thymeleaf as a rendering engine
===============================

Test a controller MockMVC
=========================
@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RoomReservationWebcontroller.class)

public class RoomReservationWebcontrollerTest{
	@MockBean
	private ReservationService reservationService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getRservations() throws Exeception{
		
	}		
	
}

RestController:

- Spring uses controller for RESTful web services.
- Just another MVC, only our view is JSON.
- Spring marchals JSON for you.
- u can configure XML if desired.

























