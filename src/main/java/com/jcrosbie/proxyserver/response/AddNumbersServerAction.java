package com.jcrosbie.proxyserver.response;

import java.util.StringTokenizer;


public class AddNumbersServerAction implements ServerAction {

	public String perform(String request) throws ResponseException {
		
		int num = 0;
		
		StringTokenizer tok = new StringTokenizer(request);
		while ( tok.hasMoreTokens() ) {
			try {
				num += Integer.parseInt(tok.nextToken());
			} catch ( NumberFormatException ne ) {
				throw new ResponseException("Error with Response: " + ne.getLocalizedMessage());
			}
			
		}
		return Integer.toString(num);
	}

}
