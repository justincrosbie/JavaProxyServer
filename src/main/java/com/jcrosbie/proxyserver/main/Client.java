package com.jcrosbie.proxyserver.main;

/**
* Client main runnable Object.
* 
* Handles input arguments, instantiates a SocketClient object, 
* and sends a request message to a remote Server.
* 
* The first argument must be the action that the client wishes to have the server action. Possible choices are:
*   append - Appends a message to the request
*   prepend - Prepends a message to the request
*   addnumbers - adds the contents of the message as a list of integers
*  
* So, to demonstrate, first run the Server as a normal Server, then run as a Proxy with the -proxy argument, 
* Then run the Client program to send requests to the Proxy.

* @author Justin Crosbie
* @version 1.0
*/
 
import java.util.Arrays;
import java.util.List;

import com.jcrosbie.proxyserver.client.SocketClient;
import com.jcrosbie.proxyserver.util.ProxyServerProperties;
 
public class Client {
    public static void main(String[] args) throws Exception {
    	int port = ProxyServerProperties.getProxyPort();
    	
    	String server = ProxyServerProperties.getProxyAddress();
    	String action = args[0];
    	
    	List<String> argList = Arrays.asList(args).subList(1, args.length);
    	
    	// Because Strings are immutable
    	StringBuilder msgB = new StringBuilder("");
    	for ( String arg : argList ) {
    		msgB.append(arg + " ");
    	}
    	
    	String msg = msgB.toString();
    	
    	SocketClient client = new SocketClient();
    	String response = client.sendClientRequest(server, port, action, msg);
    	
    	System.out.println("Client request is: "+ msg);
    	System.out.println("Servers response is: "+ response);
    }
    
}