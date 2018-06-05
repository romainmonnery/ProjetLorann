package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import controller.GameManager;
import model.dao.ImageImport;
import model.GameTab;
import model.Monster;
import model.Player;

/**
 * <h1>The Class Panel.</h1>
 *
 * @author Niels Boecks, Martins Pedro, Monnery Romain
 * @version 1.0
 */

public class Panel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private static final int sizeCase = 40;
	@SuppressWarnings("unused")
	//attribute corresponding to a Window object
	private Window f;
	//attribute corresponding to a Monster object
	private Monster monster;
	//attribute corresponding to a Player object
	private Player player;
	//attribute corresponding to an ImageImport object
	private ImageImport imageImport;
	//attribute corresponding to a GameTab object
	private GameTab gameTab;
	//attribute corresponding to an EndGame object
	private EndGame endGame;

	/**
     * The Panel constructor
     *
     *Builds a Panel taking a Window in parameter and instantiating a monster and a player
     * @param Window f
     * @throws SQLException 
	 * @throws IOException 
     * 
     */
	public Panel(Window f) throws SQLException, IOException {
		setPlayer(new Player());
		imageImport = new ImageImport();
		setGameTab(new GameTab());
		this.endGame = new EndGame();
		this.f = f;
		monster = new Monster();
		
	}

	/**
     * The PaintComponent() method
     *
     *Methods which paints the sprites of the player and the monster
     * @param Graphics g
     * 
     * 
     */
	public void paintComponent(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		int x = 0, y = 0;
		
		for (char[] tc : getGameTab().getTab()) {
			for (char c : tc) {

				Image img = imageImport.getImage(c);
				g.drawImage(img, y * sizeCase, x * sizeCase, null);
				
				y++;
			}
			x++;
			y = 0;
		}
		try {
			BufferedImage perso = ImageIO.read(new File("C:/Users/marti/Desktop/projet/sprite/lorann_u.png"));
			g.drawImage(perso, getPlayer().getPositionY() * sizeCase, getPlayer().getPositionX() * sizeCase, null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedImage monster = ImageIO.read(new File("C:/Users/marti/Desktop/projet/sprite/monster_1.png"));
			g.drawImage(monster, getMonster().getPositionY() * sizeCase, getMonster().getPositionX() * sizeCase, null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
     * The GetPlayer() method
     *
     *
     *@param no parameters
     *@return player attribute(Player) 
     * 
     */
	public Player getPlayer() {
		return player;
	}

	/**
     * The SetPlayer() method
     *
     *Setting the right value of Player
     *@param Player player
     * 
     * 
     */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
     * The getGameTab() method
     *
     *@param no parameters
     *@return gameTab
     * 
     */
	public GameTab getGameTab() {
		return gameTab;
	}

	/**
     * The setGameTab() method
     *
     *Setting the right value of gameTab
     *@param GameTab gameTab
     *
     * 
     */
	public void setGameTab(GameTab gameTab) {
		this.gameTab = gameTab;
	}

	/**
     * The getMonster() method
     *
     *
     *@param no parameters
     *@return monster
     * 
     */
	public Monster getMonster() {
		return this.monster;
	}
	
	/**
     * The getEndGame() method
     *
     *
     *@param no parameters
     *@return endGame
     * 
     */
	public EndGame getEndGame() {
		return this.endGame;
	}
}
