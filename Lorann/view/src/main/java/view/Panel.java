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
	private ImageImport imageImport;
	private Player player;
	private Window f;
	
	
	public Panel(Window f) {
		this.f =f;
	}

	public void paintComponent(Graphics g, GameTab gameTab, Player player, ImageImport imageImport) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		int x = 0, y = 0;
		g.setColor(Color.WHITE);
		for (char[] tc : gameTab.getTab())  {
			for (char c : tc) {

				Image img = imageImport.getImage(c);
				g.drawImage(img, x * sizeCase, 20 + y * sizeCase, null);
				// g.drawString(c+"", x*sizeCase, 20+y*sizeCase);
				y++;
			}
			x++;
			y = 0;
		}
		try {
			BufferedImage perso = ImageIO.read(new File("C:/Users/marti/Desktop/projet/sprite/lorann_u.png"));
			g.drawImage(perso, player.getPositionX() * sizeCase, player.getPositionY() * sizeCase, null);
			// repaint();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
