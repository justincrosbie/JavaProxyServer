package com.jcrosbie.proxyserver.response;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAddNumbersServerAction {

	@Test
	public void testRespond() throws Exception {
		ServerAction serverAction = new AddNumbersServerAction();
		assertEquals(serverAction.perform("1 2 3 4 5 6 7 8 9"), "45");
	}
}
