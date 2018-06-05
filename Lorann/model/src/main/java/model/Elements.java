package model;

import model.GameTab;

public abstract class Elements {
	protected int positionX;
	protected int positionY;
	protected char name;

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
	
	public abstract boolean isPassable();
	
	public Elements() {

	}

}
