# Advanced Java Programming

### Generic in Java
Generics are a way to tell a compiler what type of object a collection can contain.
This means that there is no need to cast the object to a specific type when I assign it to a variable.

#### Generic Methods in Java
T ==> new type variable, called T. 
- This type variable only has local scope, 
- which means that I can only use it inside this particular method. 
- I can use it in the method signature, and inside the body of the method, but not outside the method.  
**Usage:**
 - Make sure that you are using the same type.

**Example:**
```
    static Character[] charArr = {'a', 'b', 'c'};
    static String[] strArr = {"str1", "str2", "str3"};

    public static List<Object> arrayToList(Object[] array, List<Object> list) {
        for(Object obj : array){
            list.add(obj);
        }
        return list;
    }

    // what if i pass here arrayToList(booleanArray, new ArrayList<>());
    // no problem in the compiler but when running, it will cause an error 
    // to fix it
    
    public static<T> List<T> arrayToList(T[] array, List<T> list) {
         for(Object obj : array){
             list.add(obj);
         }
         return list;
    }

    // so here you will got a compiler time error
```
Because T is a generic type, it doesn't matter what type I use, as long as it is the **same type every time I use it**. 
The type of the array list can also be a supertype of the type of the element type of the array. 

### Using varargs in Java 
With this, I can pass no/one/two/.. or arrays of items.

**Example:**
```
    public static printStringList(String... items){
        for(int i = 0; i < items.length; i++){
            sout(items[i]);
        }
    }

    printStringList();
    printStringList("str1");
    printStringList("str1", "str2", "str3");
    printStringList(new String[]{"str1", "str2", "str3"});

```
**Note**
 I can pass in array if I want to, but there is no need to create one in this case because the varargs method will create an **array** for me anyway
 
### The substitution principle in Java
We have 3 classes
```
    public Building
    public Office extends Building
    public House extends Building

    public printBuildings(List<Building> buildings){
    }
```
and when you try to print offices or houses you get 
### Using wild cards in Generic Programming
```
    public void printBuildings(List<? extends Building> buildings){
    }

```
so here you are allowed to print list of buildings or one of their subclasses.

what if I need to send list of classes or the super lasses

```
    public void printBuildings(List<? super House> buildings){
    }
``` 

**Note:** 
It is generally a bad idea to use wildcards as return types for a method. 
If I did this, anyone else who used these methods would have to spend time working out the hierarchies in my code. 
When used in the right places, wildcards can make your code more flexible and helps to get rid of duplicate methods.

### Advanced Data Structure

#### Collections Framework.

**Four Main Factors:**
  - Ordering
  - Duplicates.
  - Speed.
  - Memory.

**Hierarchy**  
- Iterable
  - Collection
    - Set -> No duplicate, Unordered. 
    - List -> Duplicate allowed, Ordered.
    - Queue -> Type of collection that allows you to add elements to the head of the collection following FIFO structure.
    
**There also another structure called Maps**
- Not belong to Collection interface.
- Because they contain key-value pairs.
- however, they are still considered to be a part of the collections framework in Java.


**Let's see ways of obtaining different Collections from a Map, which we can then pivot into a Stream:**
```
    Map<String, Integer> someMap = new HashMap<>();
```

We can obtain a set of key-value pairs:
```
    Set<Map.Entry<String, Integer>> entries = someMap.entrySet();
```

We can also get the key set associated with the Map:
```
    Set<String> keySet = someMap.keySet();
```

Or we could work directly with the set of values:
```
    Collection<Integer> values = someMap.values();
```
These each give us an entry point to process those collections by obtaining streams from them:
```
    Stream<Map.Entry<String, Integer>> entriesStream = entries.stream();
    Stream<Integer> valuesStream = values.stream();
    Stream<String> keysStream = keySet.stream();
```
Link how to deal Maps with Streams:
https://www.baeldung.com/java-maps-streams

#### Linked List
- A linked list is a doubly linked collection of elements. 
- Each entry in the list also holds a reference to the address of the next and the previous item in the list. 
- The main advantage of using a linked list is that they are very quick for inserting and removing elements in the middle of a list
```
    LinkedList<String> myList = new LinkedList();
    myList.add("str 1");
    myList.add("str 2");
    myList.add(1, "str between 1 & 2");
    sout(myList); // ["str 1", "str between 1 & 2", "str 2"]
    myLiist.remove("str 2");
    sout(myList); // ["str 1", "str between 1 & 2"]
```
 **Tips**
 - Linked Lists are often compared to array lists because they both implement the **list** interface and so they have lots of methods in common.
 - However, there are some differences behind the scenes that only become obvious when dealing with lists that **have lots of elements** in them. 
 - If I wanted to **insert/remove** lots of elements in the **middle** of the list, it would be faster to use **linked list**. 
 - On the other hand, if I wanted to **get** elements from the list, then an **array list** would be much faster. 
 - **Linked lists** also take up **more memory** than array lists because in a **linked list** each **entry** contains a **reference** to elements in the list and also to the next and previous elements. 
 - For most cases, if you have to choose between array list and linked list, the better choice is **array list**,
 If you are in doubt, use an **array list**, 
 - but if you know that you will need to **add** or **remove** lots of elements in the **middle**, then a **linked list** is the better option.

#### Implementing a queue using a linked list
```
    LinkedList<Customer> queue = new LinkedList();
    queue.add(c1);
    queue.add(c2);
    queue.add(c3);
    sout(queueu);
    Customer c = queue.poll();
    c.serve();
    sout(queue);
```    
### Storing Pair with HashMap
```
    HashMap<String, Integer> map = new HashMap();
    map.put("7mdada", intVal);
    map.put(null, intVal); // can have null as a key value, not null as a value
    sout(map); // will note print with the same order you've insert the elements
    // This is because hashmaps are unordered. Entries are stored by their contents, not by their position
    // Duplicate key are not allowed
    map.containsKey(strValue); // boolean
    map.containsValue(intValue); // boolean
    map.clear(); // remove all from this map

    // to loop from HashMap
    for(Map.Entry<Key, Value> entry : hashMap.entrySet()){
        entry.getKey();
        entry.getValue();
    } 

```
### Implementing LinkedHashMap();
When using a normal HashMap there is no guarantee that you can get the entries back in the same order that you put them in. However, when you use a linked HashMap, the order of the entries is retained.
Keep track of the order of the entites.

**Constructors:**
```
    LinkedHashMap<> map = new LinkedHashMap();
    new LinkedHashMap(capacity, .75f, )
```
- The first argument is the initial capacity of the map, 
 a linked HashMap with four entries will be created. 
- The second argument is called the Load Factor,
This specifies how full the map can be before it is made bigger. 
For example, I will pass in not .75f, which is actually the default value. This means that when the map is 75% full, it will increase in size.

## Functional Programming 
### Functional Interface 
- is an interface that has at most one abstract method (or nothing).
-  @FunctionalInterface:
    - helps you that you can't add another method.
- you have a lot of ways to implement the functional interface, like anonymous inner classes:

```
    FunctionalInterfaceExample in = new FunctionalInterface() {
        @Override
        public void greet(Stirng name){
            sout(name);
        }
    };
    
    in.greet("Hazem");
```  

### Lambda Expresison
Lambdas provide a short and simple way to implement functional interfaces in Java. 
```
    FunctionalInterfaceExample in = (String name) -> {
        sout(name);
    };
    in.callAbstractMethod("zoomy");

    // you also can implement no args method.
    FunctionalInterfaceExample2 in = () -> {
        sout("hello from the other functional interface");
    };
    in.callAbstractMethod();
```      
### Using Method Reference
Method references are a shorthand way of writing a certain type of lambda expression. 
If you have a lambda expression that passes in a variable and then calls a method on that variable, 
you can replace it with a method reference

```
    ClassName::MethodName
```

### Streams
**External Iteration**
- Hard to write parallel iterations.
- Requires boilerplate code.
- Difficult to read meaning
```
    books
    .stream()
    .filter(book -> {
        return book.getAuthor().startWith("J");
    })
    .forEach(System.out::prinln);
``` 
**Stream has different types of mwthods:**

- Lazy Method
   - you can add more than one lazy method
   - example: filter(), it checks the condition, if happends adds i to the stream.
- Eager Method
   - you can't add more eager method, As with normal methods, I can only return one value.
   - example: forEach()   
   
This is much simpler and more readable then using a for loop here I would have had to use two nested if statements inside a for loop to write this code. 
The implementation is all done under the hood and the code is much shorter and clearer to understand.

### Implementing Parallel stream
- One of the advantages of using streams over using for loops, is that you can run iterations in parallel.
- Speed of the performance
- depends on how many core is vaialble
- Firstly, there is only really a performance impact when you are using a very large amount of data. 
- If you only have a small dataset, it might actually be more efficient to use a normal stream.
```
    .parallelStream()
```   

### Modular Programming in Java
- So why was a module system introduced? This can be answered by looking at the JDK itself. 
- Before Java 9, the JDK was one huge monolithic structure. Even if you only wanted to write a small application, you still had to have the whole huge JDK on your machine. 
- That was even if you weren't using a lot of it. 
- Another problem was that old unused code or old code with a security vulnerabilities was very difficult to remove. 

- Modules contain code, and maybe other resources.
- Modules have unique name (Like pkgs in java).
- Modules contains some info describing itself.
- By default, anything hidden to the outside world. Even if a class is public, it's actually not accessible outside of the module. 
- But each module has a module descriptor. 
- This can be used to specify if code in the module should be accessible to other modules. 
- The descriptor can also be used to state if code from other modules is going to be used. 

- This is a useful way to make sure code is encapsulated. Only the code that is needed can be made visible to the outside world. And it makes structuring large code bases much more manageable.

### Creating a module in java
- in the same directory of your project create new module
```
    module ModuleName {
        requires pkgname;
        exports pkgname;
    }
```

### Running as module from a command line:
```
    javac -d ouput_directory java_src_file module_src_file
    java --module-path (or -p) ouput_directory --module (or -m) com.module_name.class_name
```

## Multithreading in Java
Threads allow multiple actions to be performed at the same time inside a single process.
**Example:**
- Stove & Burner (burner is core).
- Java API for thread handling.

Two Ways to use Threads in Java.
- extends Thread class and override and override run().
```
    ThreadExample thread = new ThreadExample();
    newThread.setName("7mada");    
    newThread.start();
```
- implements Runnable interface and override run().
- One of the benefits of impelmenting a runnable interface, instead of extending the thread class, is that if my class extends the thread class, than I can't extend any other classes. In Java, you are only allowed to extend one class.
```
    RunnableExample implemets Runnable {
        @Override
        public void run() {
            ...


    RunnableExample runnableExample = new RunnableExample();
    ThreadExample thread = new ThreadExample(runnableExample);
    newThread.setName("7mada");    
    newThread.start();
```

### Synchronized methods in Java
 - add synchronized keyword before return type.
 - This means that now only one thread can enter this method at a time.
 - there is also A synchronized block or synchronized statement is a section of codes that only one thread can enter at a time.   
 
### Avoid thread deaadlock
- The object in brackets is known as a monitor object. And this means that if a thread is inside the synchronized block, no other thread can do anything with that object.
- How to fix this depends on the situation and the context. In general, it is better to avoid using nested blocks of synchronized code like this. In this example, one way to fix it is to make both cooks try and pick up the same object first

### Input and Output (I/O)
Streams are a way of reading/writing data.
- Reading/Writing files in a program.
-= Taking user input from the console.
- Communicating through sockets.

Streams represent a flow of data and a bit like real streams of water, they can only go in one direction.


Two abstracts classes in java.io
##### InputStream read data.
   - FileInputStream
   - ByteArrayInputStream
   - FilterInputStream
    and so on.
##### OutputStream write data:
   - FileOutputStream
   - ByteArrayOutputStream
   - FilterOutputStream
   and so on.  
   
We have **Reader** and **Writer** abstract class like In/OutputStream
the different is Stream for moving bytes, Reader and Writer move characters.

### Reading Console Input with a Scanner
- The scanner class is useful for reading small amounts of input and is relatively easy to use. 
- Scanners work with primitive types, i.e. all of the built-in data types in Java.    
 
### Reading files with BufferedReader
```
    File file = new File("test.txt);
    BufferRreader reader = new BufferReader(new FileReader(file));
    String line;    
    while((reader = reader.readLine()) != null) {
        print(line);
    } 

``` 
### Using a try-with-resources with I/O


### Working with Files and Directories
#### Create a new File
```
    File file = new File("C://path/to/file.ext");
    // here we don't create a file, we've just created a file object. This is just an abstract representation of a file.
    file.createNewFile(); // boolean function thows exception IOException
``` 

#### Working with directories in Java
```
    String[] names = new File(".").list(); // list all the files in ur directory
    // also you have a functional interface **FilenameFilter** to filter the files returned, pass to list
    new File("newDirectory").mmkdir(); // make a diectory
```
#### Using the Path Class
- The best way to move, copy, and delete files in Java is with the path class. 
- This offers the additional functionality which is not available in the file class.
```
    Path path = Paths.get("file_name.ext");
    Files.deleteIfExsits(path); // throws IOException
``` 
Copying files using Paths & Files class:
```
    Path src
 = Paths.get();
    Path target = Paths.get();
    Files.copy(src, target); // throws IOException 
```
