package view;

import javax.swing.JFrame;

import model.Transf;

public class Window extends JFrame{
	
	
	Transf m = new Transf();
	//methode pour transformer char en images 
	public Fenetre() {
		 
		
		
	    this.setTitle("Lorann");
	    this.setSize (800, 800);
	    this.setLocationRelativeTo(null);
	    this.setBackground(Color.BLACK);        
	    
	    
	    
	    this.setContentPane(new Panel(this));               
	    this.setVisible(true);
		
		
		
		
		
		
		
	} 

}
