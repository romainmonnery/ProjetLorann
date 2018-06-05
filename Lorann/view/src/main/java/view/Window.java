package view;

import controller.MoveController;
import model.Elements;
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

	public Window() throws SQLException{

		this.setTitle("Lorann");
		this.setSize(820, 550);
		this.setLocationRelativeTo(null);
		this.setBackground(Color.BLACK);
		pan = new Panel(this);
		this.keyc = new MoveController();
		this.setContentPane(pan);
		this.setVisible(true);
		this.addKeyListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		///// TIMER IA///////
		int delay =150; // milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int a;
				int b;
				a = pan.getGameTab().MoveIaX(pan.getMonster().getPositionX(), pan.getPlayer().getPositionX());
				switch (a) {
				case 1:

					try {
						MoveIA(pan.getMonster(), KeyEvent.VK_UP);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					pan.repaint();
					break;
				case 2:
					try {
						MoveIA(pan.getMonster(), KeyEvent.VK_DOWN);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pan.repaint();
					break;
				}
				b = pan.getGameTab().MoveIaY(pan.getMonster().getPositionY(), pan.getPlayer().getPositionY());
				switch (b) {
				case 3:
					try {
						MoveIA(pan.getMonster(), KeyEvent.VK_LEFT);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pan.repaint();
					break;

				case 4:
					try {
						MoveIA(pan.getMonster(), KeyEvent.VK_RIGHT);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pan.repaint();
					break;

				}

				// default:
				// MoveIA(pan.getMonster(), KeyEvent.VK_DOWN);
				// pan.repaint();
				// break;

			}
		};
		new Timer(delay, taskPerformer).start();

	}

	@SuppressWarnings("unused")
	public void keyPressed(KeyEvent evt) {

		try {
			keyc.keyControl(evt.getKeyCode(), pan.getPlayer(), pan.getGameTab(), pan.getEndGame());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public void MoveIA(Elements element, int keycode) throws SQLException {
		keyc.keyControl(keycode, element, pan.getGameTab(), pan.getEndGame());

	}

}
