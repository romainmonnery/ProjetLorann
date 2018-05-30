package model;

public class Player extends MobileElement{
	
	private int positionX;
	private int positionY;
	private final char name = '@';
	
	
	public int getPositionX() {
		return positionX;
	}
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	public int getPositionY() {
		return positionY;
	}
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	public char getName() {
		return name;
	}
	
	////////////constructeur///////////
	public Player() {
		this.positionX = 6;
		this.positionY = 17;
	}

}
