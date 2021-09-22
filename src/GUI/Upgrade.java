package GUI;

import java.awt.image.BufferedImage;

import Actions.Main;

public class Upgrade {

	Gui gui = new Gui();

	int x, y;
	int width = gui.width / 2;
	int height = 150;
	String name;
	BufferedImage image;
	int anzahl;
	int cost;

	public Upgrade(String name, BufferedImage image, int cost) {
		this.x = gui.width / 2;
		this.name = name;
		this.image = image;
		this.anzahl = 0;
		this.cost = cost;
	}
	
	public static int setYCoord(int index) {
		return 150 + index * 200;
	}

	public static void cpsUpgrade(int index) {
		switch(index ) {
		case 0: 
			Main.cps += 2;
			break;
		case 1:
			Main.cps += 10;
			break;
		case 2:
			Main.cps += 50;
			break;
		case 3:
			Main.cps += 100;
			break;
		}
	}

	public Gui getGui() {
		return gui;
	}

	public void setGui(Gui gui) {
		this.gui = gui;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public int getAnzahl() {
		return anzahl;
	}

	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	

}
