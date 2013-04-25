package com.jcrosbie.proxyserver.response;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPrependTextServerAction {

	@Test
	public void testRespond() throws Exception {
		ServerAction serverAction = new PrependTextServerAction();
		assertEquals(serverAction.perform("1 2 3 4 5 6 7 8 9"), "Client said: 1 2 3 4 5 6 7 8 9");
	}
}
