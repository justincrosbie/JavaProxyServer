package com.jcrosbie.proxyserver.util;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

public class TestProxyServerProperties {
	
	private static Properties properties = new Properties();
	
	@Before
	public void getProperties() throws Exception {
		properties.load(new FileInputStream("proxyserver.properties"));
	}

	@Test
	public void testGetProxyAddress() throws Exception {
		assertEquals(ProxyServerProperties.getProxyAddress(), properties.get("proxy.address"));
	}

	@Test
	public void testGetProxyPort() throws Exception {
		assertEquals(ProxyServerProperties.getProxyPort(), Integer.parseInt((String)properties.get("proxy.port")));
	}

	@Test
	public void testGetServerAddress() throws Exception {
		assertEquals(ProxyServerProperties.getServerAddress(), properties.get("server.address"));
	}

	@Test
	public void testGetServerPort() throws Exception {
		assertEquals(ProxyServerProperties.getServerPort(), Integer.parseInt((String)properties.get("server.port")));
	}
}
