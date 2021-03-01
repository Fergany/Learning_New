Angular Essential Training

Angular provides you the ability to build client side web application.

https://www.lynda.com/Angular-tutorials/Angular-Essential-Training/540347-2.html

github repo for the project:
https://github.com/coursefiles/angular2-essential-training

Bascis of TypeScript:
---------------------
Angular src code written in TypeScript, 
TypeScript is a typed superset of JS that gets transpilled to plain JS,
some adv of writing TypeScript:
- ES2015 classes and use Modules.
- Variables
- Functoin signature.


the benefits of writing TypeScript:
- Simplicity.
- Source Code (if u'r writing ur code in the same fashion as the angular src code, it'll be easy for you to look through the src code as u grow ur angular skills.)

Architecture Overview:
----------------------
Angular is build upon components, 
The starting point of an Angular app is the bootstrapping of the initial parent component.


Directives and pipes:
--------------------
Directives:
===========
Structural
	modify layout by altering elements in the DOM.
	designed to alter the DOM layout by adding or removing DOM elements.
	create or remove DOM elements
	
Attribute
	change the behavior or appearance of an existing DOM element.  

Angular Piple:
==============	
A pipe takes end data, like a string or an array, and runs some logic to transform it to a new output. Angular comes with some common pipes, like date in upper case and lower case. You can also write your own pipes to handle custom scenarios that fit your application needs. Pipes are a great way to change data in a reusable way without having to embed the transform logic within component classes, and without having to modify the data just for display purposes.

Date Binding:
-------------
<h1>{{ }}</h1>

Expression and statements.
Value binding.

Dependency Injection
--------------------
Is the concept of IoC.
where you architect code in a way that you provide modules with other modules it needs to get some work done instead of having your modules go out and get other modules on their own. DI allows you to write decoupled code that is easier to unit test and to work with.


Services and other business logic
---------------------------------
spouse
Data persistence
-----------------

Routing
-------

2. Components
-------------
NgModule and the root module
----------------------------
Decorator: Expression that evaluates to a function allowing annotation of calsses at design time.

@DecoratorName(args goes here)

Angular application starting with Angular Module.
define your modules @ app/app.module.ts

"To inform Angular that the class code here is intended to be an Angular module, you need to decorate it with the NgModule decorator."

import { NgModule } from '@angular/core'; //You can import more than one type from a module by adding a comma after each.

@NgModule({
	imports: [],//The import property is used to bring in other Angular modules that your module will need.
	declaration: [], // The declarations property is used to make components, directives and pipes available to your module that don't come from another module.
	bootstrap: [] //The Bootstrap property is used for a root module and will let Angular know which component or components will be the starting point for the Bootstrap process.
})
 
//So from here, you need to follow it up with the class definition for the Angular module. Since this is going to be our app root module, let's name it AppModule. 
export class AppModule {}
// "export" we need  to import this class into another file.

Component
---------
import { Component } from '@angular/core';

@Component({
  selector: 'mw-app',
  templateUrl: 'app/app.component.html'
  // ot template: 'some code'
  // also we can use back ticks around the template value, and start moving things to multiple lines for better readability.
  styles: [`
	//some css code here 
  `]
  // or styleUrls: ['app/app.component.css']
})

export class AppComponent {}

Bootstraping the Module
-----------------------

import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app.module';

platformBrowserDynamic().bootstrapModule(AppModule);

Styling a component
-------------------

Using other components in a component
-------------------------------------


Angular template syntax:
------------------------

- Interpolation
is way to get data displayed in the view.
{{ }}
Nonsupporterd in {{ }}
	= Assignments.
	= Newing up variables.
	= Chaining expressions.
	= Incrementing/Decrementing.
	
- Property Binding
[propertyName]="name expression context property"

- Event Binding
The event binding templates syntax in Angular allows you to easily wire up event handlers from within your component templates. You can wire up native DOM element events, as well as custom events you create for your components to emit. 

(event)="method()"
Note:  Angular has a pattern for native DOM elements where it is looking for the event name without the "on",
So any native DOM event that is named "onX", you would bind to it by leaving the "on" prefix off. 

- Expressions.
- Conditional templating.
- Template variables.
- Template expression operators.

Getting data to the component with input
----------------------------------------
import { Component, Input } from '@angular/core';

Subscribing to component events with Output
-------------------------------------------
import { Component, Input, Output } from '@angular/core';


Directives and Pipes
--------------------
Angular has two types of diretives (Structural, attribute).

Structural Directive: ngIf
--------------------------

<div *ngIf="mediaItem.watchedOn">Watched on {{ mediaItem.watchedOn }}</div>

OR

<ng-template [ngIf]="mediaItem.watchedOn">
  <div>Watched on {{ mediaItem.watchedOn }}</div>
</ng-template>

Structural directives: ngFor
----------------------------
is used to repeat markup when looping over some data.

Attribute directive: built in
-----------------------------
<section>
  <mw-media-item
    [ngClass]="{'medium-movies': mediaItem.medium==='Movies', 'medium-series':mediaItem.medium==='Series'}" 
    *ngFor="let mediaItem of mediaItems"
    [mediaItem]="mediaItem"
    (delete)="onMediaItemDelete($event)"></mw-media-item>
</section>

Attribute directive: custom
---------------------------
import { Directive, HostBinding, HostListener, Input } from '@angular/core';

@Directive({
  selector: '[mwFavorite]'
})
export class FavoriteDirective {
............................

<svg [mwFavorite]="mediaItem.isFavorite" class="favorite" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"> 
</svg>


note: `declaration` in the app.module.ts, we define components, directives and pipes.


Using directive values
----------------------


Working with events in diretives:
---------------------------------

 
Angular Pipe:
-------------
A template expression operator that takes in a value and return a value representation.

Angular Pipe: built-in
----------------------
{{ var | date: 'shortDate' }}
| upperCase
| 

Angular Pipe: custom
-------------------- 


Forms:
Angular forms:
--------------

Built-in Validators, Custom Validators, Async Validators, From Object Representation.

There are two common approaches to building forms in Angular: 
- template driven, where the majority of the form logic is crafted in the template markup,
- model driven, where the majority of the form logic is crafted in the component class. 

Overall, the form support build into Angular covers a wide range of input collection scenarios.

Template-driven forms:
----------------------
- Ease of use.
- Simple

in the app.module.ts
import { FormsModule } from '@angular/forms';

....

@NgModule({
  imports: [ 
    FormsModule

in the html template
<form
  #mediaItemForm="ngForm"
  (ngSubmit)="onSubmit(mediaItemForm.value)">
  <input type="text" name="name" id="name" ngModel>
  ..
  <select name="category" id="category" ngModel>
  
in the component class

export class MediaItemFormComponent {
  onSubmit(mediaItem) {
    console.log(mediaItem);
  } 
  
Model-driven forms:
-------------------
- Full powered.

The model driven approach is another way to handle building forms in Angular. It has a lot of similarities to the template driven approach. But the big difference is the form is built in the component class. 

in the app.module.ts
import { ReactiveFormsModule } from '@angular/forms';

....
@NgModule({
  imports: [ 
    ReactiveFormsModule

in the component class

import { FormGroup, FormControl } from '@angular/forms';

...
in the component class

export class MediaItemFormComponent {
  form;

  ngOnInit() {
    this.form = new FormGroup({
      medium: new FormControl('Movies'), // default value
      name: new FormControl(''),
      category: new FormControl(''),
      year: new FormControl(''),
    });
  }

  onSubmit(mediaItem) {
    console.log(mediaItem);
  }
}

in the html template

<form
  [formGroup]="form"
  (ngSubmit)="onSubmit(form.value)">

  <input type="text" name="name" id="name" formControlName="name">
  
Validation: built-in
--------------------
in the compoent class:

import { FormGroup, FormControl, Validators } from '@angular/forms';  
  
export class MediaItemFormComponent {
  form;

  ngOnInit() {
    this.form = new FormGroup({
      medium: new FormControl('Movies'),
      name: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern('[\\w\\-\\s\\/]+')
      ])),
      category: new FormControl(''),
      year: new FormControl(''),
    });
  }  
  
in the html template

<button type="submit" [disabled]="!form.valid">Save</button>  

Validation: custom
------------------

Error Handling
--------------


Dependency Injection and 

7. Routing
-----------
app.routing.ts

import { Routes, RouterModule } from '@angular/router';

import { MediaItemFormComponent } from './media-item-form.component';
import { MediaItemListComponent } from './media-item-list.component';

const appRoutes: Routes = [
  { path: 'add', component: MediaItemFormComponent },
  { path: ':medium', component: MediaItemListComponent },
  { path: '', pathMatch: 'full', redirectTo: 'all' }
];

export const routing = RouterModule.forRoot(appRoutes);


and in the app.module.ts

import { routing } from './app.routing';

@NgModule({
  imports: [
    ... ,
	routing
  ],

route-outer, is structural dircetive, 


Router Link
-----------
<a routerLink="/">
    <img src="media/04.png" class="icon" />
  </a>
  
Working with router parameters
------------------------------
  

  
  
  
  
  
  
  































 
 
 
 
 
 
 
 
 
 