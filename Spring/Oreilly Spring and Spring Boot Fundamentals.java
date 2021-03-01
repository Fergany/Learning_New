Maven, Gradle ==> Built Tool

executable jar file with embeded web server within it.

Spring Boot Actuator
====================
Supports built in (or custom) endpoints that let you monitor and manage your application - such as application health, metrics, sessions, etc.

@SpringBootApplication
@SpringBootTest

Controller
==========
@Controller

A controller in Spring MVC is a class whose job is to receive HTTP requests and then either return an HTTP response or redirect you to a view

@Controller
public class HelloController {

    @GetMapping("/hello")
    public static String sayHello(@RequestParam(defaultValue = "world", required = false) String name,
                                  Model model){
        model.addAttribute("user", name);
        return "hello";
    }
}

Spring is all about providing dependencies that you asked for. It's what we call dependency injection.

Spring Boot detects what capabilities you asked for and then auto-configures the application to accommodate them.

Spring Framework Documentation:
-------------------------------
https://docs.spring.io/spring/docs/current/spring-framework-reference/


Testing Controllers
===================
either hit the methods, and the result to be as 



Creating a REST Web Service
============================
@RestController
public class HelloRestController {
    @GetMapping("/rest")
    public Greeting greet(@RequestParam(required = false, defaultValue = "world") String message){
        return new Greeting(message);
    }
}

Testing Rest Component:
-----------------------
how did it know how to do that? Well, also inside of our class path, as part of the application itself, is a JSON parser known as Jackson. The Jackson JSON parser converts Java objects into JSON data and back.

testRestTemplate.getForEntity("/rest", Greeting.class);
testRestTemplate.getForObject("/rest", Greeting.class);

The Spring Application Context
===============================














































