package controller;

import model.GameTab;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.Window;
import model.Player;

public class GameManager {
	Window window;
	//Player player;
	//GameTab gameTab;
	
	

	public GameManager() {
		this.run();

	}

	/*public void keyControl( KeyEvent evt, Player player, GameTab gameTab) {

		if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
			gameTab.MovePlayerLeft(player, gameTab);
		}

		if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
			gameTab.MovePlayerRight(player, gameTab);
		}

		if (evt.getKeyCode() == KeyEvent.VK_UP) {
			gameTab.MovePlayerUp(player, gameTab);

		}

		if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
			gameTab.MovePlayerDown(player, gameTab);

		}

	}*/

	public void run() {
		
		window = new Window();
	}


}