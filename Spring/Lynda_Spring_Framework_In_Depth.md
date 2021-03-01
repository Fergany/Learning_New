## What is Spring?

- Open source.
- Enterprise and internet support.
- Lightweight.
  Lightweight by nature, no littering of src code is required.
  Project are small and broken out.
- Unobtrusive.

## Spring in the Enterprise

- No need for heavy application servers.
- You focus on the business logic, not repetitive logic.

## Dependency Mng

- Spring manages runtime dependencies.
- No need to deal with them once they are configured.

## IoC

- Container maintains ur class dependencies.
- Objects injected at runtime or start up, not compile time.
- An object accepts the dependencies for construction instead of constructing them.

## Benefits of DI

- Reduces noise in your code.
- Reduce object coupling.
- Reduce defects that arise from incorrect construction.
- Focus on the API contract.

"the central IoC container is what actually does all of the construction, 
It builds a reference to each of the classes in our system and then passes those dependencies as needed to each of the classes."
 
 
### Applicaiton Context:
- Acts as a heart of SpringApplicaiton.
  (so the BeanFactory is the ventricles of that heart.)
- Encapsulate (Wrap) the BeanFactory.
- Provides metadata for bean creation.
- Provides mechanism for creation of beans in the correct order.
  
**IOC container**
- Provides all facilities for injection of beans at startup and runtime.
- Bean Factory handles all singleton beans.

**Note:**
- A Spring application can have one or more ApplicationContext objects in scope.
- Web containers always have multiple.
- Parent context can interact with children, not the other way around.
 
### Java-Based Configuration
- not only the way, XML is still valid, but has been removed from most of example on spring.io.

**Major benefits of Java config:**

    - Native Language syntax.
    - Compile time checking of configuration.
    - Easier IDE integration.
    
- Class annotated with @Configuration.
- Beans are created as methods annotated with @Bean.
- Constant beans can be defined with @Value.


Encapsulate Configuration
=========================

### Work with the environment

in resources/application.properties
      
      greeting.text=Lynda
	
in the class AppConfig: 

    @PropertySource("classpath:/application.properties")
    public class AppConfig {
	    @Value("${greeting.text}")
        private String greetingText;
	
### 
Profiles	
in the edit configuration, Environment Variables:
spring.profile.active : dev

@Bean
@Profile("dev")

Spring expression language (SpEL)
==========================
SpEL gives you the ability to use expressions in your configuration to configure your objects. Let's see a very simple case in action.
@PropertySource("classpath/applications-${spring.profiles.active}.properties")

Bean Scope
==========
before bean, declare it as @Scope("prototype")

Singleton
---------
- Default scope is 'Singleton'.
- One instance per Application Context
- BE careful with state data.

Prototype
---------
- New instance every time it is referenced.
- Definition are stored in factory, instances are not.
- Very useful for transient data or types that flex based on application state.
 
Session
-------
- Applies to web environment only.
- One intance of bean per user session.
- Definition stored in bean factory, instance are not.

Request
-------
- Applies to web environment only.
- One intance of bean per request.
- Definition stored in bean factory, instance are not.
- Goes to GC once it goes out of scope.

Proxies
=======
- Since Spring 4, everything is a proxy.
- Proxies add behavior.
- Spring uses JDK and CGLIB proxies.

- Behavior added to classes only impacted by calls through the proxy.
- Private methods.
- Interal call.


## Annotation-Based configuration
### The component scan
- in Spring Boot, the auto-configuration is partially achieved through component scanning mixed with conditional configurations.
     
**@Component**

- Indicates that a class should be loaded into the bean factory.
- @component and its stereotypes (@controller, @service, and @Repository).
- Component scanning scans the base package and that package's sub packages and loads configuration automatically for each bean it finds.

- DI is achienved through the @Autowired annotation.
- @Qualitfier is used when multiple implementation of an interface are needed.
- Properties injected wz @value.

**Start Component Scanning**

- Requires Java or XML Config.(in Spring boot done through @SpringBootApplication)
- Base pkg is defined in this config.
```
    @ComponentScan(basePackage = "com.pkg.basepkg")
    public class    
```
        
- Scanning occurs during start-up.

XML-Based Configuration
=======================
































 