package com.jcrosbie.proxyserver.response;

/**
* Implementation of ServerAction Interface.
* 
* @author Justin Crosbie
* @version 1.0
*/

public class PrependTextServerAction implements ServerAction {

	public String perform(String request) {
		return "Client said: " + request;
	}
}
