package view.view;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Player;
import view.Panel;

class PanelTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetPlayer() throws SQLException {
		Player resultatAttendu =new Player();
		Player playerTest = new Player();
		resultatAttendu.setPositionX(2);
		resultatAttendu.setPositionY(17);	
			assertEquals(playerTest.getPositionX(),resultatAttendu.getPositionX());
			assertEquals(playerTest.getPositionY(),resultatAttendu.getPositionY());

	}}

	
