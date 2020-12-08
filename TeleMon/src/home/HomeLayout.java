package home;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class HomeLayout extends JPanel{

	Image img = Toolkit.getDefaultToolkit().getImage("img/home.png");
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(img, 0, 0, 480,620,this);

	}
}


