package com.jcrosbie.proxyserver.server;

/**
* Abstract Server Thread override that delegates the response to another Server
* 
* @author Justin Crosbie
* @version 1.0
*/


import java.net.Socket;
import java.util.StringTokenizer;

import com.jcrosbie.proxyserver.client.SocketClient;
import com.jcrosbie.proxyserver.request.RequestException;
import com.jcrosbie.proxyserver.util.Messages;
import com.jcrosbie.proxyserver.util.PropertiesException;
import com.jcrosbie.proxyserver.util.ProxyServerProperties;

public class ProxyServerThread extends AbstractServerThread {
	public ProxyServerThread(Socket socket) {
		super("ProxyServerThread", socket);
	}

	@Override
	public String handleRequest(String request) {
		SocketClient client = new SocketClient();

		String response = null;

		try {
			server = ProxyServerProperties.getServerAddress();
			port = ProxyServerProperties.getServerPort();
			
			StringTokenizer tok = new StringTokenizer(request, ":");
			if ( !tok.hasMoreTokens() ) {
				throw new RequestException(Messages.getString("BAD_REQUEST_NO_ACTION") + request); 
			}
			String action = tok.nextToken();
			if ( !tok.hasMoreTokens() ) {
				throw new RequestException(Messages.getString("BAD_REQUEST_NO_MSG") + request); 
			}
			String msg = tok.nextToken();
			response = client.sendClientRequest(server, port, action, msg);
		} catch (RequestException e) {
			response = Messages.getString("SEND_REQUEST_ERROR") + e.getLocalizedMessage(); 
		} catch (PropertiesException e) {
			response = Messages.getString("ERROR_GETTING_PROPERTIES") 
					+ e.getLocalizedMessage();
		}
		
		return response;
	}
}