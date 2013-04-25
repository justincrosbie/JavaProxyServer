package com.jcrosbie.proxyserver.request;

public class RequestException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8876069726570048284L;

	public RequestException() {
    }

    public RequestException(String message) {
       super(message);
    }
}
