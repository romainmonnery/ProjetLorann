package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import controller.GameManager;
import model.dao.ImageImport;
import model.GameTab;
import model.Player;

public class Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int sizeCase = 32;
	private Window f;
	private Player player;
	private ImageImport imageImport;
	private GameTab gameTab;
	String path = "C:/Users/marti/Desktop/projet/";
	String filePrev = "salle0";
	String fileNumber = "01";
	String extension = ".txt";

	public Panel(Window f) {
		setPlayer(new Player());
		imageImport = new ImageImport();
		setGameTab(new GameTab(path + filePrev + fileNumber + extension));
		this.f = f;
		//gameTab.Showtab();
	}

	public void paintComponent(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		int x = 0, y = 0;
		//g.setColor(Color.WHITE);
		for (char[] tc : getGameTab().getTab()) {
			for (char c : tc) {

				Image img = imageImport.getImage(c);
				g.drawImage(img, y * sizeCase,  x * sizeCase, null);
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
}
