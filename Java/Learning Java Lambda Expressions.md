# Learning Java Lambda Expressions
- Was introduced in Java 8.
- They can be used to replace anonymous inner class.

### Java 8
- Java has added two new pkgs:
  - java.util.function
  - java.util.stream
  
**Example of Functional Interface in Java:**
- Predicate - takes one args, return boolean.
- Consumer - accept single argument with no return value.
- Function - accepts one argumants and return a result.
- Supplier - represents a supplier of results.
- UnaryOperator - single argument with a return value.
- BinaryOperator - takes two args and return one.  
```
        //using the test method of Predicate
        Predicate<String> stringLen  = (s)-> s.length() < 10;
        System.out.println(stringLen.test("Apples") + " - Apples is less than 10");

        //Consumer example uses accept method
         Consumer<String> consumerStr = (s) -> System.out.println(s.toLowerCase());
         consumerStr.accept("ABCDefghijklmnopQRSTuvWxyZ");
         
        //Function example        
        Function<Integer,String> converter = (num)-> Integer.toString(num);
        System.out.println("length of 26: " + converter.apply(26).length());

        //Supplier example
        Supplier<String> s  = ()-> "Java is fun";
        System.out.println(s.get());
        
        //Binary Operator example
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("add 10 + 25: " + add.apply(10, 25));
        
        //Unary Operator example
        UnaryOperator<String> str  = (msg)-> msg.toUpperCase();
        System.out.println(str.apply("This is my message in upper case"));
```   

**note**
for the method that returms value, you are allowed to write:

**instead of:**
```
    BinaryOperator<Integer> add = (a, b) -> a + b;
```

**you can write:**
```
    BinaryOperator<Integer> add = (a, b) -> {return a + b;};
```

### Methods as Lambda
```
        //static method reference using ::
        IntFunction<String> intToString2 = Integer::toString;
        System.out.println("expected value 4, actual value:  " + 
                intToString2.apply(4567).length());
        
        //lambdas made using a constructor
        Function<String,BigInteger> newBigInt = BigInteger::new;
        System.out.println("expected value: 123456789, actual value: "+ 
                newBigInt.apply("123456789"));
        
        //example of a lambda made from an instance method
        Consumer<String> print = System.out::println;
        print.accept("Coming to you directly from a lambda...");
        
        //these two are the same using the static method concat
        UnaryOperator<String> greeting = x -> "Hello, ".concat(x);
        System.out.println(greeting.apply("World"));
        
        UnaryOperator<String> makeGreeting = "Hello, "::concat;
        System.out.println(makeGreeting.apply("Peggy"));
``` 
### Creating FunctionalInterface
```
    @FunctionalInterface
```
then in your interface implementation, you are not allowed to add more than on function.

### Collections
- A collection is a group of elemens.
- They can store, retrieve, manipulate, and communicate aggregate data.
```
        List<String> names = Arrays.asList("Paul", "Jane", "Michaela", "Sam");
        //way to sort prior to Java 8 lambdas
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        //first iteration with lambda
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        //now remove the return statement
        Collections.sort(names, (String a, String b) -> b.compareTo(a));
        
        //now remove the data types and allow the compile to infer the type
        Collections.sort(names, (a, b) -> b.compareTo(a));

   
        //total pages in your book collection
        Book book1 = new Book("Miss Peregrine's Home for Peculiar Children",
                "Ranson", "Riggs", 382);
        Book book2 = new Book("Harry Potter and The Sorcerers Stone",
                "JK", "Rowling", 411);
        Book book3 = new Book("The Cat in the Hat",
                "Dr", "Seuss", 45);
        
        List<Book> books = Arrays.asList(book1, book2, book3);
        int total = books.stream()
                .collect(Collectors.summingInt(Book::getPages));
        System.out.println(total);
        
        //create a list with duplicates
        List<Book> dupBooks = Arrays.asList(book1, book2, book3, book1, book2);
        System.out.println("Before removing duplicates: ");
        System.out.println(dupBooks.toString());
        
        Collection<Book> noDups = new HashSet<>(dupBooks);
        System.out.println("After removing duplicates: ");
        System.out.println(noDups.toString());


        //aggregate author first names into a list
        List<String> list = books.stream()
                .map(Book::getAuthorLName)
                .collect(Collectors.toList());
        System.out.println(list);
        
        //example of using Set to eliminate dups and sort automatically
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 3, 3, 2, 1, 1, 1));
        System.out.println(numbers.toString());
```

### Streams
- java.util.stream
- this package contian interface for using streams.
- A stream represents a sequences of elements.
- The sream pkg was added to traverse collections.
- Most stream operation take a lambda expression
- Stream operations are either intermediate or terminate.
- Terminate operations are either void or return a type (ex: forEach, collect).
- Intermediate operation return the stream itself (ex: map. filter, sorted).
- sorted is used to return a sorted view of the stream, but the original collection doesn't been changed.
- Elements in the collection can't be changed.
```
    		Arrays.asList("red", "green", "blue")
                    .stream()
                    .sorted()
                    .findFirst()
                    .ifPresent(System.out::println);
            
            //example of Stream.of with a filter 
            Stream.of("apple", "pear", "banana", "cherry", "apricot")
                    .filter(fruit -> {
                      //  System.out.println("filter: " + fruit);
                        return fruit.startsWith("a"); //predicate
                    })
                    //if the foreach is removed, nothing will print,
                    //the foreach makes it a terminal event
                    .forEach(fruit -> System.out.println("Starts with A: " + fruit));
    
            //using a stream and map operation to create a list of words in caps
            List<String> collected = Stream.of("Java", " Rocks")
                    .map(string -> string.toUpperCase())
                    .collect(toList());
            System.out.println(collected.toString());
``` 

### Primitive Stream
It also includes special streams for some of the primitive data types, specifically int, long, and double
```
            IntStream.range(1, 4)
                    .forEach(System.out::println);
    
            //find the average of the numbers squared
            Arrays.stream(new int[]{1, 2, 3, 4})
                    .map(n -> n * n)
                    .average()

                    .ifPresent(System.out::println);
    
            //map doubles to ints
            Stream.of(1.5, 2.3, 3.7)
                    .mapToInt(Double::intValue)
                    .forEach(System.out::println);
```