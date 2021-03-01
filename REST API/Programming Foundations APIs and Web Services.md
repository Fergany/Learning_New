# Programming Foundations: APIs and Web Services
Do you have data in your systems that you want to quickly and easily share with others? 
Maybe there's information which exists in another system and you need to use it in yours. 
If so, then web services will allow your applications to talk to one another and share data over the internet

# 1. Understanding Web Service
## Web Service Types
- SOAP
 ```
Simple Object Access Protocol sends a message using XML (both client and server speak the same language either XML or JSON).
 ```
- RESTFull
```
Use HTTP to access resources.
```
### Advanced of Web Service
1. Reusability
2. "Language Transperancy"."means that the Service Provider and Client may be written in different language.

3. "Usability" It's an easy way to make the data more accessible to other systems in a secure fashion.

### Consideration of the web service.
While a Web services make sense in a lot of cases, 
there are some cases when a web service isn't the best choice. 
Two common concerns that should be considered are latency and partial failures. 

#### Latency
The time it takes a request to return a reposnse.

#### Partial Failures
When a server or network fails to respond.

### Secure Web Service
1. Authentication

2. Authorization
Determine access of client's level.

Basic Authentication (Basic Auth)
```
The simplest protocol available for performing web service authentication over the HTTP protocol.
```
API Key Authentication
```
Requires the API to be accessed with a unique key.
```
### Web services, APIs, and microservices
RESTful APIs and web services are often confused with each other. 
APIs are the communication and data sharing mechanism between two different applications or systems. 
This sounds just like a web service, doesn't it? 
APIs are a natural evolution of web services. 
Both facilitate information sharing but APIs are more dynamic. 
Web services evolved in the early 90s, but the complexities with SOAP-based web services led to REST-based APIs.

Web services depend on SOAP protocol.
Requires more work to pack and unpack data.

. When making a decision to use an API, a web service, or a microservice, 
take a look at:
- the business problem you're trying to solve,
- the type of application you're trying to build, 
- and the capabilities of your calling clients. 

# 2. Using RESTfull APIs and HATEOAS
## REST overview
Representaional State Transfer
```
A set of guidelines to design an APIS.
```
RESTFul APIs promote loose-coupling. This simply means that the system should be designed so that changes and enhancements to web services don’t break clients that are already using them. 
#### API Principles.
1. URI (Uniform Resource Identifier).
and the URI points to the resource we want it to interact it.
2. Operations
    - GET ==> Retrieves a resource.
    - POST ==> Creates a resource.
    - PUT ==> Updates a resource.
    - DELETE ==> Deletes a resource.
3. Format: Resources can be represented in mulitple format:
    - HTML.
    - XML.
    - PLain text.
4. Stateless (Communication between the Client and Server is Stateless).
    - Server will not remember or store any state the client made.        
    
Payload
```
Data send between client and server.
```    
RESTfull starts small and evolve over the time.
RESTful APIs allow for a greater variety of data formats, You can use XML or JSON or something else entirely. 
On the other hand, SOAP based web services only allow for XML. 



Also, when using JSON with RESTful APIs, data is typically easier to work with. 
JSON is lightweight and parsing the data is much faster. 
That means clients will have faster response times when requesting data.

#### HATEOAS
Hypermedia As The Engine Of Application State
Client interact with the REST API entirely through the response of the server.
The primary advantage of HATEOAS is to avoid sending boolean fields or state-related fields that require the client to interpret them and decide what action(s) can be taken next.
The core principle of HATEOAS achieved: publication of links

#### API
Swagger is a tool to Document an API

# 3. Using SOAP web service

### SOAP Usage
SOAP is used for enterprise level web services that require high security and/or complex transactions.

Used for enterprise-level web service
 - Financial Service.
 - Payment gateway.
 - CRM SW.
 - Identify mng.
 - Telecommunication Service.

For that reason, SOAP is still in use and still proves to be well suited for applications 
where a higher level of security is needed as security, authorization,
and error handling are built into the protocol.

### Create a Web Service
Let's say you have information, or data, that you would like to share with others. 
The easiest way to give them access is to put a SOAP based web service on top of your data. 

from Java EE, we will use JAX-WS and that's the "Java API for XML based web services". 
And there are annotations included that make it very easy, like web service and web method.

# 4. Developing APIs using GraphQL
### GraphQL Overview
A syntax describing ho to ask for data, 
which is usually used to load data.

The way you consume data matching exactly what you need.

#### Query Document
    - A string send to server to process and request data.
    - Are a read-only operation, and cannot be manipulated.
    - 
 