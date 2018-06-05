package model;

public class Monster extends Elements {

	public Monster() {
		this.positionX = 6;
		this.positionY = 16;
		this.name = 'A';
	}

	@Override
	public boolean isPassable() {

		return false;
	}

}