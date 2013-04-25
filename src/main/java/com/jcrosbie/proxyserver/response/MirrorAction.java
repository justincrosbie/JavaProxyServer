package com.jcrosbie.proxyserver.response;


public class MirrorAction implements ServerAction {

	public String perform(String request) {
		return request;
	}
}
