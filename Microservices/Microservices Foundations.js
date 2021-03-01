Quick_Tutorial:
===============
https://medium.com/omarelgabrys-blog/microservices-with-spring-boot-intro-to-microservices-part-1-c0d24cd422c3

“Microservices, in a nutshell, allows us to break our large system into a number of independent collaborating components.”

Spring Cloud: which builds on top of Spring Boot, provides a set of features to quickly build microservices.  

Decomposing
------------
So, instead of having one large application, we decompose it into separate, different, mini-applications (services).

Each service handles a specific business domain (logging, auth, orders, customers)

Single-function
----------------
Each and every service has a specific function or responsibility. And yes, a service can do many tasks, but all of them are nevertheless relevant to this single function.

Independent
-----------
Independent means services don’t know about each other implementation.

Well-defined interfaces
-----------------------
Services must provide an interface that defines how can we communicate with it.

Small Teams
-----------
We split the work up and team across the services. Each team focuses on a specific service, they don’t need to know about the internal workings of other teams.

Entire Lifecycle
----------------
The team is responsible for the entire lifecycle of the service; from coding, testing, staging, deploying, debugging, maintaining.


Minimizing Communication
------------------------
Minimizing communication doesn’t mean that the team members should ignore each other. It means the only essential cross-team communication should be through the interface that each service provides.

The scope and risk of change
-----------------------------
Services should be changed without breaking other services. And so long as we don’t change the external interface there will be no problem for other services.

As a result of changes, the versions of services are updating individually, and there is no relationship between them.

Eureka Server:
---------------
Service Registry (naming server)
It’s duty to give names to each microservice, Why?
1. No need to hardcode the IP addresses of microservices.
2. What if services use dynamic IP addresses; when autoscaling.

- every service registers itself with Eureka, and pings Eureka server to notify that it’s alive.
- If Eureka server didn’t receive any notification from a service, This service is unregistered from the Eureka server automatically.

 in your spring boot main application class, enable Eureka server using @EnableEurekaServer annotation.
 @SpringBootApplication
@EnableEurekaServer	// Enable eureka server

public class SpringEurekaServerApplication {
 
 
enable eureka client using @EnableEurekaClient annotation.

@SpringBootApplication
@EnableEurekaClient 	// Enable eureka client. It inherits from @EnableDiscoveryClient.
public class SpringEurekaImageApp {

What’s load balancing?
What if more than one instance of a service running on different ports. So, we need to balance the requests among all the instances of a service.
When using ‘Ribbon’ approach (default), requests will be distributed equally among them.

Gateway — Zuul
---------------
When calling any service from the browser, we can’t call it by it’s name as we did from Gallery service — This is used internally between services.

It’s a proxy, gateway, an intermediate layer between the users and your services.
Eureka server solved the problem of giving names to services instead of hardcoding their IP addresses.
But, still, we may have more than one service (instances) running on different ports. So, Zuul …

It’s worth mentioning that Zuul acts as a Eureka client. So, we give it a name, port, and link to Eureka server (same as we did with image service).

@SpringBootApplication
@EnableEurekaClient 		// It acts as a eureka client
@EnableZuulProxy		// Enable Zuul

public class SpringZuulApplication {

















