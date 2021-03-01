# Java Persistence API (JPA): 1 The Basics
 JPA makes it very easy to map objects to relational databases and vice versa.
 
## 1. Understanding API
### What is Persistence?
```
Persistence refers to information that continues to exist in a database,
even after the process or application that created it is no longer running.
```

Unlike data that is stored "in-memory" and disappears after a program shuts down, data that is persisted exists across time. 
And can live independent of the system that created it.

### ORM
ORM, is the bridge that connects two totally separate islands allowing them to communicate and share information. 
The two islands in question are Java and relational databases.

The process of object relational mapping is often delegated to external tools or frameworks. 
In Java EE, this framework is called Java Persistence, API, JPA.  

### JPA Overview
JPA is an abstraction on top of JDBC,
that makes it easy to map objects to relational databases and vice versa.

The mapping between Java objects and database tables is defined via the persistence metadata. 
 The JPA instance provider uses the persistence metadata information to perform the correct database operations.
 
### JPA configuration and entities
##### Tip
```
Starting with Spring 3.1, the persistence.XML is no longer necessary,
because Spring can scan all packages looking for entities described by the @Entity annotation. 
JPA can be fully setup with no XML which is very convenient. 
```     

- **@Entity** defines that a class can be mapped to a table. 
- **@Table** is the name of the underlying table this entity is mapped to. 
- **@Id** marks a field as a primary key field. 
- **@GeneratedValue** generates a unique identifier for the entity. 
- **@Column** changes the name or length for any column in the database.

#### JPQL
JPQL is a layer on top of SQL so you will see that the syntax is slightly different but familiar.

##### Tips
```
JPQL returns results as a collection of entities.
```     
```
JPA doesn't support schemaless or NoSQL databases.
```
#### Key Takeaways:
1. JPA allows you to maintain persistence without having to write JDBC or SQL code. 
2. Use anotations instead of XML to define the persistence metadata.

### JPA over pure JDBC
JDBC is a low level Java API that provides the ability to interact with relational databases.

instead of a lot of steps and code to connect to DB using JDBC, 
JPA allows you to do this by a As a higher-level of abstraction, JPA maps Java objects and code to database tables.

##### Tip
```
When dealing with relational DB, under the hood, 
JPA writes SQL and use JDBC to read/write from/to DB tables.
```

## Managing Entities and EntityManagers
### EntityManager
The JPA is quite useless, without the EntityManager. 
The EntityManager API's use to create and remove entity instances to find entities by their primary key and to query over entities.
```
 Remember entities are objects that live in a database and have the ability to be mapped to a database. 
We've learned that the persistence.xml, 
is no longer necessary when using Spring and all packages are scanned looking for entities described by the @entity annotation.
```
The key takeaway is that the EntityManager API is very important, when persisting entities using the JPA.

### Creating objects
##### Persist Method
- make the entity managed and persist in DB.
** in the DAO or Repository layer (implementation)**
``` 
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addApplication(Application application){
        entityManager.persist(application);
    }
```

### Reading/Updating/Deleting objects
Tip
```
Example of ResponseEntity in another form:

public ResponseEntity<Application> getApplicationById(@PathVariable Integer id){
    Application application = applicationService.getClassById(id);
    return new ResponseEntity<Application>(application, HttpStatus.OK);

@PostMapping
public ResposneEntity<void> create(@RequestBody Application application) {
    HttpHeaders headers = new HttpHeaders();
    header = ....; 
    ......
    return new ReposneEntity<void>(headers, HttpStatus.CREATED);
}

@PutMapping("/applicaiton")
public ResposnseEntity<Application> updateApplication(@RequestBody Application application){
    applicatioService.updateApplication(application);
    return new ResponseEntity<Applicaiton>(applicaiton, HttpStatus.OK);
}

@DeleteMapping("/application/{id}")
public ResponseEntity<void> deleteApplication(@PathVariable Integer id) {
    applicationService.deleteApplication(id);
    return new ResponseEntity<void>(HttpStatus.NO_Content);     
```

**in DAO or Repository layer (implementation)**
```
    @PersistenceContext
    EntityManager entitiyManager;

    @Override
    public void addApplication(Application application){
        entityManager.persist(application);
    }

    @Override
    public boolean isPersist(Integer id, String name) {
        Stirng jpql = "from Applicaitons as a where a.id = ? and a.owner = ?"; 
        int count = entityManager.createQuery(jpql).setParameter(0, id).setParameter(1, name);
        return count > 0;
    }

    @Override
    public Application getApplicationById(int applicationId) {
        return entityManager.find(Applicaiton.class, applicationId);
    }

    @Override
    public void updateApplication(Application application) {
        Application app = getApplicationById(application.getId());
        app.setName(application.getName());
        entityManager.flush();
    }

    @Override
    pulic void deleteApplication(int applicationId){
        entityManager.remove(getApplicationById(applicationId));
    }
// the flush method synchronizes the persistence context to the underlying database.
```
## 3. TRansaction Management
### Entity lifecycle
#### Entity States
1. Managed.
    - The entity is under control of the EntityManager
2. Detached.
    - The final state for an entity (either removed, flushed, or committed). 
    - Once an entity is detached, the object will continue to live in memory until the garbage collector gets rid of it. 
    
**What are the four lifecycle states for an entity?**
    Persisting, Updating, Removing, and Loading    

**Note:**
When an **entity** is under the control of the **EntityManager**, 
any updates made to the entity using its setter methods are automatically synchronized with the database.

#### Transaction    
Allowing you to group several operations as a single unit, 
that will all either succeed or fail together as a group.

**Java Transaction API (JTA)**     

JTA is a general API for managing transactions in Java. 
It allows you to start, commit, and roll-back transactions seamlessly. 
This is because the entity manager cooperates with the JTA transaction manager transparently for us.

**@Transactional**
Can be added to a class or a method.
Now, behind the scenes spring creates a proxy for the ticket class,
allowing it to inject transactional logic before and after the method is invoked.

#### Advanced mapping using annotation

**In order for a class to be considered a JPA entity at a minimum it needs:**
 - the @Entity annotation.
 - a public or protected no argument constructor.
 - the class must NOT be declared final
 - no methods or persistent instance variables must be declared final. 
 - The @Entity annotation identifies that this job or class can be assisted to the database.  
 - every entity must have a primary key.
 
 **Advanced Mapping**
  - Configuration by exception.
  - Convention over configuration.
  
 **Default Mapping Rules**
  - Entity --> Table name
  - Id --> Primary key
  - Attributes --> Columns
  
 **Attribute Mapping** 
   - String --> varchar(255)
   - Long --> BIGINT
   - Boolean --> SMALLINT
   
 **Customizations**
  - Columns name
  - Table name
  - Required Fields
  - Max length  
  **example:**
    - @Table(name = "")
    - @Column(name = "", length = 2000)
    
As of JPA 2.2 basic support is provided for Java 8 Date and Time Types. 
There's no longer a need to write attribute convertors to perfrom mapping from database date and time types to Java 8 date and time types and vice versa.
   **example:**
     private LocalDate openDate;
**@Transient**
If we didn't want these field mapped, we could simply use the @transient annotation.        
   **example:**
   @Transient
   private int lengthOpened;
 
## Relationship Mapping in JPA
```
    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application

    @ManyToOne
    @JoinTable(name = "ticket_release", 
              @joinColumns = @JoinColumn(name = "ticket_fk"),
              @inverseJoinColumns = @JoinColumn(name = "release_fk"))
    private Release release; 
```
**@JoinColumn**
 - Foriegn Key Relationship
 - For Performance (// in case we have @ManyToOne)
 
**@JoinTable**
 - Third tale is needed.
 - Reduces redundancy (// in case we have @ManyToOne)
 
## Mapping associations overview   
 - @OneToOne annotation, each entity instance is related to a single instance of another entity. 
- @OneToMany, an entity instance can be related to multiple instances of the other entities. 
- @ManyToOne multiple instances of an entity can be related to a single instance of the other entity. All of our examples up to this point have been ManyToOne.
- @ManyToMany, the entity instances can be related to multiple instances of each other. 
    