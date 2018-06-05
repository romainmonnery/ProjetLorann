package view;

import controller.MoveController;
import model.Elements;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.*;

/**
 * <h1>The Class Window.</h1>
 *
 * @author Niels Boecks, Martins Pedro, Monnery Romain
 * @version 1.0
 */

public class Window extends JFrame implements KeyListener {

	
	private static final long serialVersionUID = 1L;
	//attribute corresponding to a Panel object
	private Panel pan;
	//attribute corresponding to a MoveController object
	MoveController keyc;

	/**
     * The Window constructor
     *
     *Builds the game window and contains a action listener to move the monster every 150 milliseconds
     * @param no parameters
     * @throws SQLException 
	 * @throws IOException 
     * 
     */
	public Window() throws SQLException, IOException{

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
		
		int delay =400; 
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
						
						e.printStackTrace();
					}

					pan.repaint();
					break;
				case 2:
					try {
						MoveIA(pan.getMonster(), KeyEvent.VK_DOWN);
					} catch (SQLException e) {
						
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
						
						e.printStackTrace();
					}
					pan.repaint();
					break;

				case 4:
					try {
						MoveIA(pan.getMonster(), KeyEvent.VK_RIGHT);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
					pan.repaint();
					break;

				}

				
			}
		};
		new Timer(delay, taskPerformer).start();

	}

	/**
     * The KeyPresses method
     *
     *Method which moves the player in the tab and in the window
     * @param KeyEvent evt
     *
     */
	@SuppressWarnings("unused")
	public void keyPressed(KeyEvent evt) {

		try {
			keyc.keyControl(evt.getKeyCode(), pan.getPlayer(), pan.getGameTab(), pan.getEndGame());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		pan.repaint();
	}

	//unused method
	@Override
	public void keyReleased(KeyEvent e) {
		

	}

	//unused method
	@Override
	public void keyTyped(KeyEvent e) {
		

	}

	/**
     * The MoveIA() method
     *
     *Method which moves the Monster 
     * @param Elements element, int keycode
     * @throws SQLException 
     * 
     */
	public void MoveIA(Elements element, int keycode) throws SQLException {
		keyc.keyControl(keycode, element, pan.getGameTab(), pan.getEndGame());

	}

}

