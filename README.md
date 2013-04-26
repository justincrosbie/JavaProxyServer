JavaProxyServer
===============

Demonstrates a Java Sockets based Proxy Server, where a client sends a message to a Proxy, that delegates to another Server, that responds to the message in a specific way.

To run, first execute the Server main class to invoke the main Server, then execute the Server again separetely, specifying -proxy as argument. This sets up the Server, and Proxy Server, to listen on specific ports.
Then, run the Client main class, specifying one of the following actions, followed by a message as arguments:
   append
   prepend
   addnumbers
This determines what action the endpoint Server will take on the message.
