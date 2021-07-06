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

### Flutter: Part 08 Powering Your App with Live Web Data
- async: let ur prg proceed executing while waiting for a result.
- Future Operation:
  are operations that takes sometimes to execute and return result later,
we can handle it using async & await.
  "something will execute in the future"
  "promise that something will happen in the future"
  "like promise in JS"
  
#### Stateful widget lifecycle

in stateless widget you have to destroy them and 

Stateless Widgets are basically just like very simple lego blocks, right? You can't saw them in half, you can't change them, you can't do anything with them, 
unless you decide to destroy them and create a new one. 
And you have to keep destroying and creating new ones every time you want a change in a Stateless Widget. So for these widgets, their lifecycle methods are very simple, there's only one that you should be concerned

#### lifecycle
- intiState(); // when created and added into the tree
- build() // something happened every single time when the widget rebuild
- deactivate() ==> triggered when this Stateful Widget gets destroyed. 

#### Exception Handling
- When something unexpected happen, instead of our code crash, 
you write code to handle this exception.
```aidl
  try {
  } catch (exception) {
  }
```

Null aware operation:
to check if the var has a value use it, if not use the other value
```aidl
  variable ?? otherValue
```

#### Networking with Flutter http pkg
```aidl
import 'package:http/http.dart' as http;
...
void getRespone() async {
  http.Resposne response = await http.get(url);
  print(response.body);// response.statusCode
  } 
  without as http
  Resposne response = await get(url);
  print(response.body);// response.statusCode
  } 
```

#### JSON parsing and dynamics types
