package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Actions.Main;

public class IL {

	public BufferedImage ibg;
	public BufferedImage iug[] = new BufferedImage[Main.ugAnzahl];
	public BufferedImage icookie1, icookie2;
	public BufferedImage iachievement[] = new BufferedImage[Main.achievementAnzahl];

	public IL() {

		try {
			ibg = ImageIO.read(new File("C:/Tools/eclipse/workspace/CookieClicker/rsc/bg.png"));
			icookie1 = ImageIO.read(new File("C:/Tools/eclipse/workspace/CookieClicker/rsc/cookie1.png"));
			icookie2 = ImageIO.read(new File("C:/Tools/eclipse/workspace/CookieClicker/rsc/cookie2.png"));

			for (int i = 0; i < iug.length; i++) {
				iug[i] = ImageIO.read(new File("C:/Tools/eclipse/workspace/CookieClicker/rsc/ug" + (i + 1) + ".png"));
			}

			for (int i = 0; i < iachievement.length; i++) {
				iachievement[i] = ImageIO.read(new File("C:/Tools/eclipse/workspace/CookieClicker/rsc/ach" + (i + 1) + ".png"));
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
