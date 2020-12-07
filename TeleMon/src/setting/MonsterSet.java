package setting;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;
public class MonsterSet extends JPanel{


	public void paintComponent(Graphics g) {
		Image img = Toolkit.getDefaultToolkit().getImage("img/Grass.png");
		super.paintComponent(g);

		g.drawImage(img, 200, 100,10,10,this);

	}
}
