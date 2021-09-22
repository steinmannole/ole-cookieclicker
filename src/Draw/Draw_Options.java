package Draw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

import GUI.Gui;

public class Draw_Options extends JLabel{

	Gui gui = new Gui();
	int textWidth;
	
	protected void paintComponent(Graphics g) {
		

		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
		if(Gui.bOptions.isActive()) {
			
			//Speichern
			
			g.setColor(new Color(43,61,79,150));
			
			g.fillRect(gui.width / 2 + 1, 150, gui.width, 150);
			
			g.setColor(new Color(255,255,255,150));
			g.drawLine(gui.width / 2 + 1, 150, gui.width, 150);
			g.drawLine(gui.width / 2 + 1, 150 + 150, gui.width, 150 + 150);
			
			g.drawRect(Gui.bSpeichern.getX(), Gui.bSpeichern.getY(), Gui.bSpeichern.getWidth(), Gui.bSpeichern.getHeight());
			
			if (Gui.bSpeichern.isHover()) {
				g.setColor(new Color(84,84,84,150));
				g.fillRect(Gui.bSpeichern.getX()+1, Gui.bSpeichern.getY()+1, Gui.bSpeichern.getWidth()-2, Gui.bSpeichern.getHeight()-2);
			} else {
				g.setColor(Color.WHITE);
			}
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.PLAIN, 25));
			textWidth = g.getFontMetrics().stringWidth("Speichern");
			g.drawString("Speichern", (gui.width/4)*3 - textWidth/2, 233);
			
			//Laden
			
			g.setColor(new Color(43,61,79,150));
			
			g.fillRect(gui.width / 2 + 1, 350, gui.width, 150);
			
			g.setColor(new Color(255,255,255,150));
			g.drawLine(gui.width / 2 + 1, 350, gui.width, 350);
			g.drawLine(gui.width / 2 + 1, 350 + 150, gui.width, 350 + 150);
			
			g.drawRect(Gui.bLaden.getX(), Gui.bLaden.getY(), Gui.bLaden.getWidth(), Gui.bLaden.getHeight());
			
			if (Gui.bLaden.isHover()) {
				g.setColor(new Color(84,84,84,150));
				g.fillRect(Gui.bLaden.getX()+1, Gui.bLaden.getY()+1, Gui.bLaden.getWidth()-1, Gui.bLaden.getHeight()-1);
			} else {
				g.setColor(Color.WHITE);
			}
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.PLAIN, 25));
			textWidth = g.getFontMetrics().stringWidth("Laden");
			g.drawString("Laden", (gui.width/4)*3 - textWidth/2, 233 + 200);
			
		}
	repaint();
	}
}
