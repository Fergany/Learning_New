#### What is security?
- The state of being portected or safe from harm.
- Effective web security should build on awareness of the real and specific threats.


#### General Security Principles
##### Least privilege
- The principle of least privilege means giving a user account only those privileges which are essential to that user's work, and nothing more.
- You should apply the principle of least privilege to your code and limit what is available to other code. 

#### Priniciple of Least privilege
- Control access to systems and resources.
- Grant as little access as possible.


#####  Simple is more secure
- Used cleary functions and variables.
- Write code comments.
- Prefer build-in functions.
- Break up long sections of code.
- **Refactoring** The function of the code doesn't change, but the quality of the code is improved by making its structure simpler and clearer.
- DRY.

##### Never trust users

##### Expect the unexpected
- Security must be proactive, not reactive. prevent crime before happening.

##### Defense in depth
- Single layer of defence.
  - Once they have access, they have access to everything (db, server, plain text password).
- Defense in depth
  - get access to a web app user (least privilege).
  - 
  - cannot read encrypted password  

##### Deny list or allow list


### Filter input / control output

##### Validate inputs
- Presence/ length
- Type
- Format
- Between set of values
- 

#### Sanitize input
- Replace powerful character with harmless equivalents.
- Add escape character before powerful character.
ex: in SQL 

#### Keep code private

#### Keep credential private
- All files with credentials should be excluded from version control right from the start of a project. This prevents your credentials from being shared. If you've already committed credentials to version control, you should exclude the file and then use different credentials.
- Never reuse password.
- Should be hashed and never stored in plain text.

- Credential to access remote server.
- for example using FTP or SSH
- SSH use puplic keys cryptography to create two files public private.

#### Keep error message vague

#### Smart logging 
- Errors 
- Senstive actions.
- Suspicious activity.

What to log?
- Date and time.
- Source (IP, User).
- Action and target.

Log should be saved in DB or in a simple file in a private directory.


## The Most common attacks


#### Strong password
- long, character variety, avoid pattern and dictionary words.
- Never reuse password.
- Use a password manager
- USe Multifactor authentication

Bcrypt
Blowfish


#### URL manipulation and insecure direct object reference (IDOR)
Possible insecure Direct Reference
- DB data.
- Files.
- Directories.
- Scripts
- Functions.

#### SQL injection
When data is injected into the sql query.

Solutions:
- Limit the application's DB privilege.
- Limit permission to create, drop, or truncate tables.
- Don't grant access privilege to DB users.
- Never let the application connect as root users.
- Sanitize the input.
for ex: Render every sigle quote in the data harmless by putting a backslash in front of this.
already most PLs have a sql sanitization library.

Use SQL Prepared Stmt.

USe Allow List to validate data before using it.



