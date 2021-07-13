Lynda.com - Learning Angular
----------------------------

https://github.com/planetoftheweb/learnangular5

Using the Angular CLI
---------------------
Angular:
- App framework
- Angular provides you the ability to build client side web application.
- Component based.
  Angular itself, not Angular JS, is a component-based framework, which means that the way you build code is by creating small pieces of code and then connecting them together. Each piece can contain its own scripts, templates and CSS, and can talk to other components.
  
- Modular
  Now, the Angular framework itself is considered to be a modular framework, and that means that you don't just build small components yourself, but that in order to use different features of the framework you load up only the pieces that you need,
  And that makes this framework super fast and efficient  

Features:
- Data binding.
	This involves learning how to connect your templates, which are sometimes called views, and your information, which is sometimes called models or data.
	
- Templates
    Angular has a rich templating system that looks like HTML with some additional formats for attributes and even tags that you build and define yourself.	

- CLI

Angular CLI:
- Command line interface.
- Scaffolds an app (creating an app with common settings quickly).

Main CLI components:
- ng new Name (create/scaffold a new application).
- ng serve (run the application in development).
  ng serve -o 
  -o option, which will open up a browser while it's serving a copy of the application.
  
- ng build (publish the app to the server, create 'dist' directory).
- ng g TYPE NAME


npm install -g @angular/cli

Understanding Angular CLI project:
----------------------------------
 dist
 src
 
 angular-cli.json:

 main.ts
 
 A really important file is the main.ts file. This is the first file that your application will load so it boots up the application and loads up all the different modules. 
 The main TS file is the main.ts file which loads everything else in your application
 
Installing additional framework:
--------------------------------
package.json
npm install jquery --save-dev

install this pkg and save it as development dependencies.

npm install pkg@veriosn --save-dev

Understanding templates in Angular:
-----------------------------------
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html', // or template to write the code directly, in case of multi-line use this ` back tick not '
  styleUrls: ['./header.component.css'] // or style: [` some styles`] applied only to this template.
})

Binding Data to templates:
--------------------------
Angular lets you use the data that you have in your components inside your templates, and that is known as binding,

ways to interact with ur template:

{{ var }} expression
Directives
constructor() method
	A constructor is a way of giving values to your variables, sometimes called instantiating your variables, when the class gets created, otherwise known as constructed.
Declaring var types

Working with events:
--------------------
( evt ) // Bind to a method
$event info

(click) = "method($event, otherParam)"

and in the AppComponent
export class AppComponent{
	method(e, otherParam){
		console.log(e);
		this.query = otherParam;
	}
}


Using properties:
-----------------
[ PROP ]
Any element property
Compared to expressions

[src]="'./artist.imageSrc' + '.jpg'"
this source attribute is not going to try to display an image until this expression in this right side has been taken care of, and so you're never going to get sort of a flash of a second where the images aren't going to be loaded.

Two way binding
----------------
especially used for form elements,
for different types of fields that you might. 

[( ngModel )] allows you to track the value of any input field
[( ngControl )] is for form elements that are not input fields

<input class="form-control mt-2" type="text" [(ngModel)]="query">

Additional imports in 'app.module.ts'
import { FormsModule } from '@angular/forms';

Working with components
-----------------------
Using lifecycle methods:

Two-way data binding
- onInit (way of take care of things after the component has been built, and the great place to load external data)
- Additional imports
- Subscribe to observable
  Observable: New pattern in JavaScript that allows you to wait for something to happen and execute a callback when that something takes place

in the app.modules.ts

	import { HttpClientModule } from '@angular/common/http';

import { HttpClient } from '@angular/common/http';
export class AppComponent implements OnInit {
.............

ngOnInit(): void {
    this.http.get<Object>('../assets/data.json').subscribe( data => {
      this.artists = data;
    })
  }

Creating components:
---------------------

ng generate component component-name

There is an option called minus minus flat that will make the component appear in the same level as the app component
--flat=true|false	
Default: false, When true, creates the new files at the top level of the current project.

Props to pass vars

inputs/imports

generate:
component-name:
---src/app/component-name/component-name.component.css
---src/app/component-name/component-name.component.html
---src/app/component-name/component-name.component.spec.ts
---src/app/component-name/component-name.component.ts

Filtering content:
------------------
ng generate pipe pipe-name 

---src/app/pipe-name.pipe.specs.ts
---src/app/pipe-name.pipe.ts 

Adding subcomponents:
---------------------
ng generate component component-name























































































 
 
 

