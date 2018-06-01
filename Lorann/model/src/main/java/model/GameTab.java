package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.LorannBDDConnector;
import model.dao.MapDAO;

public class GameTab {

	public char[][] tab;
	private final int WIDTH; // nb colonne
	private final int HEIGHT; // nb ligne
	private int row = 12;
	private int column = 20;
	private int totalcarac = 0;
	private char[][] boardArray;

	/////////// Constructor//////////////

	public GameTab() throws SQLException {
		HEIGHT = 20;
		WIDTH = 12;
		tab = new char[WIDTH][HEIGHT];

		// InitializeWithFile(mapPath); String mapPath
		InitializeWithBDD();
	}

///////////////////////////////////
	public void ReplaceTabWitBDDTab(){
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
		String map = MapDAO.getMapById(4);
		this.Board(map);
		this.ReplaceTabWitBDDTab();
	}

//	public void InitializeWithFile(String path) {
//		try {
//
//			BufferedReader reader = new BufferedReader(new FileReader(path));
//
//			int x = 0;
//			int y = 0;
//			String line;
//
//			while ((line = reader.readLine()) != null) {
//				for (char c : line.toCharArray()) {
//					tab[x][y] = c;
//					y++;
//				}
//				x++;
//				y = 0;
//			}
//
//			reader.close();
//
//		} catch (IOException e) {
//
//		}
//	}

	public void MovePlayerUp(MobileElement mobileelement, GameTab updatedGameTab) {

		if (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == ' ') {
			mobileelement.setPositionX(mobileelement.getPositionX() - 1);
			mobileelement.setPositionY(mobileelement.getPositionY());
			System.out.println("Char rencontré espace");
			updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
		}

		else if ((this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'I')
				|| (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == '-')
				|| (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'O')) {
			mobileelement.setPositionX(mobileelement.getPositionX());
			mobileelement.setPositionY(mobileelement.getPositionY());
			System.out.println("Char rencontré mur");
		}

		else if ((this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'D')
				|| (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'A')
				|| (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'C')
				|| (this.GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) == 'W')) {

			System.out.println("\n Game Over");
		}

		else
			System.out.println(
					"Char rencontré inconnu" + '"' + GetChar(mobileelement.getPositionX() - 1, mobileelement.getPositionY()) + '"');

	}

	public void MovePlayerDown(MobileElement mobileelement, GameTab updatedGameTab) {

		if (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == ' ') {
			mobileelement.setPositionX(mobileelement.getPositionX() + 1);
			mobileelement.setPositionY(mobileelement.getPositionY());
			System.out.println("Char rencontré espace");
			updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
		}

		else if ((this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'I')
				|| (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == '-')
				|| (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'O')) {
			mobileelement.setPositionX(mobileelement.getPositionX());
			mobileelement.setPositionY(mobileelement.getPositionY());
			System.out.println("Char rencontré mur");
		}

		else if ((this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'D')
				|| (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'A')
				|| (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'C')
				|| (this.GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) == 'W')) {

			System.out.println("\n Game Over");
		}

		else
			System.out.println(
					"Char rencontré inconnu" + '"' + GetChar(mobileelement.getPositionX() + 1, mobileelement.getPositionY()) + '"');

	}

	public void MovePlayerLeft(MobileElement mobileelement, GameTab updatedGameTab) {

		if (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == ' ') {
			mobileelement.setPositionX(mobileelement.getPositionX());
			mobileelement.setPositionY(mobileelement.getPositionY() - 1);
			System.out.println("Char rencontré espace");
			updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
		}

		else if ((this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'I')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == '-')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'O')) {
			mobileelement.setPositionX(mobileelement.getPositionX());
			mobileelement.setPositionY(mobileelement.getPositionY());
			System.out.println("Char rencontré mur");
		}

		else if ((this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'D')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'A')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'C')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) == 'W')) {

			System.out.println("\n Game Over");
		}

		else
			System.out.println(
					"Char rencontré inconnu" + '"' + GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() - 1) + '"');

	}

	public void MovePlayerRight(MobileElement mobileelement, GameTab updatedGameTab) {

		if (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == ' ') {
			mobileelement.setPositionX(mobileelement.getPositionX());
			mobileelement.setPositionY(mobileelement.getPositionY() + 1);
			System.out.println("Char rencontré espace");
			updatedGameTab.ReplacePlayer(mobileelement, updatedGameTab);
		}

		else if ((this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'I')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == '-')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'O')) {
			mobileelement.setPositionX(mobileelement.getPositionX());
			mobileelement.setPositionY(mobileelement.getPositionY());
			System.out.println("Char rencontré mur");
		}

		else if ((this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'D')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'A')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'C')
				|| (this.GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) == 'W')) {

			System.out.println("\n Game Over");
		}

		else
			System.out.println(
					"Char rencontré inconnu" + '"' + GetChar(mobileelement.getPositionX(), mobileelement.getPositionY() + 1) + '"');

	}
	//////////////////////////////////////////////////////////////

	public void ReplacePlayer(MobileElement mobileelement, GameTab updatedGameTab) {
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
				//System.out.print(boardArray[i][j]);
			}
			//System.out.println("");
		}
	}

	public char[][] getBoardArray() {
		return boardArray;
	}

	public void setBoardArray(char[][] boardArray) {
		this.boardArray = boardArray;
	}

public int rand() {
	Double k = Math.random() * (5-1);
	Integer d = k.intValue();
	return d;
}
}