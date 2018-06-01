package controller;

import java.awt.event.KeyEvent;

import model.GameTab;
import model.MobileElement;
import model.Player;

public class MoveController {
public MoveController() {}

public void keyControl( int keycode, MobileElement mobileelement, GameTab gameTab) {

	if (keycode == KeyEvent.VK_LEFT) {
		gameTab.MovePlayerLeft(mobileelement, gameTab);
	}

	if (keycode == KeyEvent.VK_RIGHT) {
		gameTab.MovePlayerRight(mobileelement, gameTab);
	}

	if (keycode == KeyEvent.VK_UP) {
		gameTab.MovePlayerUp(mobileelement, gameTab);

	}

	if (keycode == KeyEvent.VK_DOWN) {
		gameTab.MovePlayerDown(mobileelement, gameTab);

	}

}

}
