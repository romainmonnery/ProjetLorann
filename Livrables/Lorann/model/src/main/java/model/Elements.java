package model;

/**
 * <h1>The Class Elements.</h1>
 *
 * @author Niels Boecks, Martins Pedro, Monnery Romain
 * @version 1.0
 */

public abstract class Elements {
	
	//Attribute which correspond to the coordinate X from an element on the game map
	protected int positionX;
	//Attribute which correspond to the coordinate Y from an element on the game map
	protected int positionY;
	//Attribute which correspond to the sprite of the element in the game tab
	protected char name;

	/**
     * The getPositionX() method.
     *
     * @param no parameters
     * @return the positionX attribute (int)
     */
	public int getPositionX() {
		return positionX;
	}
	
	/**
     * The setPositionX() method.
     * Update the value of the attribute positionX (int)
     *
     * @param the positionX attribute (int)
     * 
     */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	/**
     * The getPositionY() method.
     *
     * @param no parameters
     * @return the value of the attribute positionY (int)
     */
	public int getPositionY() {
		return positionY;
	}
	
	/**
     * The setPositionY() method.
     * Update the value of the attribute positionY (int)
     *
     * @param the positionY attribute (int)
     * 
     */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	
	/**
     * The getName method.
     *
     * @param the name attribute (char)
     * @return the name attribute (char)
     */
	public char getName() {
		return name;
	}
	
	/**
     * The isPassable method (abstract).
     *
     * Define if the Element is able to take Keys and pass the Open door
     */
	public abstract boolean isPassable();
	
}
