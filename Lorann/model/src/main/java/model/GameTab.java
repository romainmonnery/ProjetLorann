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
			System.out.println(); // quand on passe au "i" suivant (dans la boucle for) on retourne à la ligne
		}

	}

	///////////////////////////////////

	public void InitializeWithBDD()
	{
		ResultSet rs = LorannBDDConnector.getInstance().executeQuery("SELECT * FROM map");
		
		try {
			while(rs.next())
			{
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
			
			while ((line = reader.readLine()) != null) 
			{		
				for (char c : line.toCharArray()) 
				{
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

	public char getChar(int positionX, int positionY) {
		return tab[positionX][positionY];
	}

	/*
	 * public void settab(int x, int y,char p) { if (p != 1 && p !=2) {
	 * System.out.println("Nombre joueur incorrect"); } else if (x > 2 || x < 0) {
	 * System.out.println("Nombre de colonne choisie incorrect"); } else if (y > 2
	 * || y < 0) { System.out.println("Nombre de ligne choisie incorrect"); } else {
	 * tab[x][y] = p; }
	 */
}
