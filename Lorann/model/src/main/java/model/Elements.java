package model;

public abstract class Elements {

	protected int positionX;
	protected int positionY;

	public Elements() {

	}

	public int getElementX() {
		return this.positionX;
	}

	public int getElementY() {
		return this.positionY;
	}

	public void setElementX(int elementX) {
		this.positionX = elementX;
	}

	public void setElementY(int elementY) {
		this.positionY = elementY;
	}

}
