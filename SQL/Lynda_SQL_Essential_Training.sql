
"this course aims to prepare you by providing a solid foundation in standard SQL".

Every database system is different.
- Most predate standard.
- Syntax may be different.
- Feature may be missing.
- Non-standard features.

SQL is designed for a specific task, To operate and manage a relational database.

- The purpose of a database is to organize your data and to make it available in convenient forms. 
- SQL is a language for managing a relational database.
- A relational database is organized in two-dimensional tables, comprised of rows and columns.
- Row like a record.
- Column like a field.

- it's optional to include include ';' however it's a good practice.
  
- SELECT col_name AS "Column Alias",
Note: you can remove AS, but in the result it will shown as "Column Alias" with quotes.
- LIMIT 5;
- LIMIT 5 OFFSET 10; ==> starts my limit after the first ten 
 
Counting rows
============= 
COUNT(*) ==> count all
COUNT(col_name) ==> this only counts the rows where the listed column has data. 

CREATING TABLE
==============
CREATE TABLE table_name(
	id INTEGER PRIMARY KEY, --Every time a new row or rows are inserted into the table, the system generates a new, unique value for each row in the table. 
	a INTEGER NOT NULL,
	b TEXT DEFAULT 'xx',
	b TEXT UNIQUE,
	foreign_key INT REFERENCES TableName(ColumnID)
);
ALTER TABLE table_name
ADD b TEXT;

DELETING TABLE
==============
DROP TABLE table_name;
DROP TABLE IF EXISTS table_name;


INSERT INTO table_name (c, b) VALUES ...;
INSERT INTO table_name DEFAULT VALUES;
INSERT INTO table_name (c, b) SELECT ...; 

NULL
====
Null is not a value. It is the absence of a value, 
so -- you cannot test for null with a normal condition because it's not a value. So to test for null, you need to use a special condition called IS NULL.


Filtering data
==============
WHERE col LIKE '_a%';
-- the first character can be anything, the second character must be an A, and then anything else after the string,

WHERE col in ('val1', 'val2');

REMOVE DUPLICATE
================
SELECT DISTINCT col;

Ordering output
================
ORDER BY col DESC, col2, col3; -- ASC by default

Conditional expressions
=======================
CREATE TABLE booltest (a INTEGER, b INTEGER);
INSERT INTO booltest VALUES (1, 0);
SELECT
    CASE WHEN a THEN 'true' ELSE 'false' END as boolA,
    CASE WHEN b THEN 'true' ELSE 'false' END as boolB
    FROM booltest
;

SELECT
  CASE a WHEN 1 THEN 'true' ELSE 'false' END AS boolA,
  CASE b WHEN 1 THEN 'true' ELSE 'false' END AS boolB 
  FROM booltest
;

JOIN
====
 JOIN keyword, to tell the database to use Customers and Dishes. This query by itself doesn't make a lot of sense. If we run it right now, we'll get back one row from our Customers table for every row in the Dishes table.

LEFT OUTER JOIN
RIGHT OUTER JOIN
FULL OUTER JOIN

STRING
======
'standard'
"notably older versions versions of MySQL, not standard"

'Standard ' || 'SQL ' || 'concatination'

SELECT LENGTH(col);
SELECT SUBSTR(col, 3); -- starting from 3rd letter.
SELECT SUBSTR(col, 3, 4); -- starting from 3rd letter, display 4 
SELECT TRIM(col), LTRIM(col), RTRIM(col)
OR SELECT LTRIM('....str...', '.'); -- as it is
SELECT LOWER(col), UPPER(col);

NUMBERS
=======
SELECT TYPEOF( 1 + 1 ); -- integer
SELECT TYPEOF( 1 + 1.0 ); -- real 
SELECT TYPEOF('panda'); -- text
SELECT TYPEOF('panda' + 'koala'); -- integer, as the result is 0, it's not string concatenation

Intger Division 
===============
SELECT 1/2; -- result is 0, as there are integers and the result will be integer.
SELECT 1.0 / 2; -- 0
SELECT CAST(1 as REAL) / 2; -- 0.5

SELECT ROUND(2.55555); -- 3
SELECT ROUND(2.55555, 3); -- 1.556, round to third deciaml place.

Dates and Times
===============
- SQL Satndard datetime Format => yyyy-MM-dd hh:mm:ss
- All dates and times in UTC (Coordinated Universal Time).
- SQL data and time types:
DATE, TIME, DATETIME, YEAR, INTERVAL

-- Every database system has it's own set of functions specifically tasked for handling dates and times. These functions are not standardized.

Ex: SQLLite:
SELECT DATETIME('now'); -- show datetime in UTC
SELECT DATE('now');
SELECT TIME('now');
SELECT DATETIME('now', '+1 day');
SELECT DATETIME('now', '+3 days');
SELECT DATETIME('now', '-1 month');
SELECT DATETIME('now', '+1 year');
SELECT DATETIME('now', '+3 hours', '+27 minutes', '-1 day', '+3 years');

Aggregates:
===========
- SQL offers aggregate functions which use more than one piece of data to generate a value.

SELECT COUNT(Id) as id
FROM t
WHERE condition -- before the group by clause, because the where clause operates on the data before the aggregation 
GROUP BY
HAVING -- after the group by clause because the having operation operates on the aggregated data after it's been aggregated.
ORDER BY ...;

COUNT(*); -- counts all
COUNT(col1); -- not null col1
COUNT(DISTINCT col1);
AVG(col1);
SUM(col1);
MIN(), MAX();

TRANSACTIONS
=============
 transaction is a group of operations that are handled as one unit of work,
 the database will be automatically rolled back to a valid state if any of the individual operations fails. 

BEGIN TRANSACTION;
INSERT INTO widgetSales ( inv_id, quan, price ) VALUES ( 1, 5, 500 );
UPDATE widgetInventory SET onhand = ( onhand - 5 ) WHERE id = 1;
ROLLBACK;
END TRANSACTION;

performance
-----------
-- Transactions are commonly used to increase performance, if a long list of inserts or updates are performed as a unit they can be performed much faster than as individual statements. 

TRIGGERS
========
Triggers are operations that are automatically performed when a specified database event occurs.
  
CREATE TRIGGER triggerName AFTER/BEFORE UPDATE/INSERT/DELETE ON tableName
    BEGIN
        SQL STMTS;
		-- Note: NEW represents the virtual row, ex: NEW.id,
    END
;

Preventing UPDATE
------------------
CREATE TRIGGER updateWidgetSale BEFORE UPDATE ON widgetSale
    BEGIN
        SELECT RAISE(ROLLBACK, 'cannot update table "widgetSale"') FROM widgetSale
            WHERE id = NEW.id AND reconciled = 1;
    END
;

Views and SubSelect
===================
CREATE VIEW viewName AS


	subSelect Query;
	
DROP VIEW IF EXISTS viewName;	

Creating a joined view
----------------------

