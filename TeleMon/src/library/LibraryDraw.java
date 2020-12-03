package library;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
	public class LibraryDraw extends JPanel{

		Image book = Toolkit.getDefaultToolkit().getImage("img/Library.png");

		Image mon1 = Toolkit.getDefaultToolkit().getImage("img/ƒAƒ‹ƒ‰ƒEƒl1.png");

		Image question = Toolkit.getDefaultToolkit().getImage("img/UnKnown.png");

		Color col = new Color(0,255,255,100);

	public void paintComponent(Graphics g) {
			super.paintComponent(g);


			g.drawImage(book, 0, 0,480,620, this);
			g.drawImage(mon1, 0, 50,480/2,620/2, this);
			g.drawImage(question, 480-230, 120,200,200, this);

		}
	}

