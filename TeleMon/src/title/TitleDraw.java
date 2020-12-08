package title;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;



public class TitleDraw extends JPanel{
	Image img = Toolkit.getDefaultToolkit().getImage("yggdrasil.png");
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//‰æ‘œ‚Ì•\Ž¦
		g.drawImage(img, 0, 0, 480,620,this);
	}
}
