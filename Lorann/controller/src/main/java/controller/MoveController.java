package controller;

import java.awt.event.KeyEvent;
import java.sql.SQLException;

import model.Elements;
import model.GameTab;
import model.Player;
import view.EndGame;

public class MoveController {
public MoveController() {}

public void keyControl( int keycode, Elements mobileelement, GameTab gameTab, EndGame endGame) throws SQLException {

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
