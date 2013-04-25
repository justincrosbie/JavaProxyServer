package com.jcrosbie.proxyserver.response;


public class PrependTextServerAction implements ServerAction {

	public String perform(String request) {
		return "Client said: " + request;
	}
}
