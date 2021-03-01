DBMS is the software, like SQL Server, MySQL or Access, we use to interact with the database.

Understanding databases: Benefits of spreadsheets
-------------------------------------------------
Col --> Field
Row --> Record


Benefits of structured data
---------------------------
DATABASE
--------
- Provide structure for data.
- Allow enforement of rules for data.
- Protect data from unauthorized access or changes.


Relational DB
==============


Composite KEY
-------------
Two or more fields taken together to act as a unique identifier.
Combination of fields that uniquely identify a record.


Relationships
-------------
One to One
One to Many
Many to Many (create a new table called an associative or linking table. Table1sTable2s)

ACID and TRANSACTIONs
---------------------
ACID requirements handeled by DBMS
Atomic
	"means that the transaction is indivisible, that pieces of it can't be separated out."
Consistent
	"means that whatever the transaction does, it needs to leave the database in a valid or consistent state."
Isolated

Durable


Atomic here means that the transaction is indivisible, that pieces of it can't be separated out. Consistency means that whatever the transaction does, it needs to leave the database in a valid or consistent state. The actions in a transaction can't violate integrity rules that are defined for the database. Isolation means that while the activities in the transaction are being completed, nothing else can make changes to the data involved. If we were in the middle of moving money from one account to another, and the user submitted another transfer request, that request would have to wait until the first one finishes completely. Durability means that the information we change in the transaction actually gets written to the database. When the transaction is reported as complete, the data is there. The change has been made.

RDBMS Tools
-----------
- Support American National Standard Institude (ANSI) SQL.
- Many offer versions of the language that extends ANSI SQL to include features specific to that DBMS (TSQL, MySQL)..

SQL
---
- Allows statements to be written for DBMS to interpret how to interact wz data.
(in this role, SQL is called a DML)
- Offers features to manage the database itself, such as creating or modifying tables and controlling access to tables.
(in this role, SQL is called a DDL and DCL)

TABLES
=======

Naming:
plural version, first letter is capital.
Fields: (UpperCamelCase) or CamelCase, singularly, because for each record, there''s only one piece of data in the field.

- avoid using special characters or spaces in the field names. Most DBMS tools will let you use spaces but it makes things a little harder to deal with later on.

Columns and data types

Primary Key:

Tablename ID
Singular   

Normalization
=============

Normalization Rules
-------------------
three rules for organizing data in a database. These are called normalization rules, and they help us to reduce redundancy and improve the integrity of our data.

1NF
	Values in each cell should be atomic and tables should have no repeating groups.
	
2NF
	No value in a table should depend on only part of a key that can be used to uniquely identify a row.

3NF
	Values should not be stored if they can be calculated from another non-key field.

are considered to be the standard level of optimization for a business database.

Denormalization
===============


Denormalization is a trade-off, Gaining speed may reduce consistency.


Querying a DATABASE
===================

Stored Procedure:
-----------------
- Are a series of commands stored on the database.
- Allow reuse of long ore detailed queries instead of writing each time.
- Provide a safe way to deal with sensitive data.


Access CONTROL
==============
User 1 ==> CRUD
User 2 ==> Read Only

SQL Injection
-------------
Type of attack that includes part of SQL command entered as a value to hijack a query and change how it works.

Solutions for different DB Sizes
--------------------------------
- SQLite is great for mobile applications.
- 























