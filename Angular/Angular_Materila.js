Install the CLI using the npm package manager:

	npm install -g @angular/cli


Add the AppRoutingModule
In Angular, the best practice is to load and configure the router in a separate, top-level module that is dedicated to routing and imported by the root AppModule.

By convention, the module class name is AppRoutingModule and it belongs in the app-routing.module.ts in the src/app folder.


ng generate module app-routing --flat --module=app

	--flat puts the file in src/app instead of its own folder.
	--module=app tells the CLI to register it in the imports array of the AppModule.