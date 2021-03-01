
final modifier:
===============
variable ==> const variable
methods ==> prevent method override
class ==> prevent inheritance

Enhanced For-Loop (for-each loop)
=================================
- referred as for-each loop, because the loop iterates through each element of array/collection.
- to work with array and collections.
- to iterate through items of arrays/collections.

Enum
====
- Special class, that represent a group of constants (unchangeable variable, like final variables).
- separated by comma, should (not must) be in uppercase letters.
- enum keyword (instead of class or interface).
- Level myVar = Level.MEDIUM; 
  System.out.println(myVar); // MEDIUM
  
- Enum in a Switch Statement:
  switch(myVar) {
      case LOW:	
	  
- Loop Through an Enum:
	for (Level myVar : Level.values()) {
		System.out.println(myVar);
	}	
  	  
Difference between Enums and Classes
------------------------------------

- An enum can, just like a class, have attributes and methods. The only difference is that enum constants are public, static and final (unchangeable - cannot be overridden).

- An enum cannot be used to create objects, and it cannot extend other classes (but it can implement interfaces).

- Why And When To Use Enums?
Use enums when you have values that you know aren't going to change, like month days, days, colors, deck of cards, etc.

Packaging Programs in JAR Files
===============================
- The Java™ Archive (JAR) file format enables you to bundle multiple files into a single archive file.
- 


Java 8 - Interface
==================
Default Method
==============
- prior to Java 8, interface could contain abstract mehods and constant declarations, but you couldn't provide a fully implemented methods that would be inherited.
- By using a default method, can sometimes eliminate a whole layer of inheritance.
- Some developers before this, might have created an interface, then a base class that implemented the interface, and then a subclass that they would actually use in their code.
- with using this capability, you might not need the base class, go to subclass, inherit the default method directly from the interface.
- default type identifier(args ...){
	implementation;
	}
	
- Can be overriden.
 

Static Method
==============
- Like default methods, no need to implement them in the implementation classes.
- Just like the default method, the goal is to let you to eliminate whole layer of inheritance and simplify your code.
- "make your apop easier to code and maintain".
- Since these methods are static, we cannot override them in the implementation classes.
- static void anotherNewMethod(){
    	System.out.println("Newly added static method");
    }


Functional Interfaces
=====================
- interface that only has one anstract method.
- Prior to Java 8, known as SAM, called now functional interface.
- Can have any number of default methods.
- From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface.
- can implemented by lambda expression.
- If you are using an interface for one-time, it doean't make sense to create yet another code file or another class name.
- ex: Runnable, ActionListener, Comparable

@FunctionalInterface Annotation
-------------------------------
@FunctionalInterface annotation is used to ensure that the functional interface can’t have more than one abstract method. In case more than one abstract methods are present, the compiler flags an ‘Unexpected @FunctionalInterface annotation’ message. 
However, it is not mandatory to use this annotation.

Lambda Experssion
==================
- (Project Lambda) -> an effort to bring java to the world of functional interface.
- in CS terminology, a lambda is an anonymous function.

- Basically express instances of functional interface.
- instantiate interface with a single method.
- let's you define a class and a single method with a very concise syntax implementing.
- Can only appear in places where they will be assigned to a variable whose type is functional interface.

Method References
==================
- It is compact and easy form of lambda expression.
- you can replace your lambda expression with method reference.
- Can use method referenceon four kinds of methods:

Types of Method References: 
---------------------------
	- Reference to a static method.
		ClassName:: methodName
	- Reference to an instance method.
		containingObject::instanceMethodName 
	- Reference to a constructor.
		ClassName:: new

Streams
=======
Pipelines

Intermediate / Terminal operations

.flatMap()

Optional Class
==============
- Container obj used to contain not-null objects.
- Optional object is used to represent null with absent value.
- .orElse()
- . 



Date/Time API (in Java 8)
=============
LocalDate
LocalTime
LocalDateTime
Zoneddate
ZonedTime
ZonedDatetime
Period
Duration




























