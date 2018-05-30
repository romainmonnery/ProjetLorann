package main;
import model.GameTab;
import java.sql.SQLException;
import controller.ControllerFacade;
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
          	
    	String path = "C:/Users/Niels/Downloads/Salles/";
    	String filePrev = "salle0";
    	String fileNumber = "05";
    	String extension = ".txt";
    	GameTab mapdejeu = new GameTab(path + filePrev + fileNumber + extension);
    	
    	mapdejeu.Showtab();
    	
    	
    	
    	
    	/* final ControllerFacade controller = new ControllerFacade(new ViewFacade(), new ModelFacade());

        try {
            controller.start();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        } */
        
       //1234567895
    }

}
