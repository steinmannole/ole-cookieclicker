package Actions;

import GUI.Gui;

public class Main {

	public static double cookies = 0;
	public static double cps = 0;
	public static double cpc = 1;
	public static int ugAnzahl = 5;
	public static int achievementAnzahl = 10;
	public static int klickCount = 0;
	
	public static int ugClickerCost = 10;

	public static void main(String[] args) {

		Gui g = new Gui();
		g.createGui();
		new CookieCounter();
		new AchievementCheck();
		Data.loadStart();
		
	}
		public static int getUgAnzahl() {
			return ugAnzahl;
		}

		public static void setUgAnzahl(int ugAnzahl) {
			Main.ugAnzahl = ugAnzahl;
	}
}
