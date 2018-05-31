package view;
import controller.GameManager;
import controller.MoveController;
import model.GameTab;
import model.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Window extends JFrame implements KeyListener{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel pan;

	public Window() {

		this.setTitle("Lorann");
		this.setSize(670, 530);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.BLACK);
		pan = new Panel(this);
		this.setContentPane(pan);
		this.setVisible(true);
		this.addKeyListener(this);

	}

	@SuppressWarnings("unused")
	public void keyPressed(KeyEvent evt ) {
		MoveController Keyc = new MoveController();
		Keyc.keyControl(evt, pan.getPlayer(), pan.getGameTab());
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


