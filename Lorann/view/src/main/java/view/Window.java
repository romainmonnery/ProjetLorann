package view;
import controller.GameManager;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Window extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel pan;

	public Window() {

		this.setTitle("Lorann");
		this.setSize(670, 430);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.BLACK);
		pan = new Panel(this);
		this.setContentPane(pan);
		this.setVisible(true);

		this.addKeyListener(this);

	}

	@SuppressWarnings("unused")
	@Override
	public void keyPressed(KeyEvent evt) {

		GameManager Keyc = new GameManager();
		Keyc.keyControl(pan, evt);
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
