package model;

/**
 * <h1>The Class Monster.</h1>
 *
 * @author Niels Boecks, Martins Pedro, Monnery Romain
 * @version 1.0
 */
public class Monster extends Elements {

	/**
	 * The Monster() constructor
	 *
	 * Associates the right positionX and positionY values for the monster and setting the name to 'A'
	 * 
	 * @param no parameters
	 * 
	 */
	public Monster() {
		this.positionX = 6;
		this.positionY = 16;
		this.name = 'A';
	}

	/**
	 * The isPassable() method 
	 *
	 * Define if the Monster is able to take Keys and pass the Open door
	 * 
	 * @param no parameters
	 * @return false
	 * 
	 */
	@Override
	public boolean isPassable() {

		return false;
	}

}
