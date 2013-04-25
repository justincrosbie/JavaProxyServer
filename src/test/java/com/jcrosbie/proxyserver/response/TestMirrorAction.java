package com.jcrosbie.proxyserver.response;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestMirrorAction {

	@Test
	public void testRespond() throws Exception {
		ServerAction serverAction = new MirrorAction();
		assertEquals(serverAction.perform("1 2 3 4 5 6 7 8 9"), "1 2 3 4 5 6 7 8 9");
	}
}
