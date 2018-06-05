package model.dao;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;

/**
 * <h1>The Class ImageImport.</h1>
 *
 * @author Niels Boecks, Martins Pedro, Monnery Romain
 * @version 1.0
 */

public class ImageImport {
	
	//attribute corresponding to an image
	private Image i;
	//attribute corresponding to the horizontal bone image
	private Image horizontal_bone;
	//attribute corresponding to the vertical bone image
	private Image vertical_bone;
	//attribute corresponding to the bone image
	private Image bone;
	//attribute corresponding to the key image
	private Image crystal_ball;
	//attribute corresponding to the purse image
	private Image purse;
	//attribute corresponding to the closed gate image
	private Image gate_closed;
	//attribute corresponding to the opened gate
	private Image gate_open;

	/**
     * The ImageImport constructor.
     *
     *Associate to each attribute a path of image
     * @param no parameters
     * 
     * 
     */
	
	public ImageImport() throws IOException {
		this.horizontal_bone = ImageIO
				.read(ImageImport.class.getClass().getResource("/picture/horizontal_bone.png").openStream());
		this.vertical_bone = ImageIO
				.read(ImageImport.class.getClass().getResource("/picture/vertical_bone.png").openStream());
		this.bone = ImageIO.read(ImageImport.class.getClass().getResource("/picture/bone.png").openStream());
		this.crystal_ball = ImageIO
				.read(ImageImport.class.getClass().getResource("/picture/crystal_ball.png").openStream());
		this.purse = ImageIO.read(ImageImport.class.getClass().getResource("/picture/purse.png").openStream());
		this.gate_closed = ImageIO
				.read(ImageImport.class.getClass().getResource("/picture/gate_closed.png").openStream());
		this.gate_open = ImageIO.read(ImageImport.class.getClass().getResource("/picture/gate_open.png").openStream());

	}
	
	/**
     * The getImage method.
     *
     *Loads an image depending of the char encountered 
     * @param char c
     * @return i (BufferedImage)
     * 
     */
	public Image getImage(char c) {

		if (c == '-') {

			i = horizontal_bone;

		} else {

			if (c == 'I') {

				i = vertical_bone;
			} else {

				if (c == 'O') {

					i = bone;
				} else {

					if (c == 'Q') {

						i = crystal_ball;

					} else {

						if (c == '1' || c == '2' || c == '3') {

							i = purse;

						} else {
							if (c == 'Y') {
								i = gate_closed;

							} else {
								if (c == 'Z') {

									i = gate_open;

								} else

									i = null;
							}

						}
					}
				}
			}

		}
		return i;
	}
}
