package controller;

import java.awt.event.KeyEvent;
import java.sql.SQLException;

import model.Elements;
import model.GameTab;
import model.Player;
import view.EndGame;

/**
 * <h1>The Class MoveController.</h1>
 *
 * @author Niels Boecks, Martins Pedro, Monnery Romain
 * @version 1.0
 */
public class MoveController {

	/**
     * The KeyControl() method.
     *
     *Method which calls the moving method depending on the key pressed on the keyboard 
     * @param int keycode, Elements mobileelement, GameTab, EndGame endGame
     * @throws SQLException 
     * 
     */
	public void keyControl(int keycode, Elements mobileelement, GameTab gameTab, EndGame endGame) throws SQLException {

		if (keycode == KeyEvent.VK_LEFT) {
			gameTab.MovePlayerLeft(mobileelement, gameTab, endGame);
		}

		if (keycode == KeyEvent.VK_RIGHT) {
			gameTab.MovePlayerRight(mobileelement, gameTab, endGame);
		}

		if (keycode == KeyEvent.VK_UP) {
			gameTab.MovePlayerUp(mobileelement, gameTab, endGame);

		}

		if (keycode == KeyEvent.VK_DOWN) {
			gameTab.MovePlayerDown(mobileelement, gameTab, endGame);

		}

	}

}
