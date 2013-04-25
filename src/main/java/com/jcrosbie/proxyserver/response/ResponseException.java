package com.jcrosbie.proxyserver.response;

public class ResponseException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6299249593392275510L;

	public ResponseException() {
    }

    public ResponseException(String message) {
       super(message);
    }
}
