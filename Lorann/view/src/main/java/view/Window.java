import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Fenetre extends JFrame implements KeyListener{
	
	public Model m = new Model();
	private Panel pan;
	private Action perso;
	public Fenetre() {
		 
		
		
	    this.setTitle("Lorann");
	    this.setSize (670, 430);
	    this.setLocationRelativeTo(null);
	    this.setBackground(Color.BLACK);        
	    pan = new Panel(this);
	    this.setContentPane(pan);               
	    this.setVisible(true);
		
		this.addKeyListener(this);
		
		
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent evt) {

		if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
			perso.setZ(perso.getZ()-1);
		}

		if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
			perso.setZ(perso.getZ() + 1);
		}

		if (evt.getKeyCode() == KeyEvent.VK_UP) {
			perso.setW(perso.getW() - 1);
		}

		if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
			perso.setW(perso.getW() + 1);
		}
		pan.repaint();
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	} 	
}
