package com.jcrosbie.proxyserver.response;

/**
* Factory Pattern implementation that serves up ServerAction instances.
* 
* @author Justin Crosbie
* @version 1.0
*/

public class ResponseFactory {
	
	public static ServerAction getInstance(String action) {
		
		if ( action.equals("addnumbers") ) {
			return new AddNumbersServerAction();
		}
		else if ( action.equals("prepend") ) {
			return new PrependTextServerAction();
		}
		else if ( action.equals("append") ) {
			return new AppendTextServerAction();
		}
		else {
			return new MirrorAction();
		}
	}

}
