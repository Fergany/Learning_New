Initialization of our project
=============================
- install node & NPM ().
 node -v, npm -v
 
 note: npm is distributed with Node.js, which means that when you download Node.js, you automatically get npm installed on your computer.
 
- npm install -g @angular/cli
- ng new prjName

Angular CLI exploration
=======================
- ng serve // start the server or start the applicaiton 
- ng help
- ng g component component-name
# generate component
# load ur component @ app.module.ts
- ng g module module-name
- ng lint
#it's going to go through your entire project in lint and try to see if there's any errors. 
- ng test 
# going to all ur test in ur application, then u can access the link "http://localhost:9876", a visual report of your test


Elements of an enterprise architecture
======================================
4. Testing and Linting
Ability to test ur app with several assumptions, and check ur code syntax as you type.
5. SSR
Server-side rendering optimization for performance improvement.

Project Organization
====================
Approaches:
------------
By types of Files
/Components
/Modules
/Services

By Features or Functions
/Contact list ==> Components, Template, Service, Module
/Company List ==> Components, Template, Service, Module
/Add new contact ==> Components, Template, Service, Module


Docker Container
================
- get your project running the way it was intended.
- best way to save time and not spend hours and hours trying to install the dependencies and make sure you have the same environment as everybody else. 


