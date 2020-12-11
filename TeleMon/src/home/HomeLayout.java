package home;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class HomeLayout extends JPanel{
	
	Image home = Toolkit.getDefaultToolkit().getImage("img/home.png");
	Image partner;
	String name=null;
	
	public HomeLayout() {
		
	}
	
	public void setPartnerName(String name) {
		this.name=name;
		partner = Toolkit.getDefaultToolkit().getImage("src/character/Material/"+name+".png");
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(home, 0, 0, 480,620,this);
		g.drawImage(partner, 150, 300, 480/3,620/3,this);
	}
}


