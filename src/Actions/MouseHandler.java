package Actions;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import GUI.Button;
import GUI.Gui;
import GUI.Upgrade;

public class MouseHandler implements MouseListener, MouseWheelListener, MouseMotionListener {

	Gui gui = new Gui();
	MouseCollision mc = new MouseCollision();

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		// Upgrades Button
		if (mc.inside(e.getX(), e.getY(), Gui.bUpgrades)) {
			Button.setActive(Gui.bUpgrades);
		}

		// Achievement Button
		if (mc.inside(e.getX(), e.getY(), Gui.bAchievements)) {
			Button.setActive(Gui.bAchievements);
		}

		// Options Button
		if (mc.inside(e.getX(), e.getY(), Gui.bOptions)) {
			Button.setActive(Gui.bOptions);
		}

		// Cookie Button
		if (mc.inside(e.getX(), e.getY(), Gui.bCookie)) {
			Gui.bCookie.setActive(true);
			Main.cookies += Main.cpc;
			Main.klickCount++;
		}

		// Upgrade Buttons
		for (int i = 0; i < Gui.upgrade.length; i++) {
			if (mc.inside(e.getX(), e.getY(), Gui.ugButton[i])) {

				if (Main.cookies >= Gui.upgrade[i].getCost()) {
					Main.cookies -= Gui.upgrade[i].getCost();

					int anzl = Gui.upgrade[i].getAnzahl();
					Gui.upgrade[i].setAnzahl(anzl += 1);
					int cst = Gui.upgrade[i].getCost();
					Gui.upgrade[i].setCost(cst += cst / 2);
					Upgrade.cpsUpgrade(i);
				}

			}
		}

		// Upgrade Clicker
		if (mc.inside(e.getX(), e.getY(), Gui.ugClicker)) {
			if (Main.cookies >= Main.ugClickerCost) {
				Main.cookies -= Main.ugClickerCost;

				Main.ugClickerCost *= 2;
				Main.cpc += Main.cpc / 2;

			}
		}

		// Speichern Button
		if (mc.inside(e.getX(), e.getY(), gui.bSpeichern)) {
			Data.safeData();
		}

		// Laden Button
		if (mc.inside(e.getX(), e.getY(), gui.bLaden)) {
			Data.loadData();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		// Cookie Button
		if (Gui.bCookie.isActive()) {
			Gui.bCookie.setActive(false);
		}

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {

		if (Gui.bUpgrades.isActive()) {

			if (e.getX() > gui.width / 2) {

				// Runterscrollen -> Upgrades nach oben
				if (e.getWheelRotation() == 1) {
					Gui.actualHeight -= 20;

					if (Gui.actualHeight >= -(Gui.maxHeight - 550)) {
						for (int i = 0; i < Gui.upgrade.length; i++) {
							int y1 = Gui.upgrade[i].getY() - 20;
							int y2 = Gui.ugButton[i].getY() - 20;

							Gui.upgrade[i].setY(y1);
							Gui.ugButton[i].setY(y2);

						}
					} else {
						Gui.actualHeight = -(Gui.maxHeight - 550);
					}

				}

				// Hochscrollen -> Upgrades nach unten
				if (e.getWheelRotation() == -1) {
					Gui.actualHeight += 20;

					if (Gui.actualHeight <= 0) {
						for (int i = 0; i < Gui.upgrade.length; i++) {
							int y1 = Gui.upgrade[i].getY() + 20;
							int y2 = Gui.ugButton[i].getY() + 20;

							Gui.upgrade[i].setY(y1);
							Gui.ugButton[i].setY(y2);
						}
					} else {
						Gui.actualHeight = 0;
					}

				}
			}

		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		// Upgrades Button
		if (mc.inside(e.getX(), e.getY(), Gui.bUpgrades)) {
			Gui.bUpgrades.setHover(true);
		} else {
			Gui.bUpgrades.setHover(false);
		}

		// Achievements Button
		if (mc.inside(e.getX(), e.getY(), Gui.bAchievements)) {
			Gui.bAchievements.setHover(true);
		} else {
			Gui.bAchievements.setHover(false);
		}

		// Options Button
		if (mc.inside(e.getX(), e.getY(), Gui.bOptions)) {
			Gui.bOptions.setHover(true);
		} else {
			Gui.bOptions.setHover(false);
		}

		// Upgrades Buttons
		for (int i = 0; i < Gui.ugButton.length; i++) {
			if (mc.inside(e.getX(), e.getY(), Gui.ugButton[i])) {
				Gui.ugButton[i].setHover(true);
			} else {
				Gui.ugButton[i].setHover(false);
			}
		}

		// Upgrade Clicker
		if (mc.inside(e.getX(), e.getY(), Gui.ugClicker)) {
			Gui.ugClicker.setHover(true);
		} else {
			Gui.ugClicker.setHover(false);
		}

		// Speichern Button
		if (mc.inside(e.getX(), e.getY(), Gui.bSpeichern)) {
			Gui.bSpeichern.setHover(true);
		} else {
			Gui.bSpeichern.setHover(false);
		}

		// Laden Button
		if (mc.inside(e.getX(), e.getY(), Gui.bLaden)) {
			Gui.bLaden.setHover(true);
		} else {
			Gui.bLaden.setHover(false);
		}

		//////////////////////////////
		// Achievements
		//////////////////////////////

		for (int i = 0; i < Main.achievementAnzahl; i++) {
			if (mc.inside(e.getX(), e.getY(), Gui.achievement[i])) {
				Gui.achievement[i].setHover(true);
			} else {
				Gui.achievement[i].setHover(false);
			}
		}

	}
}
