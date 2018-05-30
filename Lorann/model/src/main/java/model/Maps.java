package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Maps {
	public char[][] caractere;

	public Maps(String path, int width, int height) {

		caractere = new char[width][height];

		try {

			BufferedReader br = new BufferedReader(new FileReader(path));

			String line;

			int x = 0, y = 0;

			while ((line = br.readLine()) != null) {

				for (char c : line.toCharArray()) {

					caractere[y][x] = c;

					y++;

				}

				x++;

				y = 0;
			}

			br.close();
		} catch (IOException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
