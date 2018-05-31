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
     */
    public static void main(final String[] args) {
    	/*String path = "C:/Users/marti/Desktop/projet/";
    	String filePrev = "salle0";
    	String fileNumber = "05";
    	String extension = ".txt";
    	
    	GameTab game= new GameTab(path + filePrev + fileNumber + extension);
    	game.Showtab();*/
    	
    	GameManager game = new GameManager();
    	
    	// System.out.println(mapdejeu.GetChar(player1.getPositionX()-1,player1.getPositionY()));
    	/* final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());

        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        } */
        
       //1234567895
    }

}
