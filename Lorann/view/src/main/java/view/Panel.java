import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Fenetre f;
	private int sizeCase = 32;
	public Panel(Fenetre f) {
		this.f = f;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		int x = 0, y = 0;
		g.setColor(Color.WHITE);
		for (char[] tc : f.m.lvl1.caractere) {
			for (char c : tc) {

				Image img = f.m.getImage(c);
				g.drawImage(img, x * sizeCase, 20 + y * sizeCase, null);
				// g.drawString(c+"", x*sizeCase, 20+y*sizeCase);
				y++;
			}
			x++;
			y = 0;
		}
		Action perso = new Action(g);

	}
}
