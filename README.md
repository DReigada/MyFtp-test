# About
A file transfer java app based on sockets. (for testing purposes, it's not safe at all)
This small project also helped me learning how to use maven.

# Compiling/running
Requires maven (and java) to compile

1- Use make to compile/copy the runnable jars into the main directory

###### Running the client:
 java -jar client.jar <host> <hostport> <mode> <filepath>

###### Running the server:
  java -jar server.jar <port> <mode> <filename>

###### Modes:  
        0 - receive
        1 - send
