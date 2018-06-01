package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.LorannBDDConnector;

public class GameTab {

	public char[][] tab;
	private final int WIDTH; // nb colonne
	private final int HEIGHT; // nb ligne

	/////////// Constructor//////////////

	public GameTab(String mapPath) {
		HEIGHT = 20;
		WIDTH = 12;
		tab = new char[WIDTH][HEIGHT];

		InitializeWithFile(mapPath);
		// InitializeWithBDD();
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

	public void InitializeWithBDD() {
		ResultSet rs = LorannBDDConnector.getInstance().executeQuery("SELECT * FROM map");

		try {
			while (rs.next()) {
				System.out.println(rs.getString("content"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void InitializeWithFile(String path) {
		try {

			BufferedReader reader = new BufferedReader(new FileReader(path));

			int x = 0;
			int y = 0;
			String line;

			while ((line = reader.readLine()) != null) {
				for (char c : line.toCharArray()) {
					tab[x][y] = c;
					y++;
				}
				x++;
				y = 0;
			}

			reader.close();

		} catch (IOException e) {

		}
	}

	public void MovePlayerUp(Player player,GameTab updatedGameTab) {

		if (this.GetChar(player.getPositionX() - 1, player.getPositionY()) == ' ') {
			player.setPositionX(player.getPositionX() - 1);
			player.setPositionY(player.getPositionY());
			System.out.println("Char rencontré espace");
			updatedGameTab.ReplacePlayer(player, updatedGameTab);
		}

		else if ((this.GetChar(player.getPositionX() - 1, player.getPositionY()) == 'I')
				|| (this.GetChar(player.getPositionX() - 1, player.getPositionY()) == '-')
				|| (this.GetChar(player.getPositionX() - 1, player.getPositionY()) == 'O')) {
			player.setPositionX(player.getPositionX());
			player.setPositionY(player.getPositionY());
			System.out.println("Char rencontré mur");
		}

		else if ((this.GetChar(player.getPositionX() - 1, player.getPositionY()) == 'D')
				|| (this.GetChar(player.getPositionX() - 1, player.getPositionY()) == 'A')
				|| (this.GetChar(player.getPositionX() - 1, player.getPositionY()) == 'C')
				|| (this.GetChar(player.getPositionX() - 1, player.getPositionY()) == 'W')) {

			System.out.println("\n Game Over");
		}

		else
			System.out.println(
					"Char rencontré inconnu" + '"' + GetChar(player.getPositionX() - 1, player.getPositionY()) + '"');

	}
	
	public void MovePlayerDown(Player player,GameTab updatedGameTab) {

		if (this.GetChar(player.getPositionX() + 1, player.getPositionY()) == ' ') {
			player.setPositionX(player.getPositionX() + 1);
			player.setPositionY(player.getPositionY());
			System.out.println("Char rencontré espace");
			updatedGameTab.ReplacePlayer(player, updatedGameTab);
		}

		else if ((this.GetChar(player.getPositionX() + 1, player.getPositionY()) == 'I')
				|| (this.GetChar(player.getPositionX() + 1, player.getPositionY()) == '-')
				|| (this.GetChar(player.getPositionX() + 1, player.getPositionY()) == 'O')) {
			player.setPositionX(player.getPositionX());
			player.setPositionY(player.getPositionY());
			System.out.println("Char rencontré mur");
		}

		else if ((this.GetChar(player.getPositionX() + 1, player.getPositionY()) == 'D')
				|| (this.GetChar(player.getPositionX() + 1, player.getPositionY()) == 'A')
				|| (this.GetChar(player.getPositionX() + 1, player.getPositionY()) == 'C')
				|| (this.GetChar(player.getPositionX() + 1, player.getPositionY()) == 'C')) {

			System.out.println("\n Game Over");
		}

		else
			System.out.println(
					"Char rencontré inconnu" + '"' + GetChar(player.getPositionX() + 1, player.getPositionY()) + '"');

	}

	public void MovePlayerLeft(Player player,GameTab updatedGameTab) {

		if (this.GetChar(player.getPositionX(), player.getPositionY()-1) == ' ') {
			player.setPositionX(player.getPositionX());
			player.setPositionY(player.getPositionY()-1);
			System.out.println("Char rencontré espace");
			updatedGameTab.ReplacePlayer(player, updatedGameTab);
		}

		else if ((this.GetChar(player.getPositionX(), player.getPositionY()-1) == 'I')
				|| (this.GetChar(player.getPositionX(), player.getPositionY()-1) == '-')
				|| (this.GetChar(player.getPositionX(), player.getPositionY()-1) == 'O')) {
			player.setPositionX(player.getPositionX());
			player.setPositionY(player.getPositionY());
			System.out.println("Char rencontré mur");
		}

		else if ((this.GetChar(player.getPositionX(), player.getPositionY()-1) == 'D')
				|| (this.GetChar(player.getPositionX(), player.getPositionY()-1) == 'A')
				|| (this.GetChar(player.getPositionX(), player.getPositionY()-1) == 'C')
				|| (this.GetChar(player.getPositionX(), player.getPositionY()-1) == 'C')) {

			System.out.println("\n Game Over");
		}

		else
			System.out.println(
					"Char rencontré inconnu" + '"' + GetChar(player.getPositionX(), player.getPositionY()-1) + '"');

	}

	public void MovePlayerRight(Player player,GameTab updatedGameTab) {

		if (this.GetChar(player.getPositionX(), player.getPositionY()+1) == ' ') {
			player.setPositionX(player.getPositionX());
			player.setPositionY(player.getPositionY()+1);
			System.out.println("Char rencontré espace");
			updatedGameTab.ReplacePlayer(player, updatedGameTab);
		}

		else if ((this.GetChar(player.getPositionX(), player.getPositionY()+1) == 'I')
				|| (this.GetChar(player.getPositionX(), player.getPositionY()+1) == '-')
				|| (this.GetChar(player.getPositionX(), player.getPositionY()+1) == 'O')) {
			player.setPositionX(player.getPositionX());
			player.setPositionY(player.getPositionY());
			System.out.println("Char rencontré mur");
		}

		else if ((this.GetChar(player.getPositionX(), player.getPositionY()+1) == 'D')
				|| (this.GetChar(player.getPositionX(), player.getPositionY()+1) == 'A')
				|| (this.GetChar(player.getPositionX(), player.getPositionY()+1) == 'C')
				|| (this.GetChar(player.getPositionX(), player.getPositionY()+1) == 'C')) {

			System.out.println("\n Game Over");
		}

		else
			System.out.println(
					"Char rencontré inconnu" + '"' + GetChar(player.getPositionX(), player.getPositionY()+1) + '"');

	}
	//////////////////////////////////////////////////////////////

	public void ReplacePlayer(Player player, GameTab updatedGameTab) {
		int newX;
		int newY;

		newX = player.getPositionX();
		newY = player.getPositionY();

		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				if (tab[i][j] == player.getName()) {
					tab[i][j] = ' ';
				} 
					
			}
			
		}

		updatedGameTab.tab[newX][newY] = player.getName();

	}

	public char GetChar(int positionX, int positionY) {
		return tab[positionX][positionY];
	}

	public char[][] getTab() {

		return this.tab;

	}
	/*
	 * public void settab(int x, int y,char p) { if (p != 1 && p !=2) {
	 * System.out.println("Nombre joueur incorrect"); } else if (x > 2 || x < 0) {
	 * System.out.println("Nombre de colonne choisie incorrect"); } else if (y > 2
	 * || y < 0) { System.out.println("Nombre de ligne choisie incorrect"); } else {
	 * tab[x][y] = p; }
	 */
}
