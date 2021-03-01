What Is Cryptography?
- Literally translate as the study of secrets.
- Complex mathematics algorithms that are used to secure data.
- The two most common algorithm classes used are encryption and hashing. 


- Plain text: the original text.
- Cipher text: the encrypted text.
- Key: value that sets the O/T of an encryption function.
- Salt: value to enhance the randomness of a one-way function. 
-  Salt: is a random piece of data that, when added to a hashing function, provides even more entropy in the output, making certain attacks less likely. A good cryptographic hash should always use a salt.

What is Encryption?
- Process by which plain text becomes hidden.
- Ciphered data becomes difficult, hopefully impossible, to read without the key.

Symmetric vs. asymmetric encryption.

- Symmetric encryption: shared key.
That common key is used, and must be kept secret by both parties. So in a traditional Alice and Bob example of cryptography, Alice will encrypt a message using the shared key and send it to Bob who can then decrypt it using the same shared key.
Obviously, the issue with symmetric encryption is that both parties must have a secured mechanism by which to share that key, and often on the public internet that is not possible. 

- Asymmetric encryption: public/private key pair.
I can use one to encrypt and other to desrypt.
in this example Alice will create a public key and a private key and she will then share her public key openly to everyone. She can therefore encrypt a message with her private key and send it to Bob. Bob can then decrypt the message using Alice's public key and read it in plain text. Now, the interesting side effect of this is, that if Bob wants to send a private message to Alice he actually can encrypt the data using Alice's public key and she can then decrypt it using her private key. So, asymmetric encryption works both ways. 