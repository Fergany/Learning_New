In a nutshell, REST APIs allow us to fully separate the presentation of content from the content itself,

Representational State Transfer (REST):
---------------------------------------
Refers to a group of software architecture design constrains that bring about efficient, reliable, and scalable systems.


API 
===
A set of features and rules that exist inside a software program enabling interaction between the software and other items, such as other software or hardware. 

The Six Constraints of REST
============================
1. Client-server architecture.
	The client manages user interface concerns while the server manages data storage concerns.
2. Statelessness
No client context or information, aka "state", can be stored on the server between request

3. Cacheability
All REST responses must be clearly marked as cacheable or not cacheable.

4. Layered system.
The client cannot know, and shouldn't care, wheter it's connected directly to the server or to an intermediary like a CDN or mirrot.

5. Code on demand
Servers are allowed to transfer executable code like JS and compiled components to clients.

6. Uniform interface.
6.1 Resource identification in requests.
	The URI request must specify what resource it is looking for and what format the response should use.
	
6.2 Resource manipulation through representations.
	Once a client has a representation of a resource, it can modify or delete the resource.

6.3 Self-descriptive messages.

6.4 Hypermedia as the engine of application
Once a client has access to a REST service, it should be able to discover all available resources and methods through the hyperlinks provided.


3. Responses
=============
To get just the head section of a response, we can send a head request to any resource.

HTTP status messages
====================
1xx Information
something like I've received ur request, and I'm processing it, hold on.

2xx Success
		204 successfullt with no content.

3xx Redirection
4xx Client error
5xx Server error


restfulk oje tahn resful

AOuth 

4. Request/Response Pairs




















	
