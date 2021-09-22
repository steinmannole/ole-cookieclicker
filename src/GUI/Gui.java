package GUI;

import javax.swing.JFrame;

import Actions.Data;
import Actions.Main;
import Actions.MouseHandler;
import Draw.Draw_Main;
import Draw.Draw_Options;
import Draw.Draw_Achievements;
import Draw.Draw_Buttons;
import Draw.Draw_Upgrades;

public class Gui {

	JFrame jf;
	Draw_Main d;
	Draw_Buttons db;
	Draw_Upgrades du;
	Draw_Options dop;
	Draw_Achievements da;
	IL il = new IL();

	public final int width = 1280;
	public final int height = 720;

	public static int maxHeight, actualHeight = 0;

	public static Button bUpgrades, bAchievements, bOptions;

	public static Button ugClicker, bCookie;
	public static Button bSpeichern, bLaden;

	public static Achievement achievement[] = new Achievement[Main.achievementAnzahl];
	public static AchievementSlider achievementSlider[] = new AchievementSlider[Main.achievementAnzahl];

	public static Button ugButton[] = new Button[Main.getUgAnzahl()];
	public static Upgrade upgrade[] = new Upgrade[Main.getUgAnzahl()];

	public void createGui() {

		bUpgrades = new Button(width / 2, 0, 146 + 50, 100);
		bUpgrades.active = true;
		bAchievements = new Button(width / 2 + 196, 0, 219 + 50, 100);
		bOptions = new Button(width - 175, 0, 175, 100);

		bCookie = new Button(width / 4 - 96, 150, 192, 192);
		ugClicker = new Button(width / 4 - 75, 500, 150, 50);

		bSpeichern = new Button((width / 4) * 3 - 100, 200, 200, 50);
		bLaden = new Button((width / 4) * 3 - 100, 400, 200, 50);

		for (int i = 0; i < upgrade.length; i++) {
			ugButton[i] = new Button();
			ugButton[i].y = 150 + (i * 200) + 85;
			ugButton[i].x = (width / 2) + (((width / 2) / 3) * 2) + 20;
			ugButton[i].width = 170;
			ugButton[i].height = 40;
		}

		upgrade[0] = new Upgrade("Ofen", il.iug[0], 10);
		upgrade[1] = new Upgrade("Mitarbeiter", il.iug[1], 500);
		upgrade[2] = new Upgrade("Koch", il.iug[2], 5000);
		upgrade[3] = new Upgrade("Cookiebagger", il.iug[3], 50000);
		upgrade[4] = new Upgrade("Fabrik", il.iug[4], 500000);
		
		for (int i = 0; i <upgrade.length; i++) {
			upgrade[i].setY(Upgrade.setYCoord(i));
		}

		maxHeight = (upgrade.length * (150 + 50));

		int temp = 0;
		int yVersch = 0;
		int xVersch = 0;

		for (int i = 0; i < achievement.length; i++) {
			achievement[i] = new Achievement(width / 2 + 7 + xVersch, 107 + yVersch, il.iachievement[i]);

			temp++;

			if (temp % 12 == 0) {
				temp = 0;
				yVersch += 52;
			}

			xVersch = temp * 50 + temp * 2;

		}
		
		Data.setAchievementName();
		Data.setAchievementText();
		
		for (int i = 0; i<achievementSlider.length; i++) {
			achievementSlider[i] = new AchievementSlider(achievement[i]);
		}

		jf = new JFrame("Cookie Clicker");
		jf.setSize(width, height);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.addMouseWheelListener(new MouseHandler());
		jf.setResizable(false);

		db = new Draw_Buttons();
		db.setSize(width, height);
		db.setVisible(true);
		db.requestFocus();
		db.addMouseListener(new MouseHandler());
		db.addMouseMotionListener(new MouseHandler());
		jf.add(db);

		du = new Draw_Upgrades();
		du.setSize(width, height);
		du.setVisible(true);
		du.requestFocus();
		du.addMouseListener(new MouseHandler());
		du.addMouseMotionListener(new MouseHandler());
		jf.add(du);

		dop = new Draw_Options();
		dop.setSize(width, height);
		dop.setVisible(true);
		dop.requestFocus();
		dop.addMouseListener(new MouseHandler());
		dop.addMouseMotionListener(new MouseHandler());
		jf.add(dop);

		da = new Draw_Achievements();
		da.setSize(width, height);
		da.setVisible(true);
		da.requestFocus();
		da.addMouseListener(new MouseHandler());
		da.addMouseMotionListener(new MouseHandler());
		jf.add(da);

		d = new Draw_Main();
		d.setSize(width, height);
		d.setVisible(true);
		d.requestFocus();
		d.addMouseListener(new MouseHandler());
		d.addMouseMotionListener(new MouseHandler());
		jf.add(d);

		jf.setVisible(true);

	}

}
