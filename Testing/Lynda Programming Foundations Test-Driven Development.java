Small-Step ?(incremental) approach
Botton-up approach
Top-down approach


Note that the testing in TDD is only unit testing. That is, testing your code at the smallest unit level. Other types of testing, such as system testing, integration testing, or functional testing, test your application at a higher level and therefore not part of TDD's scope. 

The key idea is that you first write your test case, and then write the code to pass that test case. 

before you write a single line of code, you first write a test case for it.
		And that is the golden rule of test-driven development.



Refactoring:
------------
Improving the internal structure of ur code wzout changing its external behavior.

" The team briefly talked about a high-level design decision"

The xUnit Framework
===================

JUnit 5 Modules:

Vintage: backward compatability for JUnit 3 and 4.
Jupiter: programming and extension models for writing tests.
JUnit Platform: foundation for launching testing frameworks.


Writing Test Cases
==================
testXXXX
 Name your methods meaningfully to indicate what they are testing. Even if the name sounds a little too long. 
 
import org.junit.jupitier.api.Assertions;


TDD Methodology
===============
TDD and Agile
=============
1. Write a failing test case.
2. Code to pass the test.
3. Refactor.


The iterative red-green-refactor cycle
======================================
Refactoring
-----------
Changing internal structure of software to make it easier to understand and cheaper to modify wihtout changing its external behavior.

Refactor to improve the design
=============================
"However, you do not refactor every time you write new test case or new code. It is an optional step whenever you notice that you are duplicating your code or your code is becoming redundant, hard to read or your code just doesn't feel right."

TDD Structure and Syntax
========================
Test structure
==============
start with one test class per code class,

At some point, you will see that your code class is becoming bloated. In such a scenario, you will refactor and split your code class. For example, the team may decide to split the Hangman class into two, keeping the scoring logic into a class called as HangmanScores. Should you then create a new test class? You may, if it helps keep your test cases more manageable, or, you may split the code class into two, but continue to use the same test class. 

Typically, one test class per code class, however:
- One test class may test more than one code class.
- One code class may be tested by more than one test class.

Design test cases to test requirements, not to test methods.

Test Case Pattern
-----------------
- Arrange
- Action
- Assert

@BeforeEach
@AfterEach
// those methods repeated for each test case.

@BeforeAll
@AfterAll
// those methods working before/after all test cases.

Assertions
==========
Assert in Programming Language
------------------------------
- An idiom for defensive programming.
- Supported in many Programming Languages.
- Has a condition that is expected to be true when executed, else it throw an assertion error.
- are disabled by default.

the xUnit framework use the similar idea but they have their own assertion API.


assertSame() // uses '==' operator to compare.
assertEquals() // uses .equals method to compare.


Testing Exceptions
==================
- JUint 4 is differ from JUnit 5 for exceptions.

JUnit 4
-------
@Test (expected = SomeException.class)
public vois testMyMethod(){
	
JUnit 5
-------
@Test
public void testMyMethod(){
	assertThrows(SomeException.class, Executable executableCode);


Scalling TDD
============
TDD tools and frameworks
========================
- TDD focus on unit test cases.
- 

Assertion Framework
===================
- JUnit test cases may get hard to read and write.
- Third-party assertion libraries offer better readability, power, and functionality ex(AssertJ, Hamcrest, Truth).

AssertJ
-------
- Use static methods of Assertions class,
  import static org.assertj.core.api.Assertions.*;	
  assertThat(objectUnderTest).isEqualTo(expectedValue); // isNotNull();
- Strongly typed assertions specific to type of the object under test:
   assertThat(stringUnderTest).endsWith(val); // .contains(val);   


Hamcrest
---------
- Available in Maven central repository
- Implemented for many language such as Java, Python, Ruby, ObjectiveC
- Intergrates with other testing frameworks, such as TestNG,
		and mocking frameworks such as JMock and EasyMock
- A framework for writing matchers allowing match rules to be defined.
	assertThat(str, allOf(containsString(...), StartsWith(...)));
	
	assertThat(str, anyOf(containsString(...), StartsWith(...)));

	assertThat(doubleVar, greaterThan(0.3)); // or closeTo(0.3, 0.1)
	
Test doubles
============
The system or the object on the test may have external dependencies such as databases, web services or other systems but you may not have access to these external dependencies all the time or they may not even be ready at the time of testing. 
So the option is to create proxies for these external dependencies or what are formally called as Test Doubles. Test Doubles simulate the behavior of the objects.
		They are of five different types. A Test Double can be a dummy object, a stub, a fake object, a spy or a mock.


Mocking
=======
Mock Object
-----------
- Special kind of test double.
- Mock the expected behavior of an external dependency.
















