package model;

import java.sql.SQLException;
import model.dao.MapDAO;
import view.EndGame;

public class GameTab {

	public char[][] tab;
	private final int WIDTH; // nb colonne
	private final int HEIGHT; // nb ligne
	private int row = 12;
	private int column = 20;
	private int totalcarac = 0;
	private char[][] boardArray;
	private int MapNumber=3;
	/////////// Constructor//////////////

	public GameTab() throws SQLException {
		HEIGHT = 20;
		WIDTH = 12;
		tab = new char[WIDTH][HEIGHT];

		// InitializeWithFile(mapPath); String mapPath
		InitializeWithBDD();
	}

	///////////////////////////////////
	public void ReplaceTabWitBDDTab() {
		this.tab = this.getBoardArray();
	}

	///////////////////////////////////

	public void Showtab() {

		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				System.out.print(tab[i][j]);
			}
			System.out.println("");
		}

	}

	///////////////////////////////////

	public void InitializeWithBDD() throws SQLException {
		String map = MapDAO.getMapById(MapNumber);
		this.Board(map);
		this.ReplaceTabWitBDDTab();
	}

	// public void InitializeWithFile(String path) {
	// try {
	//
	// BufferedReader reader = new BufferedReader(new FileReader(path));
	//
	// int x = 0;
	// int y = 0;
	// String line;
	//
	// while ((line = reader.readLine()) != null) {
	// for (char c : line.toCharArray()) {
	// tab[x][y] = c;
	// y++;
	// }
	// x++;
	// y = 0;
	// }
	//
	// reader.close();
	//
	// } catch (IOException e) {
	//
	// }
	// }

	public void MovePlayerUp(Elements mobileelement, GameTab updatedGameTab, EndGame endGame) {

		if (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == ' ') {
			mobileelement.setPositionX(mobileelement.getPositionX() - 1);
			mobileelement.setPositionY(mobileelement.getPositionY());
			updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
		}

		else if ((this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'I')
				|| (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == '-')
				|| (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'O')) {
			mobileelement.setPositionX(mobileelement.getPositionX());
			mobileelement.setPositionY(mobileelement.getPositionY());
			
		}

		else if ((this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'D')
				|| (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'A')
				|| (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'C')
				|| (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'W')
				|| (this.GetChar(mobileelement.getPositionX() -1, mobileelement.getPositionY()) == '@')) {

			endGame.loseGame();
		}

		else if ((this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'Q')) {
			if (mobileelement.isPassable() == true) {
				mobileelement.setPositionX(mobileelement.getPositionX() - 1);
				mobileelement.setPositionY(mobileelement.getPositionY());
				System.out.println("Char rencontré espace");
				updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
				updatedGameTab.ReplaceDoor(mobileelement, updatedGameTab);
			} else {
				mobileelement.setPositionX(mobileelement.getPositionX());
				mobileelement.setPositionY(mobileelement.getPositionY());
			}

		}

		else if ((this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'Z')) {
			if (mobileelement.isPassable() == true) {
				mobileelement.setPositionX(mobileelement.getPositionX() - 1);
				mobileelement.setPositionY(mobileelement.getPositionY());
				System.out.println("Char rencontré espace");
				updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
				endGame.winGame();

			} else {
				mobileelement.setPositionX(mobileelement.getPositionX());
				mobileelement.setPositionY(mobileelement.getPositionY());
			}
		}

		else
			GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY());

	}

	public void MovePlayerDown(Elements mobileelement, GameTab updatedGameTab, EndGame endGame){

		if (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == ' ') {
			mobileelement.setPositionX(mobileelement.getPositionX() + 1);
			mobileelement.setPositionY(mobileelement.getPositionY());
			updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
		}

		else if ((this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'I')
				|| (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == '-')
				|| (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'O')) {
			mobileelement.setPositionX(mobileelement.getPositionX());
			mobileelement.setPositionY(mobileelement.getPositionY());
		}

		else if ((this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'D')
				|| (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'A')
				|| (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'C')
				|| (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'W')
				|| (this.GetChar(mobileelement.getPositionX() +1, mobileelement.getPositionY()) == '@')) {

			endGame.loseGame();
		}

		else if ((this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'Q')) {
			if (mobileelement.isPassable() == true) {
				mobileelement.setPositionX(mobileelement.getPositionX() + 1);
				mobileelement.setPositionY(mobileelement.getPositionY());
				updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
				updatedGameTab.ReplaceDoor(mobileelement, updatedGameTab);
			} else {
				mobileelement.setPositionX(mobileelement.getPositionX());
				mobileelement.setPositionY(mobileelement.getPositionY());
			}

		}

		else if ((this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'Z')) {
			if (mobileelement.isPassable() == true) {
				mobileelement.setPositionX(mobileelement.getPositionX() + 1);
				mobileelement.setPositionY(mobileelement.getPositionY());
				updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
				endGame.winGame();

			} else {
				mobileelement.setPositionX(mobileelement.getPositionX());
				mobileelement.setPositionY(mobileelement.getPositionY());
			}
		}

		else
			GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY());

	}

	public void MovePlayerLeft(Elements mobileelement, GameTab updatedGameTab, EndGame endGame) {

		if (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == ' ') {
			mobileelement.setPositionX(mobileelement.getPositionX());
			mobileelement.setPositionY(mobileelement.getPositionY() - 1);
			updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
		}

		else if ((this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'I')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == '-')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'O')) {
			mobileelement.setPositionX(mobileelement.getPositionX());
			mobileelement.setPositionY(mobileelement.getPositionY());
		}

		else if ((this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'D')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'A')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'C')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'W')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == '@')) {

			endGame.loseGame();
		}

		else if ((this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'Q')) {
			if (mobileelement.isPassable() == true) {
				mobileelement.setPositionX(mobileelement.getPositionX());
				mobileelement.setPositionY(mobileelement.getPositionY() - 1);
				updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
				updatedGameTab.ReplaceDoor(mobileelement, updatedGameTab);
			} else {
				mobileelement.setPositionX(mobileelement.getPositionX());
				mobileelement.setPositionY(mobileelement.getPositionY());
			}

		}

		else if ((this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'Z')) {
			if (mobileelement.isPassable() == true) {
				mobileelement.setPositionX(mobileelement.getPositionX());
				mobileelement.setPositionY(mobileelement.getPositionY() - 1);
				updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
				endGame.winGame();

			} else {
				mobileelement.setPositionX(mobileelement.getPositionX());
				mobileelement.setPositionY(mobileelement.getPositionY());
			}
		}

		else
			GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1);

	}

public void MovePlayerRight(Elements mobileelement, GameTab updatedGameTab, EndGame endGame) {
		if (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == ' ') {
			mobileelement.setPositionX(mobileelement.getPositionX());
			mobileelement.setPositionY(mobileelement.getPositionY() + 1);
			updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
		}

		else if ((this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'I')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == '-')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'O')) {
			mobileelement.setPositionX(mobileelement.getPositionX());
			mobileelement.setPositionY(mobileelement.getPositionY());
		}

		else if ((this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'D')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'A')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'C')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'W')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == '@')) {

			endGame.loseGame();
		}

		else if ((this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'Q')) {
			if (mobileelement.isPassable() == true) {
				mobileelement.setPositionX(mobileelement.getPositionX());
				mobileelement.setPositionY(mobileelement.getPositionY() + 1);
				updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
				updatedGameTab.ReplaceDoor(mobileelement, updatedGameTab);
			} else {
				mobileelement.setPositionX(mobileelement.getPositionX());
				mobileelement.setPositionY(mobileelement.getPositionY());
			}

		}

		else if ((this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'Z')) {
			if (mobileelement.isPassable() == true) {
				mobileelement.setPositionX(mobileelement.getPositionX());
				mobileelement.setPositionY(mobileelement.getPositionY() + 1);
				updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
				endGame.winGame();

			} else {
				mobileelement.setPositionX(mobileelement.getPositionX());
				mobileelement.setPositionY(mobileelement.getPositionY());
			}
		}

		else
			GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1);
		

	}
	//////////////////////////////////////////////////////////////

	public void ReplacePlayer(Elements mobileelement, GameTab updatedGameTab) {
		int newX;
		int newY;

		newX = mobileelement.getPositionX();
		newY = mobileelement.getPositionY();

		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (tab[i][j] == mobileelement.getName()) {
					tab[i][j] = ' ';
				}

			}

		}

		updatedGameTab.tab[newX][newY] = mobileelement.getName();

	}

	public void ReplaceDoor(Elements mobileelement, GameTab updatedGameTab) {

		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (tab[i][j] == 'Y') {
					tab[i][j] = 'Z';
				}

			}

		}

	}

	public char GetChar(int positionX, int positionY) {
		return tab[positionX][positionY];
	}

	public char[][] getTab() {

		return this.tab;

	}

	public void Board(String s) {

		boardArray = new char[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				boardArray[i][j] = s.charAt(totalcarac++);
				// System.out.print(boardArray[i][j]);
			}
			// System.out.println("");
		}
	}

	public char[][] getBoardArray() {
		return boardArray;
	}

	public void setBoardArray(char[][] boardArray) {
		this.boardArray = boardArray;
	}

	public int MoveIaX(int monsterX, int playerX) {
		int a = 0;
		if (monsterX > playerX) {
			a = 1;
		}
		if (monsterX < playerX) {
			a = 2;
		}
		return a;
		// Double k = Math.random() * (5-1);
		// Integer d = k.intValue();
		// return d;

	}

	public int MoveIaY(int monsterY, int playerY) {
		int b = 0;
		if (monsterY > playerY) {
			b = 3;
		}
		if (monsterY < playerY) {
			b = 4;
		}
		return b;
	}

}
