Learning Quarkus
================
what Quarkus is?
it's a full stack Java framework.
You can build web applications, web services, standalone components all written in Java with Quarkus.
Anything you can do with Java, you can obviously do with Quarkus but the extensions and configurations that we will discuss is where the power really comes in.
The full stack framework concepts includes many of these extension points.

Designed for developers
=======================
- Designed to be easy to use from the start
- Developer choice the extensions.
- Live coding functionality built in.
- Unified configuration.


Container First
===============
- Low memory usage (90%)
- Faster startup times.

DI
===
- instead of creating the obj, you just define the class.
- let the container responsible for the construction.

Quarkus DI
==========
- Context and DI (called CDI).
- Beans managed by container.
- @ApplicationScope on the class and @Inject when define the class.

Command mode Quarkus
====================
Why command Mode?
- Power of Java
- Power of Quarkus
- Common abstractions.
- Write to DB, write to queries, call services.


Configuration properties in Quarkus
===================================
- Can be modified at the startup time.
- to get value from properties:
```
    @ConfigProperty(defaultValue = "def", name = "app.valu.ee")
    String value;
```


Logging in Quarkus
===================
- jboss is the default logging framework.
- in the properties file:
    quarkus.log.level=DEBUG // INFO is the default
  
Data access in Quarkus
=====================
- The primary purpose is to wire data source.
- Configuration managed by Quarkus.
- Other framework used for data access itself.

Agroal Extension
================
- Preferred datasource extension.
- Preferred connection pooling extension as well.

Data Source configuration
=========================
- db-kind
```
   quarkus.datasource.db-kind  #common names like Postgres, MySQL 
   quarkus.datasource.username
   quarkus.datasource.password
   quarkus.datasource.jdbc.url
   quarkus.datasource.jdbc-max-size 
```

#### Consuming the datasource
- AgroalDataSource instance.
- Injected from CDI
- AgroalDataSource is a subtype of java.sql.DataSource

#### Mulitple datasources
    - quarkus.datasource.{name} # provide here some name and then continue the configuration.
    ex: quarkus.datasource.blabla.db-king
        quarkus.datasource.blabla.username # and so on
    and when inject the datasource
    @Datasource({name})

## External RDS databases
- adding these dependencies
```
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-agroal<artifactId>
    </dependency>
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-jdbc-postgresql<artifactId>
    </dependency>
```
- application.properties
```
    quarkus.datasource.db-kind=postgresql
    quarkus.datasource.username=postgres
    quarkus.datasource.password=postgres
    quarkus.datasource.jdbc.url=jdbc:possgresql://localhost:5432/
    quarkus.datasource.jdbc.max-size=16 
```

### Quarkus and Hibernate
```
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-agroal<artifactId>
    </dependency>
    <dependency>
        <groupId>io.quarkus</groupId>
        <artifactId>quarkus-hibernate-orm<artifactId>
    </dependency>
```

in code 
```aidl
    @Inject
    EntityManager entityManager;
    
    
```

properties file
```aidl
    quarkus.hibernate-orm.database.generation=none
```

### Quarkus and NoSQL

# Rest with Quarkus

### REST Communication with Quarkus
JAX-RS
- Classes are annotated with @Path
- Methods are annotated with HTTP verb annotations (@GET).
Note: you can annotate the method with @Path
-   Media type controller
  @Produces(MediaType.APPLICATION_JSON)
  
- @QueryParam("varName")
- @PathParam("varName")

### REST Client with Quarkus

### OpenAPI with Quarkus
note: you can add dependency using another way:
mvn quarkus:add-extension -Dextensions="dependency-name"
- enable swagger in quarkus
    - add dependency "quarkus-smallrye-openapi"
      ```
        <dependency>
            <groupId>io.quarkus</groupId>
            <artifactId>quarkus-smallrye-openapi</artifactId>
        </dependency>
      ```
	Gradle:
implementation group: 'io.quarkus', name: 'quarkus-smallrye-openapi'	
    - add properties quarkus.swagger-ui.enable=true
    - check it on url/swagger-ui
    
    
addiotions for more fancy:
    - mp.openapi.extensions.smallrye.info.title=Ur Title API
    - mp.openapi.extensions.smallrye.info.version=1.0.0
    - mp.openapi.extensions.smallrye.info.description= desc desc
### GraphQL with Quarkus
- annotate the class with @GraphQLAPI
- annotate the methods:
    @Query("allRooms")
    @Description("Gets all Rooms")
  

## Additional Topics with Quarkus
### Health Checks

### Tracing
- jaegar


#### Testing 
- Add dependency 
```aidl
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-junit5</artifactId>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>io.rest-assured</groupId>
    <artifactId>rest-assured</artifactId>
    <scope>test</scope>
</dependency>
```

Add directory under src => test
https://quarkus.io/guides/getting-started-testing
