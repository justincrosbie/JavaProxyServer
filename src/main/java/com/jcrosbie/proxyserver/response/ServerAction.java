package com.jcrosbie.proxyserver.response;

/**
* ServerAction Interface.
* 
* <P>Defines the behavioral contract that a Server will perform on a message
*  
* @author Justin Crosbie
* @version 1.0
*/
public interface ServerAction {

	public String perform(String message) throws ResponseException;
}
