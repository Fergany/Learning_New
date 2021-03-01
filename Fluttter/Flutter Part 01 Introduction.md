#### What is flutter?
- open-source, mobile development framework created by Google. 
- You write your app in the Dart programming language which gets compiled to run on both Android and iOS
- Single codebase: 
    - Write once, Run on both Android and IOS.
    - Native performance
-  Unlike other cross-platform solutions, which uses a bridge to connect your code with the underlying platform, Flutter code get compiled directly into machine code eliminating the performers bottleneck from the bridge. Flutter gives you native performance and native look and feel with a single code base, 
- which means that you get to build apps quickly, and they run quickly as well. 

### Why Flutter?
- One codebase to rule them all.
- You have to know only one language.
- Using flutter to build IOS, Androis, Web and desktop app.
- Open source code

### The anatomy of Flutter app
in order to create a new app:
- Create **scaffold** (blank screen for your app).
- Inside the **scaffold** you add **AppBar** in the top.
- **Container** box to contain the content of the app.
- **Container** will have **column**.
- **Column** will have two items **widget**, row and text.
- in the row you can add image widget, text widget and so on.
- by the end you will have a widget tree that are nested to each other.

 
### Flutter: Part 03 Flutter Widgets
Hot reload vs hot restart
**Hot reload** 
**Hot restart** reset the state of the whole app

The way that Hot Reload and Hot Restart work, what they do is they will only look at the changes that were made, and they will push those changes on to your testing device