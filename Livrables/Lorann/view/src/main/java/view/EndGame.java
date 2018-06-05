package view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * <h1>The Class EndGame.</h1>
 *
 * @author Niels Boecks, Martins Pedro, Monnery Romain
 * @version 1.0
 */

public class EndGame {

	//attributes winPopup and losePopup corresponding to the JOptionPane objects used in this class
	JOptionPane winPopup, losePopup;
	
	/**
     * The winGame() method.
     *
     *Method which creates a popup that inform the user that he win the game
     * @param no parameters
     */
	public void winGame() {
		winPopup = new JOptionPane();
		int result = JOptionPane.showConfirmDialog(losePopup,
		        "Close the game ?",
		        "You win !", JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION) System.exit(0);
		if (result != JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	/**
     * The loseGame() method.
     *
     *Method which creates a popup that inform the user that he lost the game
     * @param no parameters
     */
	public void loseGame(){
		losePopup = new JOptionPane();
		int result = JOptionPane.showConfirmDialog(losePopup,
		        "Close the game ?",
		        "You lose !", JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION) System.exit(0);
		if (result != JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}
}
