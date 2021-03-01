PyCharm
sqlitebrowser

# flask app
from flask import Flask, jsonify


app = Flask(__name__) 
app.debug = True

if __name__ == '__main__':
    app.run()

# end of flask app

debug mode, lazily reload whenever it detects that change.

 python app.py runserver this will set up a debug


URL-parameters (Key value pairs ?argument1=val&argument2=val)& jsonify
=========================
@app.route('/parameters')
def parameters():
    # if params in the url 
    name = request.args.get('name')  
    age = int(request.args.get('age'))  
    if age < 18:
        return jsonify(message="Sorry " + name + ", you are not old enough."), 401
    else:
        return jsonify(message="Welcome " + name + ", you are old enough!")
        
        
@app.route('/parameters', methods=["POST"])
def parameters(): 
    # params in the body
    name = str(request.form['name'])  # or request.form['name']
    age = int(request.form['age'])        


URL Variables
==============
@app.route('/url_variables/<string:name>/<int:age>')
def url_variables(name: str, age: int):
    if age < 18:
        return jsonify(message="Sorry {}, you are not old enough.".format(name)), 401
    else:
        return jsonify(message="Welcome {}, you are old enough!".format(name))
        
        
        
Adding an ORM
===============

- SQLLite: file based database system (no server required).
- No software installation is required to use SQLite.

ORM : SQLALCHEMY

Benefits of ORM:
- Working with Python object not SQL.
- Allows you to switch ur DB easily.
- Supports multiple databse platform.

SQLlightbrowser

SQLAlchemy allows us to abstract all of our database logic into Python objects. Instead of having to think on a table, row, and column level, we can consider everything on a class, instance, and attribute level.


The process of converting an object into a textual representation of that object is called serialization. The process of converting the text back into an object is called deserialization


JSON Web Tokens (JWTs)
======================


flask-mail
==========
mailtrap.io


pip freeze 
pip freeze > requirements.txt
to export a requirements file. This is just a text file that lists all the dependencies and third party libraries we've been adding as we developed our application.






 



