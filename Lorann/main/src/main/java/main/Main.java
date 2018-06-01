package main;
import controller.GameManager;
import model.GameTab;
import model.Player;

import java.sql.SQLException;
import controller.ControllerFacade;
import controller.GameManager;
import view.ViewFacade;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public abstract class Main {
	
    /**
     * The main method.
     *
     * @param args
     *            the arguments
     * @throws SQLException 
     */
    public static void main(final String[] args) throws SQLException {
    	
//    	GameTab abc = new  GameTab();
//    	abc.rand();
    	GameManager game = new GameManager();
    	
    
}}
