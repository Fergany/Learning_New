
https://dzone.com/articles/java-getter-and-setter-basics-common-mistakes-and

the rule of thumb is: If you pass an object reference into a setter method, then don’t copy that reference into the internal variable directly. Instead, you should find some ways to copy values of the passed object into the internal object,

So the rule of thumb is: Do not return a reference of the original object in the getter method. Instead, it should return a copy of the original object.

// in array

public int[] getScores() {
    int[] copy = new int[this.scores.length];
    System.arraycopy(this.scores, 0, copy, 0, copy.length);
    return copy;
}

// you can use .clone() metods from Object cls.

// like in date object

private Date birthDate;

public void setBirthDate(Date date) {
    this.birthDate = (Date) date.clone();
}
public Date getBirthDate() {
    return (Date) this.birthDate.clone();
}

https://codeburst.io/top-3-programming-languages-java-devs-can-learn-in-2019-de31fc97901e
"If you want to move to the functional programming side, then Scala is the best choice.
 If you are interested in developing mobile games and apps, then Kotlin will help you, 
and if you want to do scripting, then Groovy is a great language. It helps a lot in unit testing and build automation stuff. Since Groovy compiles to Java, it effectively complements the Java programming language."


Clean Code
==========
https://dev.to/paulasantamaria/clean-code-why-bother-part-2-1eme

The 2019 Java Developer Roadmap
===============================
https://dzone.com/articles/the-2019-java-developer-roadmap

GraphQL
========
GraphQL: we can finally stop arguing about URLs

GraphQL solves this problem by giving developers a /*single endpoint*/ that hands over control of what data is returned, including related data and built-in filtering! You name root queries much the same way that you would name functions. 
In GraphQL your query might look something like this:
query {
    company(id: "abc123") {
        id
        name
        mentors {
            id
            name
        }
    }
}

https://dev.to/jeremycmorgan/7-great-programming-quotes-o95
 
 

Clean Code Summary and Key Points
=================================
https://dzone.com/articles/clean-code-summary-and-key-points


GIT
===
git reset HEAD^
#git reset without a --hard or --soft moves your HEAD to point to the specified commit, without changing any files. HEAD^ refers to the (first) parent commit of your current commit, which in your case is the commit before the temporary one.

git checkout -b new-branch
git branch -d deleted-branch



Build Maven Project
===================
mvn package

NodeJS
======
run parallel tasks:

"dev": "npm-run-all --parallel start-watch wp-server"
https://stackoverflow.com/questions/30950032/how-can-i-run-multiple-npm-scripts-in-parallel




