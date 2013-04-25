package com.jcrosbie.proxyserver.response;


public class AppendTextServerAction implements ServerAction {

	public String perform(String request) {
		return request + ", client said.";
	}

}
