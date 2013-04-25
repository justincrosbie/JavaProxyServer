package com.jcrosbie.proxyserver.server;

/**
* Abstract Thread object that implements the common features of a Server Thread - Handles requests, and responds.
* 
* @author Justin Crosbie
* @version 1.0
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public abstract class AbstractServerThread extends Thread {

	protected Socket socket = null;
	protected String server = "localhost";
	protected int port = 5555;
	
	public AbstractServerThread(String threadName, Socket socket) {
		super(threadName);
		this.socket = socket;
	}

	public abstract String handleRequest(String request);
	
	public void run() {

		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			String responseString = handleRequest(in.readLine());
			
			out.println(responseString);

			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}