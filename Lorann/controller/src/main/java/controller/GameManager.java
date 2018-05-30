package controller;
import model.GameTab;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import view.Window;
import model.Player;

public class GameManager {
	Window f;
	Player player1;
	String path = "C:/Users/Niels/Downloads/Salles/";
	String filePrev = "salle0";
	String fileNumber = "05";
	String extension = ".txt";
	GameTab mapdejeu;

	public GameManager() {
		f=new Window();
		player1 = new Player();
		mapdejeu = new GameTab(path + filePrev + fileNumber + extension);

	}

	public void keyControl(view.Panel pan, KeyEvent evt) {

		if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
			// Keym.left(pan); methode move uu ou chez pas quoi

		}

		if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {

			// Keym.rigth(pan);
		}

		if (evt.getKeyCode() == KeyEvent.VK_UP) {

			// Keym.up(pan);
		}

		if (evt.getKeyCode() == KeyEvent.VK_DOWN) {

			// Keym.down(pan);
		}

	}



	public int drawPlayer() {
		return 0;
		// getters de Players

	}



public char[][] getTab() {
	
	return mapdejeu.tab;
	
	
	
	
	
}}