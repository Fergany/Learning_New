# Spring Boot 2.0 Essential Training
- Spring Boot has become the almost default way to build Spring-based Java applications. 
- The rapid development and built-in operational onboarding allow you to focus on your business.

## 1. Spring Boot Basic
### Booting from web
- Using a plugin for an IDE.
- from web start.spring.io

### Auto-configuration
- The heart of spring boot.
- We got a web application in Tomcat up and running without doing any configuration, and that's because of auto-config.

**@EnableAutoConfiguration**
- Allows for configuration files to be scanned dynamically into the **Application Context**.
- 

### Configuration in Spring Boot
**Property-Based configuration**
- application.properties or application.yml
    - provide very basic configuration.
    - Development focus.
- Environment variable.
- Command-line parameter.
- Cloud configuration.

**Tip**
```
    server.port=8000
```
**Bean Configuration**
- Adding bean to default application class.
- Adding beans to separate configuration class.
- Importing XML-based configurations.
- Component Scanning.
    - And by default, any component or stereotype, of component, that is found in a sub package, of the package containing, the default application class, for a spring boot application, will be component scanned, unless you tell it not to
 
### Spring Profiles
**Why Profile?**

- Gives you flex config based on environment profile.
- Valuable in real-world, multi environment deployments.
  
**Engaging profile**

- **spring.profiles.active** environment variable
- Inject via command line or environment variable.
- using yaml file
```
spring:
    profiles: dev
server:
    port: 8000
---
spring:
    profiles: test
server:
    port:9000
```  
**Note**

The default port is 8080, when you didn't mention it.

### Building Spring Boot Application
- Maven, for build the application
```
mvn clean package
```
- Gradle.
- Build scripts.

**Running Jar File**
- Spring Boot applications are best suited as JAR files. 
- Josh Long "Make JAR not WAR," when Spring Boot first came out to help shift this mindset. 
- So JARs should be the packaging for Spring Boot, at least as the preferred method.
- Executable, you can run it using ```java -jar``` command to run the application without any other needs from the systems, other than having a JVM on your machine.
- Another cool aspect of a Spring Boot JAR file is that they have some prepended text that allows them to run on servers via init.d or systemd registrations. So you can set up a simple cloud server, say an EC2 instance, and install this into systemd and it will start up when the server itself starts up, 
again giving you more flexibility of how to run these executable JAR files.

### Containerizing Spring Boot application
- more control
    - You have control over how and what you put into your final image. 
    - You get control over the entire image life cycle, including building and testing, which sometimes you'll want to run in parallel, especially if you have to build many, many images as part of your CI/CD.
- Smaller image
    - By only including the output of the build in the final image, you have a chance to reduce the size of your total image. 
    - In addition, your final image only needs the JRE, not the full JDK, nor does it need Maven or Gradle. 
    - So obviously it's going to be a smaller image from that perspective.
- Approved base image
    - Now, one of the primary reasons that I choose to do this is for full control over the base images. Oftentimes, you build security approved images and use them across your entire suite of applications. By building your own Dockerfile, you get this level of control because you set the base image.
Dockerfile
```
FROM maven:3.6.3-openjdk-11-slim as BUILDER
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/

RUN mvn clean package
COPY target/booting-web-${VERSION}.jar target/application.jar

FROM openjdk:11.0.8-jre-slim
WORKDIR /app/

COPY --from=BUILDER /build/target/application.jar /app/
CMD java -jar /app/application.jar
```

then run the command line:
```
docker build -t applicaiton-name . 
```

to run the docker:
```
docker run -p 8080:8080 -d applicaiton-name
```
to check:
```
docker ps
```
to stop
```
docker stop imageID
```

## 2. Spring Boot Web
### Spring Boot Dependencies
**spring-boot-starter-web**
mixture of components needed to get an app up and running.
- default includes embedded Tomcat server.
    - can use another web servers if desired.
- JSON Marshaller

  