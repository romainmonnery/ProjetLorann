package model;

public class Player extends Elements implements IMobile{
	

	
	

	////////////constructeur///////////
	
	public Player() {
		this.positionX = 2;
		this.positionY = 17;
		this.name = '@';
	}

	@Override
	public boolean isPassable() {
		return true;
	}

}
