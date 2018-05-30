package model.dao;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageImport {
	private BufferedImage i;

	public ImageImport() {
	}

	public Image getImage(char c) {

		if (c == '-') {

			try {
				i = ImageIO.read(new File("C:/Users/marti/Desktop/projet/sprite/horizontal_bone.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

			if (c == 'I') {

				try {
					i = ImageIO.read(new File("C:/Users/marti/Desktop/projet/sprite/vertical_bone.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {

				if (c == 'O') {

					try {
						i = ImageIO.read(new File("C:/Users/marti/Desktop/projet/sprite/bone.png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {

					if (c == 'Q') {

						try {
							i = ImageIO.read(new File("C:/Users/marti/Desktop/projet/sprite/crystal_ball.png"));
						} catch (IOException e) {
							e.printStackTrace();
						}

					} else {

						if (c == '1' || c == '2' || c == '3') {

							try {
								i = ImageIO.read(new File("C:/Users/marti/Desktop/projet/sprite/purse.png"));
							} catch (IOException e) {
								e.printStackTrace();
							}

						} else {
							i = null;
						}
					}

				}

			}

		}

		return i;

	}
}
