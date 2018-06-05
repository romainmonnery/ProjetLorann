package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import controller.GameManager;
import model.dao.ImageImport;
import model.GameTab;
import model.Monster;
import model.Player;

public class Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int sizeCase = 40;
	@SuppressWarnings("unused")
	private Window f;
	private Monster monster;
	private Player player;
	private ImageImport imageImport;
	private GameTab gameTab;
	private EndGame endGame;
	String path = "C:/Users/marti/Desktop/projet/";
	String filePrev = "salle0";
	String fileNumber = "05";
	String extension = ".txt";

	public Panel(Window f) throws SQLException {
		setPlayer(new Player());
		imageImport = new ImageImport();
		setGameTab(new GameTab());
		this.endGame = new EndGame();
		this.f = f;
		monster = new Monster();
		// gameTab.Showtab();
	}

	public void paintComponent(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		int x = 0, y = 0;
		// g.setColor(Color.WHITE);
		for (char[] tc : getGameTab().getTab()) {
			for (char c : tc) {

				Image img = imageImport.getImage(c);
				g.drawImage(img, y * sizeCase, x * sizeCase, null);
				// g.drawString(c+"", x*sizeCase, 20+y*sizeCase);
				y++;
			}
			x++;
			y = 0;
		}
		try {
			BufferedImage perso = ImageIO.read(new File("C:/Users/marti/Desktop/projet/sprite/lorann_u.png"));
			g.drawImage(perso, getPlayer().getPositionY() * sizeCase, getPlayer().getPositionX() * sizeCase, null);
			// repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedImage monster = ImageIO.read(new File("C:/Users/marti/Desktop/projet/sprite/monster_1.png"));
			g.drawImage(monster, getMonster().getPositionY() * sizeCase, getMonster().getPositionX() * sizeCase, null);
			// repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public GameTab getGameTab() {
		return gameTab;
	}

	public void setGameTab(GameTab gameTab) {
		this.gameTab = gameTab;
	}

	public Monster getMonster() {
		return this.monster;
	}
	
	public EndGame getEndGame() {
		return this.endGame;
	}
}
