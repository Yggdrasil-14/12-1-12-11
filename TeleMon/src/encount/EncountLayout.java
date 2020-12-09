package encount;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class EncountLayout extends JPanel {
	public String name;
	public int place=0;
	Image grass;

	public EncountLayout(String name,int place) {
		this.name = name;
		this.place = place;
	}

	public void paintComponent(Graphics g) {

		if(place==1) grass = Toolkit.getDefaultToolkit().getImage("img/Grass.png");
		else if(place==2) grass = Toolkit.getDefaultToolkit().getImage("img/waterside.png");
		else if(place==3) grass = Toolkit.getDefaultToolkit().getImage("img/desert.png");
		Image monster = Toolkit.getDefaultToolkit().getImage("src/character/Material/" + name + ".png");
		super.paintComponent(g);

		g.drawImage(grass, 0, 0, 480, 620, this);
		// grass.setBounds();
		g.drawImage(monster, 200, 50, 480 / 2, 620 / 3, this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
