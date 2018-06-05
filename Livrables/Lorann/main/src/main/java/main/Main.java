
package main;
import controller.GameManager;
import model.GameTab;
import model.Player;

import java.io.IOException;
import java.sql.SQLException;


/**
 * <h1>The Class Main.</h1>
 *
 * @author Niels Boeckx, Martins Pedro, Monnery Romain
 * @version 1.0
 */

public abstract class Main {
	
    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws SQLException 
     * @throws IOException 
     */
    public static void main(final String[] args) throws SQLException, IOException {
    	
    	GameManager game = new GameManager();
    	
    
    }
}
