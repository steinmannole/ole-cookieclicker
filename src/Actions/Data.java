package Actions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

import javax.swing.JFileChooser;

import GUI.Gui;

public class Data {

	File folder = new File("data");
	File file = new File("data/save.txt");
	StringBuilder sb = new StringBuilder();

	public static void safeData() {

		Data data = new Data();

		// Erstellen
		if (!data.folder.exists()) {
			data.folder.mkdirs();
		}

		if (!data.file.exists()) {
			try {
				data.file.createNewFile();

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		// Speichern
		data.sb.append(Main.cookies);
		data.sb.append("\n");
		data.sb.append(Main.cps);
		data.sb.append("\n");
		data.sb.append(Main.cpc);
		data.sb.append("\n");
		data.sb.append(Main.ugClickerCost);
		data.sb.append("\n");

		for (int i = 0; i < Gui.upgrade.length; i++) {
			data.sb.append(Gui.upgrade[i].getAnzahl());
			data.sb.append("\n");
			data.sb.append(Gui.upgrade[i].getCost());
			data.sb.append("\n");
		}

		data.sb.append(Main.klickCount);
		data.sb.append("\n");

		for (int i = 0; i < Main.achievementAnzahl; i++) {
			if (Gui.achievement[i].isUnlocked()) {
				data.sb.append("1");
				data.sb.append("\n");
			} else {
				data.sb.append("0");
				data.sb.append("\n");
			}
		}

		try {
			OutputStream stream = new FileOutputStream(data.file);
			String s = data.sb.toString();

			stream.write(s.getBytes());
			stream.close();

			System.out.println("Daten gesichert!");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void loadData() {
		JFileChooser chooser = new JFileChooser();

		int temp = chooser.showOpenDialog(null);
		if (temp == JFileChooser.APPROVE_OPTION) {
			String s = chooser.getSelectedFile().getAbsolutePath();
			if (s.endsWith("save.txt")) {

				File file = new File(s);
				try {
					Scanner sc = new Scanner(file);

					Main.cookies = Double.parseDouble(sc.nextLine());
					Main.cps = Double.parseDouble(sc.nextLine());
					Main.cpc = Double.parseDouble(sc.nextLine());
					Main.ugClickerCost = Integer.parseInt(sc.nextLine());

					for (int i = 0; i < Gui.upgrade.length; i++) {
						Gui.upgrade[i].setAnzahl(Integer.parseInt(sc.nextLine()));
						Gui.upgrade[i].setCost(Integer.parseInt(sc.nextLine()));
					}

					Main.klickCount = Integer.parseInt(sc.nextLine());

					for (int i = 0; i < Main.achievementAnzahl; i++) {
						if (sc.nextLine().equals("1")) {
							Gui.achievement[i].setUnlocked(true);
						} else {
							Gui.achievement[i].setUnlocked(false);
						}
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				System.out.println("Fehler beim Einlesen!");
			}
		}
	}

	public static void loadStart() {

				File save = new File("C:/Tools/eclipse/workspace/CookieClicker/data/save.txt");
				if(save.exists()) {
					 
				try {
					Scanner sc = new Scanner(save);

					Main.cookies = Double.parseDouble(sc.nextLine());
					Main.cps = Double.parseDouble(sc.nextLine());
					Main.cpc = Double.parseDouble(sc.nextLine());
					Main.ugClickerCost = Integer.parseInt(sc.nextLine());

					for (int i = 0; i < Gui.upgrade.length; i++) {
						Gui.upgrade[i].setAnzahl(Integer.parseInt(sc.nextLine()));
						Gui.upgrade[i].setCost(Integer.parseInt(sc.nextLine()));
					}

					Main.klickCount = Integer.parseInt(sc.nextLine());

					for (int i = 0; i < Main.achievementAnzahl; i++) {
						if (sc.nextLine().equals("1")) {
							Gui.achievement[i].setUnlocked(true);
						} else {
							Gui.achievement[i].setUnlocked(false);
						}
					}

				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}

	public static void setAchievementText() {
		File achText = new File("C:/Tools/eclipse/workspace/CookieClicker/data/achtext.txt");
		if(achText != null) {
			try {
				Scanner sc = new Scanner(achText);
				for (int i = 0; i<Main.achievementAnzahl; i++) {
					Gui.achievement[i].setText(sc.nextLine());
				}
			} catch (FileNotFoundException e) {
				System.out.println("Achievementtexte konnten nicht eingelesen werden");
				e.printStackTrace();
			}
		}
	}

	public static void setAchievementName() {
		File achName = new File("C:/Tools/eclipse/workspace/CookieClicker/data/achname.txt");
		if(achName != null) {
			try {
				Scanner sc = new Scanner(achName);
				for (int i = 0; i<Main.achievementAnzahl; i++) {
					Gui.achievement[i].setName(sc.nextLine());
				}
			} catch (FileNotFoundException e) {
				System.out.println("Achievementnamen konnten nicht eingelesen werden");
				e.printStackTrace();
			}
		}
	}
	
}
