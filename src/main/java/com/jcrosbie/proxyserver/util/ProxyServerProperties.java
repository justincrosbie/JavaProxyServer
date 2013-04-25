package com.jcrosbie.proxyserver.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProxyServerProperties {
	
	private static Properties properties = null;
	
	public ProxyServerProperties() {
	}

	private static Properties getProperties() throws PropertiesException {
		if ( properties == null ) {
			properties = new Properties();
			
			try {
				properties.load(new FileInputStream("proxyserver.properties"));
			} catch ( IOException e ) {
	            throw new PropertiesException("I/O Exception reading proxyserver.properties: " + e.getLocalizedMessage());
			}
		}
		
		return properties;
	}
	public static String getProxyAddress() throws PropertiesException {
		
		return getProperties().getProperty("proxy.address");
	}
	public static int getProxyPort() throws PropertiesException {
		return Integer.parseInt(getProperties().getProperty("proxy.port"));
	}
	public static String getServerAddress() throws PropertiesException {
		return getProperties().getProperty("server.address");
	}
	public static int getServerPort() throws PropertiesException {
		return Integer.parseInt(getProperties().getProperty("server.port"));
	}
}
