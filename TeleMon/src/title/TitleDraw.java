package title;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;



public class TitleDraw extends JPanel{
	Image img = Toolkit.getDefaultToolkit().getImage("img/telemon.png");
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(img, 0, 0, 480,620,this);

	}
}
