package model;

import java.sql.SQLException;
import model.dao.MapDAO;
import view.EndGame;

/**
 * <h1>The Class GameTab.</h1>
 *
 * @author Niels Boecks, Martins Pedro, Monnery Romain
 * @version 1.0
 */

public class GameTab {

	// Bidimensional array which contains the game map
	public char[][] tab;
	// attribute corresponding to the width of the tab attribute
	private final int WIDTH; // nb colonne
	// attribute corresponding to the height of the tab attribute
	private final int HEIGHT; // nb ligne
	// attribute corresponding to number of lines of the map string loaded in
	// database
	private int row = 12;
	// attribute corresponding to number of columns of the map string loaded in
	// database
	private int column = 20;
	// attribute corresponding to the position of the char written in the boardArray
	// attribute
	private int totalcarac = 0;
	// Bidimensional array which contains the maps loaded from the database
	private char[][] boardArray;
	// attribute corresponding to the id of the chosen map (between 1 and 5)
	private int MapNumber = 3;

	/////////// Constructor//////////////

	/**
	 * The GameTab constructor.
	 *
	 * Associates the right HEIGHT and WIDTH values for the tab attribute and calls
	 * the InitializeWithBDD() method
	 * 
	 * @param no
	 *            parameters
	 * @throws SQLException
	 */
	public GameTab() throws SQLException {
		HEIGHT = 20;
		WIDTH = 12;
		tab = new char[WIDTH][HEIGHT];
		InitializeWithBDD();
	}

	/**
	 * The ReplaceTabWithBDDTab() method.
	 *
	 * Puts the content of boardArray in tab with the getBoardArray() method
	 * 
	 * @param no
	 *            parameters
	 * 
	 */
	public void ReplaceTabWitBDDTab() {
		this.tab = this.getBoardArray();
	}

	/**
	 * The Showtab() method.
	 *
	 * Shows on the consol the content of tab. This was used to test the right
	 * working of the game
	 * 
	 * @param no
	 *            parameters
	 * 
	 */
	public void Showtab() {

		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				System.out.print(tab[i][j]);
			}
			System.out.println("");
		}

	}

	/**
	 * The InitializeWithBDD() method.
	 *
	 * Loads the content of database with getMapById and calls the method to fill
	 * the attribute boardArray and tab
	 * 
	 * @param no
	 *            parameters
	 * @throws SQLException
	 * 
	 */
	public void InitializeWithBDD() throws SQLException {
		String map = MapDAO.getMapById(MapNumber);
		this.Board(map);
		this.ReplaceTabWitBDDTab();
	}

	/**
	 * The MovePlayerUp() method.
	 *
	 * Big method checking if the player or the monster can move up and taking the
	 * key and pass the door if necessary
	 * 
	 * @param Elements
	 *            mobileelement, GameTab updatedGameTab, EndGame endGame
	 * 
	 * 
	 */
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
				|| (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == '@')) {

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

	/**
	 * The MovePlayerDown() method.
	 *
	 * Big method checking if the player or the monster can move down and taking the
	 * key and pass the door if necessary
	 * 
	 * @param Elements
	 *            mobileelement, GameTab updatedGameTab, EndGame endGame
	 * 
	 * 
	 */
	public void MovePlayerDown(Elements mobileelement, GameTab updatedGameTab, EndGame endGame) {

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
				|| (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == '@')) {

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

	/**
	 * The MovePlayerDown() method.
	 *
	 * Big method checking if the player or the monster can move left and taking the
	 * key and pass the door if necessary
	 * 
	 * @param Elements
	 *            mobileelement, GameTab updatedGameTab, EndGame endGame
	 * 
	 * 
	 */
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

	/**
     * The MovePlayerDown() method.
     *
     *Big method checking if the player or the monster can move right and taking the key and pass the door if necessary
     * @param Elements mobileelement GameTab updatedGameTab, EndGame endGame
     * 
     * 
     */
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

	/**
     * The ReplacePlayer() method.
     *
     *Method which move the char of the player in the tab
     * @param Elements mobileelement, GameTab updatedGameTab
     * 
     * 
     */
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

	/**
     * The ReplaceDoor() method.
     *
     *Method which replace the doors char by a Z in the tab
     * @param Elements mobileelement, GameTab updatedGameTab
     * 
     * 
     */
	public void ReplaceDoor(Elements mobileelement, GameTab updatedGameTab) {

		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (tab[i][j] == 'Y') {
					tab[i][j] = 'Z';
				}

			}

		}

	}

	/**
     * The GetChar() method.
     *
     *
     * @param int positionX, int positionY
     * @return the char at the coordinates indicated in tab
     * 
     */
	public char GetChar(int positionX, int positionY) {
		return tab[positionX][positionY];
	}

	/**
     * The GetTab() method.
     *
     *
     * @param no parameters
     * @return the content of tab
     * 
     */
	public char[][] getTab() {

		return this.tab;

	}

	/**
     * The Board() method.
     *
     *Fill the boardArray attribute with the database field chosen
     * @param no parameters
     * 
     * 
     */
	public void Board(String s) {

		boardArray = new char[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				boardArray[i][j] = s.charAt(totalcarac++);
			}
		}
	}
	
	/**
     * The GetBoardArray() method.
     *
     *
     * @param no parameters
     * @return the content of boardArray
     * 
     */
	public char[][] getBoardArray() {
		return boardArray;
	}

	/**
     * The SetBoardArray() method.
     *
     *Method which sets the right value to the boardArray
     * @param char[][] boardArray
     * 
     * 
     */
	public void setBoardArray(char[][] boardArray) {
		this.boardArray = boardArray;
	}

	/**
     * The MovaIaX() method.
     *
     *Method which returns a int value corresponding to the future behaviour of the monster in X
     * @param int monsterX, int monsterY
     * @return a attribute
     * 
     */
	public int MoveIaX(int monsterX, int playerX) {
		int a = 0;
		if (monsterX > playerX) {
			a = 1;
		}
		if (monsterX < playerX) {
			a = 2;
		}
		return a;

	}

	/**
     * The MovaIaY() method.
     *
     *Method which returns a int value corresponding to the future behaviour of the monster in Y
     * @param int monsterX, int monsterY
     * @return b attribute
     * 
     */
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
	/**
     * The getWIDTH() method.
     *
     *
     * @param no parameters
     * @return WIDTH
     * 
     */
	public int getWIDTH() {
		return WIDTH;
	}
	/**
     * The MovaIaY() method.
     *
     *
     * @param no parameters
     * @return HEIGHT
     * 
     */
	public int getHEIGHT() {
		return HEIGHT;
	}

	
}
