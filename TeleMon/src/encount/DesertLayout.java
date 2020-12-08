package encount;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class DesertLayout extends JPanel{
	public String name;

	public DesertLayout(String name) {

		this.name = name;

	}


		public void paintComponent(Graphics g) {


			Image grass = Toolkit.getDefaultToolkit().getImage("img/desert.png");
			Image cat = Toolkit.getDefaultToolkit().getImage("src/character/Material/" + name + ".png");
			super.paintComponent(g);

			g.drawImage(grass, 0, 0, 480,620,this);
			//grass.setBounds();
			g.drawImage(cat, 200, 50,480/3,620/3, this);
		}


		public String getName() {return name;}
		public void setName(String name) {this.name = name;}
}
