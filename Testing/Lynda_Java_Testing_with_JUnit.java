What is JUnit?
==============
- Java library used for unit testing.
- Unit testing is examining a small piece of software
  (verify that it meets the business rules provided. 
- The goal is to assert the expected behavior or state.	
- JUnit is not a part of the standard Java cls libraries.
- It's included in several popular IDEs.

- Testing can be done with a debugging tool.
- It can also be done by adding print statements.
- These tools are good for finding logic error.

- JUnit provides automated testing and validation.
- JUnit provides tools to unit test all aspects of a program.

- After all unit testing is done, itegration tests are next.
- Integration testing is used to test the entire system.
- Another type of important testing is "Performance testing".

"Performance testing": used to benchmark the software by running repeatedly to simulate user traffic on your application,
The purpose is to ensure the code runs fast enough under a high traffic load. 

JUnit not set up to do integration or performance testing, but it will help you get your unit testing done completely and efficiently.

Using Assertions in JUnit
=========================
- JUnit provides overloaded assertion methods.
- Parameter order is (expected value, actual value).
  (for: Arrays, Single values, Objects, Null values).
- A String msg can also be added as first parameter.
ex: 

import static org.junit.Assert.*;

assertArrayEquals("failure - byte arrays not same", expected, actual);
assertEquals("failure - strings are not equal", "text", "text"); // assertNotEquals

assertFalse("failure - should be false", false); //assertTrue
assertNotNull("should not be null", new Object()); // assertNull

Aggregate tests into a suite
============================
- If you have several test classes you can combine them and run them all at once, by combining them into a test suite, 
Running a test suite execute all test classes in that suite in the specified order.
- A test suite can contains other test suites.

IntelliJ IDE
============
Alt - Enter

Test With Maven
===============

Run From The Command Line
=========================

Basic Unit Tests
================
- JUnit doesn't require human judgement to interpret.
- Easy to run many test cases at the same time.
- Namimg standard is to add a suffix "Test" to class name.
- A test name should explain the purpose of the test.
 
to create a unit test:
======================
1. Annotate a method with @Test.
2. Import org.junit.Assert.*;
3. Add assert statement to test program logic.

Exception handling tests
========================
Not only do we need to test a program for situations when things go right, we also need to make sure we handle things correctly when they go wrong. Specifically, we need to verify that the code throws the exceptions as we expect them to be thrown.
ex:
    @Test (expected = IndexOutOfBoundsException.class)
    public void testMain() {
     new ArrayList<Object>().get(0);
    }

    @Test (expected =  ArithmeticException.class)
    public void testDivideByZero()
    {
        int x = 10/0;
    }


Ignore Test
=============
import org.junit.Ignore;
import org.junit.Test;

	@Ignore
	// or wz explaination message
	@Ignore("This has been ignored for no reason ...")
    @Test
    public void testQuotient() 

Parameterized tests
===================
- Allow you to run test including multiple values at one time.
- Added with JUnit 4
 
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;















