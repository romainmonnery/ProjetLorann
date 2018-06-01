package view;

import controller.GameManager;
import controller.MoveController;
import model.GameTab;
import model.MobileElement;
import model.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.*;

public class Window extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel pan;
	MoveController keyc;

	public Window() throws SQLException {

		this.setTitle("Lorann");
		this.setSize(820, 550);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.BLACK);
		pan = new Panel(this);
		this.keyc = new MoveController();
		this.setContentPane(pan);
		this.setVisible(true);
		this.addKeyListener(this);

		///// TIMER IA///////
		int delay = 200; // milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int a;
				a = pan.getGameTab().rand();
				switch (a) {

				case 0:
					MoveIA(pan.getMonster(), KeyEvent.VK_RIGHT);
					pan.repaint();
					break;

				case 1:
					MoveIA(pan.getMonster(), KeyEvent.VK_LEFT);
					pan.repaint();
					break;
				case 2:
					MoveIA(pan.getMonster(), KeyEvent.VK_UP);
					pan.repaint();
					break;

				case 3:
					MoveIA(pan.getMonster(), KeyEvent.VK_DOWN);
					pan.repaint();
					break;

				default:
					MoveIA(pan.getMonster(), KeyEvent.VK_DOWN);
					pan.repaint();
					break;
				}

			}
		};
		new Timer(delay, taskPerformer).start();

	}

	@SuppressWarnings("unused")
	public void keyPressed(KeyEvent evt) {

		keyc.keyControl(evt.getKeyCode(), pan.getPlayer(), pan.getGameTab());
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

	public void MoveIA(MobileElement element, int keycode) {
		keyc.keyControl(keycode, element, pan.getGameTab());

	}

}
