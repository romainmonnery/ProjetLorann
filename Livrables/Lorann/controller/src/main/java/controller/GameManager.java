package controller;

import java.io.IOException;
import java.sql.SQLException;
import view.Window;

/**
 * <h1>The Class GameManager.</h1>
 *
 * @author Niels Boecks, Martins Pedro, Monnery Romain
 * @version 1.0
 */
public class GameManager {
	//attributes corresponding to a Window object
	Window window;

	/**
     * The GameManager() constructor.
     *
     *Builds a GameManager calling the method run.
     * @param no parameters
     * @throws SQLException 
	 * @throws IOException 
     * 
     */
	public GameManager() throws SQLException, IOException {
		this.run();

	}

	/**
     * The run() method.
     *
     *Method which instantiate a window, allowing the game to start.
     *@param no parameters 
     *@throws SQLException 
	 * @throws IOException 
     * 
     */
	public void run() throws SQLException, IOException {
		
		window = new Window();
	}
}
