package controller;

import model.GameTab;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import view.Window;
import model.Player;

public class GameManager {
	Window window;
	//Player player;
	//GameTab gameTab;
	
	

	public GameManager() throws SQLException {
		this.run();

	}


	public void run() throws SQLException {
		
		window = new Window();
	}


}