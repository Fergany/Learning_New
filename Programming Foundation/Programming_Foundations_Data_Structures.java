Data and Datatypes:
===================
In CS, data is info that is stored or processed by a computer.

Data Type:
----------
An attribute of data that descibes the values it can have and how the data can be used.

Numerical Data Type:
--------------------
Whole Numbers (short 2, int 4, long 8)
Decimal Numbers (float 4, double 8) 
*depend on language

Signed (positive and negative values)and unsigned (positive values only)

JS only has numbers

Booleans:
---------
two possible values (true or false).

Characters:
-----------

Primitive types in memeory:
---------------------------
Boolean = one bit


Data Structure
==============
- is A way of collecting and organizing data.
- A collection with a defined way of accessing and storing items.
- is a container, that allow you to combine 
- Data structures give us organization, storage, and access.

Strings
=======

Primitive vs. reference types in memory
=======================================
Reference Types:
var -> memory address -> value

Primitive Types:
var -> data

in Java & Python, memory mng is done for you.


Arrays
======
- Collection of elements, where each item is identified by an index or key.

Multidimensional Arrays
=======================

Jagged Array:
=============
- Can have elements of different dimensions and sizes.
- Like multidimensional array, but the number of columns is not fixed.
- Access the length of each individual array.

Jagged array in the C#.

Resizable arrays and language support
=====================================
- in Java and C++, basic arrays cannot be resized.
- in Ruby and JavaScript basic arrays can be resized.

Java
----
- Immutable: basic array data.
- Mutable: Java classes give us resizable versions.
- ArrayList: comes with extra functionality.

ArrayList and Data
------------------
- An arrayList is an array under the surface.
- Focus less on maintaining data structures and more on creating.
arrList.add(2, 10);


Insert Functionality in Non-mutable Arrays:

Basic array is big enough:
- items are shuffled down and a new item is added.

Basic array is not big enough:
- All contents copied into a new, bigger basic array, and new items are also copied over with it.


Search arrays
=============
Linear Search (from begining to end) occurs behind the scenes.
Best case, first element.
indexOf has no information about your data.
Check every element.

Sort arrays
===========
Sorting wz Programming Language:
--------------------------------
- Call sorting function to your collection of objects.
- Pass your data structure as a parameter to a sorting function.

Big O notatoin
==============
Notation used to describe the performance or complexity of an algorithm.

Operations:

Insert
Access
Update
Delete
Search
Sort

O(1) Time
- Consistent duration of algorithm execution in same time (or space) regardless of the size of the input.
- also called: constant time

Linked List
===========
Building LinkedList in java:
----------------------------

class Node{
	int data;
	Node next;
	public Node(int data){
		this.data = data;
	}
}

Use LinkedList in java:
-----------------------
- java.util pkg.


Singly vs. doubly LinkedList
============================

ArrayList in Java 
-----------------
is it array? is it a list?
- Has behavior of a list in the surface.
- Sorted as an array under the hood.

Pros and Cons of lists:
=======================
Access
O(n)

Update
O(n)

Insert
if don't care about the place, O(1)

Search, Delete
O(n)

Sorting
(depending on the sorting algorithm you use)
Merge sort is typically preferred for linked lists.

Stacks and Queues
=================

Specialized queues:
--------------------
- Priority Queue -> Each element has a priority associated with it.
- DEQUEK (dek)-> Double-ended queue, 
			Items can be added or removed from either end.
			Java has interface for DEQUEK

Associative Array
=================
- Collection of key-value pairs.
- Key-value pairs are bound together.
- Each key must be unique (value not).
- Values are accessed with the key.


In normal array, the index doesn't have a meaning (0, 1, ...), no relationship between index and value, 
  			
			
Understanding hash funcitons
============================
Hashing => Data conversion process.
- one way.
- not like the encrypt, with encrypt you can decrypt, but you can unhash the hash value.

- java -> hashCode function

ASCII => Numerical representation of text characters.

Collision
---------
Anytime two inputs produce the same hash value (example, convert the test to number with ASCII).
Solution:
has a linkedlist to store both value, 'Separate Chaining'


HashTable
==========
- an implementation of the associative array abstract data structure.
- a key is hashing and converted to a number.

HashMapOperation
================
Search, Insertion, Deletion O(1)

Hashtable are excellent at managing many key-value pairs and volatile data.


Sets
====
- A coll of unique items.
- Order doesn't matter.

How set works?
- Take an obj, hash it, store it using the index,
Repeat and check if object is stored.

Tree Data Structures:
=====================
- Like LinkedList, Tree Data Structure contains nodes, 
the differnet, the node can be conected to one, two, or more other nodes.
Root Node.
Parent, child nodes.
(Child nodes with the same parent are siblings)
(Node with no childresn, leaf)

Binary Search Tree:
===================		
- max two child nodes from any given node (left and right node).		
- order.
- Left child node < Parent node.
- Right child node > Parent node.
- BST are used to implement other data structure.

Heaps:
====== 
- A data structure implemented as a binary tree.
Note: there is a heap, location in memory to store objects, but here is not the meaning.		
- Min and Max heap.
Priority Queue
--------------
- Order doesn't matter.
- Heaps are used to implement.

Pros and Cons of tree data structures
=====================================
Sets
			


















