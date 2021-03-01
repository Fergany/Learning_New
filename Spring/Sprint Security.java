Spring Security is a framework that focuses on providing both authentication and authorization to Java applications.

What is Spring Security and how does it work?
The short answer:

At its core, Spring Security is really just a bunch of servlet filters that help you add authentication and authorization to your web application.

It also integrates well with frameworks like Spring Web MVC (or Spring Boot), as well as with standards like OAuth2 or SAML. And it auto-generates login/logout pages and protects against common exploits like CSRF.

Optimally, the authentication and authorization should be done before a request hits your @Controllers.

For example, an incoming HTTP request would…​

First, go through a LoginMethodFilter…​

Then, go through an AuthenticationFilter…​

Then, go through an AuthorizationFilter…​

Finally, hit your servlet.

This concept is called FilterChain


So, when an HTTPRequest comes in, it will go through all these 15 filters, before your request finally hits your @RestControllers. The order is important, too, starting at the top of that list and going down to the bottom.


How to configure Spring Security:

1. Is annotated with @EnableWebSecurity.

2. Extends WebSecurityConfigurer, which basically offers you a configuration DSL/methods. With those methods, you can specify what URIs in your application to protect or what exploit protections to enable/disable.