package model;


public class GameTab {
	
	
 public char[][] tab;
 private final int WIDTH;   //nb colonne
 private final int HEIGHT;   //nb ligne
 private Player player;
 
///////////Constructor////////////// 
 
public GameTab()
{
Player player = new Player();	
WIDTH = 4;
HEIGHT = 4;
tab = new char[WIDTH][HEIGHT]; 
}

///////////////////////////////////

public void Showtab() 
{
	
for (int i = 0 ; i< WIDTH; i++)
{
		for (int j = 0 ; j < HEIGHT; j++) 
		{
				System.out.print(tab[i][j]);
		}
		System.out.println(""); // quand on passe au "i" suivant (dans la boucle for) on retourne à la ligne
} 

}
///////////////////////////////////
public void Initialize() 
{

for (int i = 0 ; i< WIDTH ; i++)
{
		for (int j = 0 ; j < HEIGHT ; j++) 
		{
				tab[i][j]='a';
		}
} 

}
///////////////////////////////////
public char getChar(int positionX,int positionY) {
	return tab[positionX][positionY];
}

/*
public void settab(int x, int y,char p) 
{
	if (p != 1 && p !=2)
	{
		System.out.println("Nombre joueur incorrect");
	}
	else if (x > 2 || x < 0) 
	{
		System.out.println("Nombre de colonne choisie incorrect");
	}
	else if (y > 2 || y < 0) 
	{
		System.out.println("Nombre de ligne choisie incorrect");
	}
	else
	{
		tab[x][y] = p;
	} */
}

