package model;

/**
 * <h1>The Class Player.</h1>
 *
 * @author Niels Boecks, Martins Pedro, Monnery Romain
 * @version 1.0
 */
public class Player extends Elements {
	
	/**
	 * The Player() constructor
	 *
	 * Associates the right positionX and positionY values for the player and setting the name to '@'
	 * 
	 * @param no parameters
	 * 
	 */
	public Player() {
		this.positionX = 2;
		this.positionY = 17;
		this.name = '@';
	}

	/**
	 * The isPassable() method 
	 *
	 * Define if the Player is able to take Keys and pass the Open door
	 * 
	 * @param no parameters
	 * @return true
	 * 
	 */
	@Override
	public boolean isPassable() {
		return true;
	}

}
