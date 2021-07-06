Problem Solving Tips & Tricks
=============================
char[] toCharArray();
int charAt();


java.lang.Math;
	Math.max(i, j);
	
java.util.Arrays;	
	System.out.print( Arrays.toString(arr) );	
	
// to print array list	
	Arrays.toString(list.toArray())

// to sort an array
	Arrays.sort(arr); 
	Arrays.sort(int[] a, int fromIndex/*inclusive*/, int toIndex/*exclusive*/);
	// also for 
	List<String> list = Arrays.asList(arr);  

import java.util.Collections;
	// Ascending
	Collections.sort();
	
	// Descending
	Collections.sort(this.arrayList, Collections.reverseOrder());

// convert List<Intger> to int[]
			list.stream().mapToInt(Integer::intValue).toArray();

// sum all element in stream
			Integer sum = integers.stream()
			.mapToInt(Integer::intValue)
			.sum();

// or in object
			employees
			.stream()
			.filter(employee -> targetEmployee.subordinates.contains(employee.id))
			.map(employee -> employee.importance)
			.reduce(0, Integer::sum);
//convert to map
			Map<String, Long> map =
		Arrays.asList(strings).stream().collect(Collectors.groupingBy(string -> string, Collectors.counting()));

java.util.Arrays.copyOfRange();

public static arr[] copyOfRange(arr[] original, int fromInclusive, int toExclusive);

System.arraycopy(Object source_arr, int sourcePos, Object dest_arr, int destPos, int len)

import java.util.Random;
Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(50);
	
	
Convert integer to String (binary, octal, ....erc)
==================================================	
lang.Integer.toBinaryString(i)
Integer.toString(100,8) // prints 144 --octal representation

Integer.toString(100,2) // prints 1100100 --binary representation

Integer.toString(100,16) //prints 64 --Hex representation

Integer.bitCount(int i) // Returns the number of one-bits

Convert String to Intger
========================
int foo = Integer.parseInt("1001", 2);


System.out.println("i: " + String.format("%32s", 
            Integer.toBinaryString(i)).replaceAll(" ", "0"));

new StringBuilder(hi).reverse().toString()

substring(int beginIndex)
OR
substring(int beginIndex, int endIndex)

public StringBuilder deleteCharAt(int index)

String	trim()

If you're sure that this object is an Integer :

int i = (Integer) object;
Or, starting from Java 7, you can equivalently write:

int i = (int) object;
int a = Character.getNumericValue(c);  
Character.toString ((char) i);
/* ok what is different??
 * System.out.println((int) '1'); || Integer.valueOf('1')// 49
 * System.out.println(Character.getNumericValue('1')); // 1
*/

character to asci
==================
Character.toString ((char) i);
Change people’s lives in a positive direction.
int i = (int) char;

Check that the character is digit:
==================================
Character.isDigit(str.charAt(i))

Character.getNumericValue(c);  

shortest way of filling an array/list with 1,2…n
===========================================
// Java 8
int[] a = IntStream.range(1, 100).toArray();
List<Integer> l = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());
// another way
int n = 10;
int[] values = new int[n];
IntStream.range(1,n+1).forEach(val -> values[val-1] = val);

Replace '.' and '+':
====================
"hazem".replaceAll("\\." , "")
"hazem".replaceAll("\\+" , "")

Iterate through a HashMap [duplicate]
=====================================
Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
        it.remove(); // avoids a ConcurrentModificationException
    }
	
	
	List<List<String>> result = new ArrayList();
        Iterator<Map.Entry<Integer, List<String>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            List<String> list = (List<String>)pair.getValue();
            result.add(list);    
            it.remove(); 
        }
		
		
Regular Expression 
===================
Replace within 
str.replaceAll("regex", "");
ex:
regex to get what within the tages "like html or XML":
String regex = 

// or using pattern 
-------------------
	while (testCases-- > 0) {
            String line = scan.nextLine();
            
            boolean matchFound = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = r.matcher(line);

            while (m.find()) {
                System.out.println(m.group(2));
                matchFound = true;
            }
            if ( ! matchFound) {
                System.out.println("None");
            }
        }


// check that a given pattern is correct:
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexTester {
    public static void main(String[] arguments) {
        String userInputPattern = arguments[0];
        try {
            Pattern.compile(userInputPattern);
        } catch (PatternSyntaxException exception) {
            System.err.println(exception.getDescription());
            System.exit(1);
        }
        System.out.println("Syntax is ok.");
    }
}

Covariant return types in Java
==============================
Before JDK 5.0, it was not possible to override a method by changing the return type. When we override a parent class method, the name, argument types and return type of the overriding method in child class has to be exactly same as that of parent class method. Overriding method was said to be invariant with respect to return type.

Covariant return types

Java 5.0 onwards it is possible to have different return type for a overriding method in child class, but child’s return type should be sub-type of parent’s return type. Overriding method becomes variant with respect to return type.


Using Object.clone()
Java array internally implements a Cloneable interface and thus it is easy to clone a Java array.
You can clone one-dimensional as well as two-dimensional arrays.
When you clone one-dimensional array, it makes a deep copy of array elements which is copying the values.

On the other hand, when you clone two dimensional or multi-dimensional arrays,
a shallow copy of elements is made i.e. only references are copied.
This cloning of arrays is done by the ‘Clone ()’ method provided by the arrays.