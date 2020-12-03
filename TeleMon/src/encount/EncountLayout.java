package encount;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class EncountLayout extends JPanel{



		public void paintComponent(Graphics g) {
			Image grass = Toolkit.getDefaultToolkit().getImage("Grass.png");
			Image cat = Toolkit.getDefaultToolkit().getImage("cat.png");
			super.paintComponent(g);

			g.drawImage(grass, 0, 0, 480,620,this);
			g.drawImage(cat, 0, 50,480/2,620/2, this);
		}
	}


