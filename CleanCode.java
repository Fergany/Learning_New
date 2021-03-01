Clean Code
==========

Clean Code Summary and Key Points
=================================
https://dzone.com/articles/clean-code-summary-and-key-points

Ch.1
====
This “code-sense” is the key, 
Some of us are born with it. Some of us have to fight to acquire it.

A programmer without “code-sense” can look at a messy module and recognize the
mess but will have no idea what to do about it. A programmer with “code-sense” will look
at a messy module and see options and variations. The “code-sense” will help that programmer
choose the best variation and guide him or her to plot a sequence of behavior
preserving transformations to get from here to there.
In short, a programmer who writes clean code is an artist who can take a blank screen
through a series of transformations until it is an elegantly coded system.

We are authors. And one thing about
authors is that they have readers. Indeed, authors are responsible for communicating well
with their readers. The next time you write a line of code, remember you are an author,
writing for readers who will judge your effort.

Conclusion
Books on art don’t promise to make you an artist. All they can do is give you some of the
tools, techniques, and thought processes that other artists have used. So too this book cannot
promise to make you a good programmer. It cannot promise to give you “code-sense.”
All it can do is show you the thought processes of good programmers and the tricks, techniques,
and tools that they use.
Just like a book on art, this book will be full of details. There will be lots of code.
You’ll see good code and you’ll see bad code. You’ll see bad code transformed into good
code. You’ll see lists of heuristics, disciplines, and techniques. You’ll see example after
example. After that, it’s up to you.
Remember the old joke about the concert violinist who got lost on his way to a performance?
He stopped an old man on the corner and asked him how to get to Carnegie Hall.
The old man looked at the violinist and the violin tucked under his arm, and said: “Practice,
son. Practice!”

Ch.2
====

Meaningful Names
Names of the classes, variables, and methods must be meaningful and clearly indicate what a method does or what an attribute is.

Create pronounceable names to facilitate communication.

Avoid acronyms and avoid confusing names, which may bring anyone who reads the code to the wrong conclusions.

Use names that reflect the system domain, the context, and the problems that must be solved.


Choosing good names takes time but saves more than it takes.
Avoid Disinformation
Do not refer to a grouping of accounts as an accountList unless it’s actually a List.

Programmers create problems for themselves
when they write code solely to satisfy
a compiler or interpreter. For example,
because you can’t use the same name to refer
to two different things in the same scope,
you might be tempted to change one name
in an arbitrary way.

In the absence of specific conventions, the variable moneyAmount is indistinguishable
from money, customerInfo is indistinguishable from customer, accountData is indistinguishable
from account, and theMessage is indistinguishable from message. Distinguish names in
such a way that the reader knows what the differences offer.

make your names pronounceable (If you can’t pronounce it, you can’t discuss it without sounding like an idiot.)

Use Searchable Names

My personal preference is that single-letter names can ONLY be used as local variables
inside short methods. The length of a name should correspond to the size of its scope

Member Prefixes
You also don’t need to prefix member variables with m_ anymore.

Don't use I in interface name

One difference between a smart programmer and a professional programmer is that
the professional understands that clarity is king. Professionals use their powers for good
and write code that others can understand.

A class name should not be a verb.

Methods should have verb or verb phrase names


When constructors are overloaded, use static factory methods with names that
describe the arguments. For example,
Complex fulcrumPoint = Complex.FromRealNumber(23.0);
is generally better than
Complex fulcrumPoint = new Complex(23.0);

Choose clarity over entertainment value. (Don't be cute)


Ch.3
=====
Functions

Small!

- The first rule of functions is that they should be small. 
- The second rule of functions is that they should be smaller than that.

Blocks and Indenting

This implies that the blocks within if statements, else statements, while statements, and
so on should be one line long. Probably that line should be a function call. Not only does
this keep the enclosing function small, but it also adds documentary value because the
function called within the block can have a nicely descriptive name.

Do One Thing
FUNCTIONS SHOULD DO ONE THING. THEY SHOULD DO IT WELL.
THEY SHOULD DO IT ONLY.

	"So, another way to know that a function is doing more than “one thing” is if you can
extract another function from it with a name that is not merely a restatement of its implementation"

One Level of Abstraction per Function
	we need to make sure that the
statements within our function are all at the same level of abstraction.
	Mixing levels of abstraction within a function is always confusing. Readers may not
be able to tell whether a particular expression is an essential concept or a detail.


Reading Code from Top to Bottom: The Stepdown Rule

Switch Statement

Use Descriptive Names
	The smaller and more focused a function is, the easier it is to choose a descriptive
name.

Function Arguments
	The ideal number of arguments for a function is
	zero (niladic). Next comes one (monadic), followed
	closely by two (dyadic). Three arguments (triadic)
	should be avoided where possible. More than three
	(polyadic) requires very special justification—and
	then shouldn’t be used anyway.
	
Argument Objects
When a function seems to need more than two or three arguments, it is likely that some of
those arguments ought to be wrapped into a class of their own.

Structured Programming
Some programmers follow Edsger Dijkstra’s rules of structured programming.14 Dijkstra
said that every function, and every block within a function, should have one entry and one
exit. Following these rules means that there should only be one return statement in a function,
no break or continue statements in a loop, and never, ever, any goto statements.
	
	
Ch. 4 Comments
==============
Don't comment bad code, rewrite it.
	
Truth can only be found in one place: the code. Only the code can truly tell you what
it does.

Explain urself in code.

The only truly good comment is the comment you found a way not to write.

Warning of Consequences:
like 

TODO Comments:
	TODOs are jobs that the programmer thinks should be done, but for some reason
	can’t do at the moment. It might be a reminder to delete a deprecated feature or a
	plea for someone else to look at a problem. It might be a request for someone else to
	think of a better name or a reminder to make a change that is dependent on a
	planned event. Whatever else a TODO might be, it is not an excuse to leave bad code in
	the system.
	
Amplification
	A comment may be used to amplify the importance of something that may otherwise seem
	inconsequential.	
	
uplication.

Comments:
=========

One of the most common reasons for the comments is because the code is bad.

If you're thinking about writing a comment, then the code should be refactored.

Comments do not save a bad code.

Try to explain what the code causes to happen.

Comments can be useful when placed in certain places.

Create method names and informative variables instead of explaining the code with comments.

Comments can be used to express the importance of certain points in the code.

The best comment is one that needs to be written because your code already explained.

Do not write comments with redundant, useless, or false information.

They should not be used to indicate who changed or why, for that already exists in versioning.

Don’t comment code that will not be used, remove, it just pollutes the code and leaves no doubt in anyone reading.	


Ch.7 Error Handling
===================
Error handling should be planned carefully by all programmers.

When wrong things occur, we have to get it to do the right things.

We should give preference to launching an exception than treating it just to hide.

Create messages with information about the error.

Mention that it failed. Where was this failure? If possible, mention why it failed.

Look at separate business rules for errors and error handling.

Avoid returning a NULL in methods, preferably to return an empty object.

Avoid passing NULL to the methods; this can generate NullPointerExceptions.