This course is designed to teach you how to use threads in your program, but it's not making recommendations or suggestions for when and why you should use threads.

for advance traiing, 
https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html

Thread
======
- Every Java program has a default main thread, 
  created automatically by the JVM.	
- A thread is an independent path of code execution.
- Many threads can run concurrently in a Java Program.
- Threads can be used to perform time-intensive tasks.
- Runnable are objects that encapsulate code sequences.
- Each thread executes a runnable object.
- Threads can intiate an asynchronous task.
- Asynchronous indicates that it can run concurrently.

- the JVM gives each thread its own private JVM stack.
- This prevents threads from interfering with each other.
- The stack holds local variables.
- It also tracks next instructions and calls methods.

- Java supports threads through java.lang.Thread class, and java.lang.Runnable interface.
- Threads are either daemon or non-daemon.
- Daemon threads don't stop the JVM from ending.
- Threads by default are non-daemon threads.

- Java Garbage collection runs on a daemon thread.
- A daemon thread is created calling setDaemon(true).
- The main thread is a non-daemon thread.
- The program ends when non-daemon threads have died.


New Thread() {start()} --> Runnable {run()} --> Running {wait()/sleep()} --> Waiting {elapsed time} --> Dead 

Create a Thread:
================
Two ways:
- class extend from Thread class and override the run() method.
 (an instance of this subclass can be allocated and started).
- class implement Runnable interface, and override the run() method, create a Runnable obj use Thread constructor.

Thread()

Thread(Runnable obj)

Thread(Runnable obj, String name)

Thread(String name)

Thread.currentThread().getName()

Note: didn't escape the number if you have other thread with names.

Thread states
=============
- Each thread object has a state.
- State includes a name, alive/dead, execution state, and priority, and a daemon/non-daemon status.
- Each attribute has a get/set method associated with it.

NEW - created but not started.
RUNNABLE - a thread executing in the JVM.
BLOCKED - blocked waiting for a monitor to be unlocked.
WAITING - waiting to be notified to continue.
TIME_WAITING - waiting with a time limit.
TERMINATED - a thread that has completed execution

Advanced thread tasks
=====================
- Thread class has useful methods for thread (static and non-static methods).
- Static methods affect the current thread.
- Non-static methods operate the calling thread. 

Static methods:
---------------
- activeCount() - returns estimated number of threads.
- currentThread() - returns refernce to the current thread.
- enumerate(Thread[] tarr) - list of active threads.
- sleep(long millis) - sleep or stop execution.

Non-Static methods:
-------------------
- join() - returns estimated number of threads.
- interrupt() - 

Problem with threads:
=====================
Multithreaded application problems:
- Thread interaction can cause a problem.
- Problems include race conditions, data races, and cached variable problems, 
	these makes a application thread-unsafe.
	
- A race condition occurs when threads depend on relative timing by the scheduler.
- A data race occurs when two or more threads access the same memory location. 

Synchronization explained
=========================
- Synchronization can be used to solve race conditions, data races, and cached variable problems.
- JVM feature.
- Prevents two threads from accessig a critical section.
- Ensures threads can safely update shared variables.
- Can be applied to methods or code block by mark sychronized keyword.
- Synchronized code is knows as critical sections.
- JVM supports it via monitors.
- Every Java object is associated with a monitor.
- If the monitor is already locked, the thread is blocked.
- Shared variables are copied into the thread's working memory.
- This ensures access to most recent values.
- when done, it writes values back to main memory.

Synchronized Methods
====================
- modifier static synchronized dataType mehtodName(){}
- Threads 1 obtains the lock.
- The lock is released for thread 2.

Synchronized Block
====================
- A Synchronized block is identified by a special header.
- The header identifies the object for the lock.
	synchronized(object){
		/**/
	}

wait and Notify API
===================
- Communication is important when threads share data.
- void wait();
- void wait(long millis);
- void wait(long millis, int nano); // in a recent version of java

- void notify();
- void notifyAll();
- The API uses the object's condition queue.
- A condition queue stores threads that are in a wait state.

- The waiting threads are known as the wait set.
- The current thread mst own the object's monitor.

- be aware from Dealock
  "It's when two or more threads are blocked forever waiting for each other ..."


Concurrency
===========
Concurrent Utilities in java:
- Offer a powerful and extensive framework for threads.
- Includes a high-performance thread pool.
- A framework for asynchronous tasks.
- Collection classes optimized for concurrent access.



Advantages:
------------
- Reduced programming effort.
- Increased performance.
- Increased reliability.
- Improved maintainability.

Utilities Include:
------------------
- Task scheduling framework such as executors.
- Fork/Join framework.
- Concurrent collections.
- Atomic variable.
- Synchronizers.
- Locks.
- Nanosecond granularity timing.


Executors:
==========
- Defines a high-level API to manage threads.
- Provides thread pool manmagement.
- Separate thread creation and thread management from the rest of your application.
- Uses worker threads to minimize overhead.

Executor Interfaces:
--------------------
- Executor - Supports launching new tasks.
- ExecutorService - ass features to manage lifecycle.
- ScheduledExecutorService - supports future tasks.
by using executor interfaces, these simplify the creation of threads.


























