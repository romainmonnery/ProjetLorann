package view;

import java.awt.*;
import javax.swing.*;

public class Panel extends JPanel {
	public Window f ;
	public int sizeCase = 32;
	public Panel (Window f) {
		this.f= f;	
		//repaint();
	}
	
	public void paintComponent(Graphics g) {
		int x = 0, y = 0;
		g.setColor(Color.WHITE);
		for(char[] tc : f.m.lvl1.caractere) {
			for(char c : tc) {
				
				Image img = f.m.getImage(c);
				g.drawImage(img, x*sizeCase, 20+y*sizeCase, null);
				//g.drawString(c+"", x*sizeCase, 20+y*sizeCase);
				y++;
			}
			x++;
			y=0;
		}
	}
}
