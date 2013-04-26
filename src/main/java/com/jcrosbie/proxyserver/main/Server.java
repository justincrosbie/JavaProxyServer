package com.jcrosbie.proxyserver.main;

/**
* Server main runnable Object.
* 
* Handles input arguments, creates a ServerSocket object on a specific port, 
* and listens for incoming requests. It creates new Threads to handle the requests, 
* thus can handle multiple requests concurrently.
* 
* Server operates in one of two modes:
* 1. As a Proxy Server, which forwards the request on to another Server, and sends back the response it receives
* 2. A a main Server, which performs a ServerAction on the request and sends back the response
* 
* To operate as a Proxy Server, run with the "-proxy" command line argument. Otherwise, it runs as a normal 
* So, to demonstrate, first run the Server as a normal Server, then run as a Proxy with the -proxy argument, 
* Then run the Client program to send requests to the Proxy.
* 
* @author Justin Crosbie
* @version 1.0
*/
 
import java.io.IOException;
import java.net.ServerSocket;

import com.jcrosbie.proxyserver.server.ProxyServerThread;
import com.jcrosbie.proxyserver.server.ServerThread;
import com.jcrosbie.proxyserver.util.Messages;
import com.jcrosbie.proxyserver.util.PropertiesException;
import com.jcrosbie.proxyserver.util.ProxyServerProperties;

public class Server {
	
	private static int port = 5555;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean isProxy = false;
        boolean listening = true;

        if ( args.length > 0 ) {
        	try {
	        	if ( args[0].equals("-proxy") ) { 
	        		port = ProxyServerProperties.getProxyPort();
	        		isProxy = true;
	        	} else {
	        		port = ProxyServerProperties.getServerPort();
	        	}
			} catch (PropertiesException e) {
				System.err.println(Messages.getString("SERVER_PROPERTIES_ERROR") 
						+ e.getLocalizedMessage());
	        }
        }
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.err.println(Messages.getString("COULD_NOT_LISTEN_ERROR") + port); 
            System.exit(-1);
        }
        
        System.out.println((isProxy ? Messages.getString("PROXY_SERVER_TEXT") : Messages.getString("SERVER_TEXT")) + Messages.getString("LISTENING_ON_PORT_MSG") + port);   

        try {
	        while ( listening ) {
	        	if ( isProxy ) {
	        		new ProxyServerThread(serverSocket.accept()).start();
	        	} else {
	        		new ServerThread(serverSocket.accept()).start();
	        	}
	        }
        } finally {
        	serverSocket.close();
        }
    }
}