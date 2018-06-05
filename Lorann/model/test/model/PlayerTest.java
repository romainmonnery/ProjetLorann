package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPositionX() {
		Player p = new Player();
		int expectedX = 2;
		assertEquals(expectedX, p.getPositionX());
	}

}
