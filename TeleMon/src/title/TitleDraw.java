package title;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;



public class TitleDraw extends JPanel{
	Image img = Toolkit.getDefaultToolkit().getImage("telemon.png");
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//画像の表示
		g.drawImage(img, 0, 0, 480,620,this);

	}
}
