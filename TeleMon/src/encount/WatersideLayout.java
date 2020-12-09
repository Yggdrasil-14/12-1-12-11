package encount;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class WatersideLayout extends JPanel{
public String name;

	public WatersideLayout(String name) {

		this.name = name;

	}


		public void paintComponent(Graphics g) {


			Image grass = Toolkit.getDefaultToolkit().getImage("img/waterside.png");
			Image monster = Toolkit.getDefaultToolkit().getImage("src/character/Material/" + name + ".png");
			super.paintComponent(g);

			g.drawImage(grass, 0, 0, 480,620,this);
			//grass.setBounds();
			g.drawImage(monster, 200, 50,480/2,620/3, this);
		}


		public String getName() {return name;}
		public void setName(String name) {this.name = name;}
}
