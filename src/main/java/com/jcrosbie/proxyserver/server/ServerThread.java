package com.jcrosbie.proxyserver.server;

/**
* Abstract Server Thread override that actually handles the request
* 
* @author Justin Crosbie
* @version 1.0
*/

import java.net.Socket;
import java.util.StringTokenizer;

import com.jcrosbie.proxyserver.response.ResponseException;
import com.jcrosbie.proxyserver.response.ResponseFactory;
import com.jcrosbie.proxyserver.response.ServerAction;
import com.jcrosbie.proxyserver.util.Messages;

public class ServerThread extends AbstractServerThread {

	public ServerThread(Socket socket) {
		super("ServerThread", socket);
	}

	@Override
	public String handleRequest(String request) {
		try {
			StringTokenizer tok = new StringTokenizer(request, ":");
			if ( !tok.hasMoreTokens() ) {
				throw new ResponseException(Messages.getString("BAD_REQUEST_NO_ACTION") + request);
			}
			String action = tok.nextToken();
			if ( !tok.hasMoreTokens() ) {
				throw new ResponseException(Messages.getString("BAD_REQUEST_NO_MSG") + request);
			}
			String msg = tok.nextToken();

			ServerAction serverAction = ResponseFactory.getInstance(action);

			return serverAction.perform(msg);
		} catch ( ResponseException e ) {
			return e.getLocalizedMessage();
		}
	}
}