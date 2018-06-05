package view.view;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import view.Window;

class WindowTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testWindow() throws SQLException, IOException {
		Window testAtt = new Window();
		testAtt.setTitle("Lorann");
		testAtt.setSize(820, 550);
		Window testActuel = new Window();
		assertEquals(testAtt.getSize(),testActuel.getSize());
		assertEquals(testAtt.getTitle(),testActuel.getTitle());

	}

	
}
