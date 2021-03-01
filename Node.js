Node.js Essential Training
==========================
How Node.js works?

- Node JS is single threaded, but ,multi task.

The global object
-----------------
node file.js

global.console.log("7mada");

The console object is actually a part of a global object.
global which contains the functionality that is available to us within a Node.js file, without having to include or require any other modules.
 
The require function
--------------------
console.log(__dirname);
console.log(__filename);

const path = require("path");
// require to import other modules

console.log(`The file name is ${path.basename(__filename)}`);
// pluk the file name from the file path

Argument variables with process.argv
-------------------------------------
process object
console.log(process.pid);
console.log(process.versions.node);
console.log(process.argv);

Standard output
---------------
process.stdout.write("hello !!!");
process.stdout.write(" world");

const arr = ["What's ur name?", "What would u?", "vfr?"];

const ask = (i = 0) => {
    process.stdout.write(`what we have here :  ${arr[i]}`);
    process.stdout.write(` > `);
};
ask();

Standard inpput
---------------


Creating a delay with setTimeout
--------------------------------
const waitTime = 3000;
console.log(`Settig the waiting time to ${waitTime / 1000}`);

const timerFinished = () => {
    console.log("done");
};

setTimeout(timerFinished, waitTime);
setInterval();


Report progress with setInterval
--------------------------------

Node Modules
============
path,util

node modules that you don't have to load by NPM, installed locally with ur installation of Node.js, refer to them as a 'core' modules.

const path = require("path"); 

const util = require("util");
util.log(" ^ The name of the current file");
// or
const { log }  = require("util");
util.log(" ^ The name of the current file");

const v8 = require("v8");
// same here for { getHeapStatistics }

const dirUploads = path.join(__dirname, 'www', 'files', 'uploads');

console.log(dirUploads);

util.log(path.basename(__filename));



util.log(v8.getHeapStatistics());

Collect information with readline
---------------------------------
const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question("How do you like Node? ", answer => {
  console.log(`Your answer: ${answer}`);
});

Export custom modules
--------------------
// create file myModules.js

module.exports = {
	method1,
	method2,
	method3
};

// in the other file

const counter = require("./myModule");

// or import methods
const { method1, method2} = require("./myModule");

Custom evnets with the EventEmitter
-----------------------------------
const events = require("events");

const emitter = new events.EventEmitter();

emitter.on("customEvent", (message, user) => {
  console.log(`${user}: ${message}`);
});

process.stdin.on("data", data => {
  const input = data.toString().trim();
  if (input === "exit") {
    emitter.emit("customEvent", "Goodbye!", "process");
    process.exit();
  }
  emitter.emit("customEvent", input, "terminal");
});




Node.js Essential Training: Web Servers, Tests, and Deployment
==============================================================

const https = require("https");
const fs = require("fs");

const options = {
    hostname: "en.wikipedia.org",
    port: 443,
    path: "/wiki/Snoopy",
    method: "GET"
};

const request = https.request(options, res => {
    let responseBody = "";
    res.setEncoding("UTF-8");
    res.on("data", data => {
        console.log("---chunk---", data.length);
        responseBody += data;
    });

    res.on("end" , ()=> {
        fs.writeFile("./snoopy.html", responseBody, err =>{
            if(err){
                throw err;    
            }
            console.log("file downloaded");
        });
    });
});

request.end();

Make a request with the GET method
-----------------------------------
const https = require("https");
const fs = require("fs");

const request = https.get("https://en.wikipedia.org/wiki/John_Wick", res => {
    let download = fs.createWriteStream("./John_Wick.html");
    res.pipe(download);

    res.on("end", () => {
        console.log("Response Finished ...");
        
    });
});

request.end();

Build a web server
------------------

const http = require("http");

http.createServer((req, res) => {

    res.writeHead(200, {"Content-Type": "text/plain"});

    res.end(`${req.method} ${req.url}`);
    //res.end("text or any html code between ``");

}).listen(3000);

console.log("Web Server Listening on port 3000");

Create a file server
---------------------
const { createServer } = require("http");
const { createReadStream } = require("fs");

const sendFile = (res, status, type, filePath) => {
  res.writeHead(status, { "Content-Type": type });
  createReadStream(filePath).pipe(res);
};

createServer((req, res) => {
  switch (req.url) {
    case "/":
      return sendFile(res, 200, "text/html", "./home-page.html");
    case "/img/alex-banks.jpeg":
      return sendFile(res, 200, "image/jpeg", "./alex-banks.jpeg");
    case "/styles.css":
      return sendFile(res, 200, "text/css", "./styles.css");
    default:
      return sendFile(res, 200, "text/html", "./404.html");
  }
}).listen(3000);

console.log("Alex's personal website runnning on port 3000");

Collect POST data
-----------------
const { createServer } = require("http");
const { createReadStream } = require("fs");
const { decode } = require("querystring");

const sendFile = (res, status, type, filePath) => {
  res.writeHead(status, { "Content-Type": type });
  createReadStream(filePath).pipe(res);
};

createServer((req, res) => {
  if (req.method === "POST") {
    let body = "";
    req.on("data", data => {
      body += data;
    });
    req.on("end", () => {
      const { name, email, message } = decode(body);
      console.log(`${name} (${email}): ${message}`);
    });
  }

  switch (req.url) {
    case "/":
      return sendFile(res, 200, "text/html", "./home-page.html");
    case "/contact":
      return sendFile(res, 200, "text/html", "./contact.html");
    case "/img/alex-banks.jpeg":
      return sendFile(res, 200, "image/jpeg", "./alex-banks.jpeg");
    case "/styles.css":
      return sendFile(res, 200, "text/css", "./styles.css");
    default:
      return sendFile(res, 200, "text/html", "./404.html");
  }
}).listen(3000);

console.log("Alex's personal website runnning on port 3000");

The package.json file
----------------------
npm init
// to create package.json file, then it will ask you some questions.

npm install pkg_name
// will create package-lock.json file
// the installed pkg will be located under /node_modules

Using a single-line-log
-----------------------

const { time } = parseArgs(process.argv);

// this mean that we take args from command line

node file --time 10

Using tiny-timer
----------------

Global pkgs
-----------






























