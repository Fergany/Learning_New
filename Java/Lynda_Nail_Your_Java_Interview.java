 Java language
 OOP
 Algorithms
 Data Structure.
 
 The interview will be conversational and writing some code in a white board.
 
 Speak to ur technical ability and what have done in ur career.

JVM
===
- Java was designed so applications can be executed on any platform that supports Java wzout having to be recompiled. 
- is what allows Java to run on platforms wzout being recompiled or rewritten.
- Provides a platform-independent way of executing code.
- JVM run this byte code.
- No JVM implementation is the same.
- No major effects on ur programs

JRE
===
JVM, browser plug-ins for executing Java applets.
What u need to run Java program.

JDK
===
JRE, compiler, debuggers, and tools to create programs.
What u need to develop java program.

Static method
-------------
Cls method.
belong to cls itself.
when you want to use a method without creating an instance of the class.

Non-Static method
-----------------
instance mehtods.
belong to each object generated from the class.
if method related to an instance''s attibutes.

Modifiers
=========
- determine how certain vars and methods can be accessed.

Leveraging new Java features:
=============================

Jigsaw
------
- Project Jigsaw introduce a module system to Java.
Modularizing the JDK
- with modules u can scale up/down the functionality needed for ur platform or applications.
- Use only the required components of the JDK for ur application.
- Scale up/down the JDK based on ur use case.
- Customized JDK per platform enables improved performance.

Use Optional to avoid NullPointerException
-------------------------------------------
- Container obj which may or may not have a given value.
- To see if value exist use isPresent()
- Use get() to retrieve the value.

Lambda
------
- Allow you to pass function as data.
- What if we need to create a function on the fly?

Streams
-------
- Stream is a sequence of elements.
- Traverse data from
- Arrays.stream(arr);
- list.stream();

local variable type reference
-----------------------------
- helps collapse long class names and make ur java code more concise.
- can't be used everywhere in ur code.
- can reduce the amount of code u read /write in some cases.
-

new swich expression
-------------------
String result = switch (number) {
					case 3 -> "3";
					default -> "-1";
					// or enahce the default as
					default -> {
						sout("the input is invalid");
						yield "invalid inputs";
						}
				};
Note: in this new form the default case is required, if not you will get a compile error.

String
======
- Comprised of a set of characters, including letters, number, and spaces.
- immutable
- use concat() with string the same thing with '+', more readable but the same happens.
- StringBuilder, StringBuffer allow you to make string-like objects that are mutable.
- StringBuffer is thread-safe beacuse it has synchronised methods.
- in Java 9, String are stored as byte arrays instead of char arrays, called 'compact strings' because they now take up half the space.

Normalize string input
----------------------
-

Two ways to create a string:

String Literals:
----------------
String A = "Hi, Zoomy";
String B = "Hi, Zoomy";
- Live in 'String Constant Pool'.
- String A, B reference the same object and value.

String Objects:
---------------
- Live in the heap.
- reference two separate objects.

Note: if String A, B have the same value, then it's nice to just have on place where it's stored (string literals) rather than multiple (String Objects).

Concat String
=============
- + ==> called concatenation operator.
- .concat
- StringBuilder append, insert, delete

Basic String Functions
======================
- boolean s.isEmpty()
- s.length()
- .trim()
- delete()
- s.toLowerCase()
- s.toUpperCase()
- .charAt(i)
- .indexOf()// have a lot of overwrited methods, please check at the API documentations
- boolean .contains("")
- no reverse() in String, but in StringBuilder, StringBuffer.

Note: none of these methods are modifying the string. They're creating a new string and they're using the input string as data to then decide what that final string,


Advanced String functions
=========================
- split(""); // for dot use "\\.", space: " ", split either break string based on single char or sequence of chars
- replace()

String equality
===============
==
.equals()

Arrays
======
- Collection of objects at the same datatype.
- Size cannot be changed after allocation since items are stored contiguously.
- Access items by index, starting @ 0.
- Ability to add and remove objects from an array.

Adv:
----
- Used to implement other data structures.
- Act as a container obj for multiple items.
- Less memory overhead.

DisAvd:
-------
- Take longer to search for an item in an array.
- Must copy all items to a new array if the current array is full.

LinkedList
==========
- A linear datastructure where elements containing data of the same types are linked using pointers.
- Each element is called a node.
- A node contains data as well as a pointer pointing to the next element in the linked list.
- If the pointer is null, then this is the last element in the list.
- Since elements are connected by pointers, they don''t need to be stored next to each other (unlike the array, stored contiguously in memory).
- Singly linked lists: contain a pointer pointing to next node.
- Doubly linked list: contain a pointer pointing to the next node, and a pointer pointing to the previous node.
- addFirst(e), addLast(e), add(index, e), add(e)
- getFirst(), getLast(), get(index)
- removeFirst(), removeLast(), remove(obj), remove(index)
- .clear()
- int indexOf(e)
- boolean .contains(obj)
- size()
- to print the LinkedList, just print(linkedListObj);

Java abstracts many of things needed to maintain the data structure''s form.

Adv:
----
- Quicker at inserting and deleting dynamically sized data.
- Used to implement stacks and queues.

DisAdv:
-------
- More memory is required for storing elements in a linked list.
- Search or node traversal is still time consuming.

Queue:
======
- Ordered list of objects, where elements are inserted(enqueued) at the end of the queue, and removed(dequeued) from the begining of the queue.
- FIFO
- interface in java.util.Queue
- you musts instantiate a concrete implementation of the interface in order to use it.
- Queue<String> q = new LinkedList();
- add(e), peek(), remove()
- peek() => see the first item in the queue without removing it.
- Good for "storing" order of processes.
- Enqueue/Dequeue takes a very little time.

Stack
=======
- Ordered List of objects, inserted and removed following LIFO policy.
- push(), peek(), pop()
- .empty()
- Stack<String> q = new Stack();
- can be implemented as Array or LinkedList.

- Why use stack?
	Keep track of state.
	Great for "reversing" things.
		
HashMap
=======
- Use key-value pairs and a hashing function to store and organize their data.
- A hashing function maps a key or object to a specific hash.
- This hash has determines where the object is stored.
- As long as you have the key, retrieving the object is fast.
- Hash Collition
- Sometimes two keys can hash to the same value and this is called a hash collisions,
The way we solve this is for each key, we would have a list data structure that hold all of the values associated with that key.
- put(k, v), .get(k), remove(k), .keySet(), .values()


- Searching is faster with a hash map, but a hash map takes up more spaces.
-  searching for values is much faster than many other data structures. Insertion and deletion is also quick but hash structures do take up more space in memory.

OO Concepts:
============
Abstraction:
============
- Hides implementation complexity so we can achieve generalization.
- All the user needs to know is an example, input, output and a broad descritopn of what the functions can does,
this allows the function to be used for multiple purpose.
- ex: pressing the gas pedal on a car.
- allows only essential details to be displayed to the user so that the feature can be used in more ways rather that in one super specific way.
- let you focus on the required characteristics and ignore implementation details, providing generalization to the program.

Abstraction in Java:
--------------------
- An abstract class is template for a class where some of the functionality is not implemented yet.
- Abstract class can't be instantiated directly.
- conccrete class can extends from abstract class and implement the appropriate functions.

Encapsulation
==============
- Binding an object's state and behaviors together.

- hide class's data from other classes.
- Keeps classes separated and prevents coupling.
- we achieve encapsulation in java by declaring all fileds in the class as private and writing a public methods to set/get their values.

why?
- We use encapsulation so the user has no idea of inner implementation of a givven class and the data it contains.
- It allows you to hide how values are stored and maintained within a given class.

Abstraction provides generalization.
Encapsulation hides unwanted implementation details from the users of the objects.

Inheritance:
============
- the process where one class acquires the fields and methods of another.
- write common properties and functionality in one class and have other classes with unique features

- The main adv of inheritance is to minimize the amount of duplicate code.
- To change behavior, you can overide and modify the appropriate methods while keeping all the other behvior.

- Iheritane is different from pure abstraction because both classes are concreate class.

Disadv:

- class and subcalss can becomes tight coupling.
- More level of implementation to jump through in order to find appropriate functionality.

Ploymerphinsm()
==============
- is the ability for an object or function to take many forms.
- Runtime polymerphism is achieved through method overriding.
- Complile time polymerphism is achieved through method overloading.








