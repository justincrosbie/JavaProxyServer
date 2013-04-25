package com.jcrosbie.proxyserver.response;

/**
* Implementation of ServerAction Interface.
* 
* @author Justin Crosbie
* @version 1.0
*/

public class AppendTextServerAction implements ServerAction {

	public String perform(String request) {
		return request + ", client said.";
	}

}
