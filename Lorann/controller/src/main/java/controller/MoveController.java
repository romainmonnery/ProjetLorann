package controller;

import java.awt.event.KeyEvent;

import model.GameTab;
import model.Player;

public class MoveController {
public MoveController() {}

public void keyControl( KeyEvent evt, Player player, GameTab gameTab) {

	if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
		gameTab.MovePlayerLeft(player, gameTab);
	}

	if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
		gameTab.MovePlayerRight(player, gameTab);
	}

	if (evt.getKeyCode() == KeyEvent.VK_UP) {
		gameTab.MovePlayerUp(player, gameTab);

	}

	if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
		gameTab.MovePlayerDown(player, gameTab);

	}

}

}
