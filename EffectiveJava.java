Effective Java
==============

Creating and Destroying Objects
===============================

A class can provide a public static factory method, which is
simply a static method that returns an instance of the class.
ex: Boolean.valueOf(boolean)

Providing a static factory method instead of a public constructor has both advantages and disadvantages:

1. Unlike constructors, they have a names.
	may have multi constructors, with different implementation,  		
2. unlike constructors, they are not required to create a new object each time they’re invoked.
3. unlike constructors, they can return an object of any subtype of their return type, this gives you
great flexibility in choosing the class of the returned object.
4. the class of the returned
object can vary from call to call as a function of the input parameters.
5. the class of the returned object
need not exist when the class containing the method is written. ???

Page#9 for examples.

In summary, static factory methods and public constructors both have their
uses, and it pays to understand their relative merits. Often static factories are
preferable, so avoid the reflex to provide public constructors without first considering
static factories.



Item 2: Consider a builder when faced with many constructor parameters
======================================================================
// Builder Pattern
public class NutritionFacts {
private final int servingSize;
private final int servings;
private final int calories;
private final int fat;
private final int sodium;
private final int carbohydrate;
public static class Builder {
// Required parameters
private final int servingSize;
private final int servings;
// Optional parameters - initialized to default values
private int calories = 0;
private int fat = 0;
private int sodium = 0;
private int carbohydrate = 0;
public Builder(int servingSize, int servings) {
this.servingSize = servingSize;
this.servings = servings;
}
public Builder calories(int val)
{ calories = val; return this; }
public Builder fat(int val)
{ fat = val; return this; }
public Builder sodium(int val)
{ sodium = val; return this; }
public Builder carbohydrate(int val)
{ carbohydrate = val; return this; }
public NutritionFacts build() {
return new NutritionFacts(this);
}
}
	private NutritionFacts(Builder builder) {
	servingSize = builder.servingSize;
	servings = builder.servings;
	calories = builder.calories;
	fat = builder.fat;
	sodium = builder.sodium;
	carbohydrate = builder.carbohydrate;
}
}

NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
.calories(100).sodium(35).carbohydrate(27).build();

In summary, the Builder pattern is a good choice when designing classes
whose constructors or static factories would have more than a handful of
parameters, especially if many of the parameters are optional or of identical type.
Client code is much easier to read and write with builders than with telescoping
constructors, and builders are much safer than JavaBeans.

Item 3: Enforce the singleton property with a privateconstructor or an enum type
================================================================================
- A singleton is a class that instantiated exactly once.
two ways to implement singletons, both are based on making constructor private:

1. The member is a final field
// Singleton with public final field
public class Elvis {
	public static final Elvis INSTANCE = new Elvis();
	private Elvis() { ... }
	public void leaveTheBuilding() { ... }
}
adv:
the API makes it clear that the class is a singleton: the public static field is final, so it will always contain
the same object reference. 
The second advantage is that it’s simpler.

2. The public member is a static factory method
// Singleton with static factory
public class Elvis {
	private static final Elvis INSTANCE = new Elvis();
	private Elvis() { ... }
	public static Elvis getInstance() { return INSTANCE; }
	public void leaveTheBuilding() { ... }
}
One advantage of the static factory approach is that it gives you the flexibility
to change your mind about whether the class is a singleton without changing its
API, or to modify mehtod 


A third way to implement a singleton is to declare a single-element enum:
// Enum singleton - the preferred approach
public enum Elvis {
	INSTANCE;
	public void leaveTheBuilding() { ... }
}

Note that you can’tuse this approach if your singleton must extend a superclass other than Enum
(though you can declare an enum to implement interfaces).

Item 4: Enforce noninstantiability with a private constructor
=============================================================

// Noninstantiable utility class
public class UtilityClass {
// Suppress default constructor for noninstantiability
private UtilityClass() {
	throw new AssertionError();
	}
	... // Remainder omitted
}
Because the explicit constructor is private, it is inaccessible outside the class.
The AssertionError isn’t strictly required, but it provides insurance in case the
constructor is accidentally invoked from within the class.

Item 5: Prefer dependency injection to hardwiring resources
===========================================================

Item 6: Avoid creating unnecessary objects
==========================================
String s = new String("bikini"); // DON'T DO THIS!
// You can often avoid creating unnecessary objects by using static factory methods
“Don’t create a new object when you should reuse an existing one,”

Item 7: Eliminate obsolete object references
============================================
//obsolete reference

"Nulling out object references should be the exception rather than the norm."

"The best way to eliminate an obsolete reference is to let the variable that contained
the reference fall out of scope. This occurs naturally if you define each variable in
the narrowest possible scope"

Item 8: Avoid finalizers and cleaners
======================================




