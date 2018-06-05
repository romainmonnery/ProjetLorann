package model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameTabTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGameTab() throws SQLException {
		GameTab testReel = new GameTab();
		int expectedWidth = 12;
		int expectedHeight = 20;
		assertEquals(expectedWidth,testReel.getWIDTH());
		assertEquals(expectedHeight,testReel.getHEIGHT());
		
	}

}
