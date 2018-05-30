package controller;

import model.GameTab;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.Window;
import model.Player;

public class GameManager {
	Window window;
	Player player;
	GameTab gameTab;
	String path = "C:/Users/marti/Desktop/projet";
	String filePrev = "salle0";
	String fileNumber = "05";
	String extension = ".txt";
	

	public GameManager() {
		this.run();

	}

	public void keyControl(view.Panel pan, KeyEvent evt) {

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

	}

	public void run() {
		gameTab = new GameTab(path + filePrev + fileNumber + extension);
		player = new Player();
		window = new Window();
	}


}