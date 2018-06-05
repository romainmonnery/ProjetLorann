package view;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.GameManager;

public class EndGame {
	private int DEFAULT_OPTION=0; 
	
	JOptionPane winPopup, losePopup;
	
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
