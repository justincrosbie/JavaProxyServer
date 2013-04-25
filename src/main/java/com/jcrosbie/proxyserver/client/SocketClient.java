package com.jcrosbie.proxyserver.client;

/**
* SocketClient Creates a new Socket object and sends a message to server, returning the response.
* 
* @author Justin Crosbie
* @version 1.0
*/
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.jcrosbie.proxyserver.request.RequestException;
import com.jcrosbie.proxyserver.util.Messages;

public class SocketClient {

    public String sendClientRequest(String server, Integer port, String action, String msg) throws RequestException {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String response = null;
        
        try {
            socket = new Socket(server, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException e) {
            throw new RequestException(Messages.getString("UNKNOWN_SERVER") + server); 
        } catch (IOException e) {
            throw new RequestException(Messages.getString("IO_EXCEPTION_ON_CONNECTION") + server); 
        }
 
        out.println(action + ":" + msg); 
 
        try {
        	response = in.readLine();
        } catch ( IOException e ) {
            throw new RequestException(Messages.getString("IO_EXCEPTION_SERVER_RESPONSE") + e.getLocalizedMessage()); 
        }

        out.close();
        try {
        	socket.close();
        } catch ( IOException e ) {
            throw new RequestException(Messages.getString("IO_EXCEPTION_CLOSING") + e.getLocalizedMessage()); 
        }
        
        return response;
    }
}
