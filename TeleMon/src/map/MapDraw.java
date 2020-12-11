package map;

import javax.swing.JPanel;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Graphics;

public class MapDraw extends JPanel{
	Image black=Toolkit.getDefaultToolkit().getImage("img/black.jpg");
	Image map=Toolkit.getDefaultToolkit().getImage("img/safari-map.png");
	Image act1=Toolkit.getDefaultToolkit().getImage("img/hero1.png");
	Image act2=Toolkit.getDefaultToolkit().getImage("img/hero2.png");
	Image act3=Toolkit.getDefaultToolkit().getImage("img/hero3.png");
	Image act4=Toolkit.getDefaultToolkit().getImage("img/hero4.png");
	
	private int posX,posY;
	private int direction;
	
	public MapDraw() {
		posX=-32*MapMain.initialPositionHorizontal;
		posY=-32*MapMain.initialPositionVertical;
		direction=MapMain.initialDirection;
	}
	
	public void settingMapDraw(int vertical,int horizontal,int direction) {
		posX=-32*horizontal;
		posY=-32*vertical;
		this.direction=direction;
	}
	
	public void setDirection(int direction) {
		this.direction=direction;
	}
	
	public void plusX() {
		posX+=32;
	}
	public void minusX() {
		posX-=32;
	}
	public void plusY() {
		posY+=32;
	}
	public void minusY() {
		posY-=32;
	}
	public void printXY() {
		System.out.println(posX+" "+posY);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(black,0,0,480,640,this);
		g.drawImage(map,(480-32)/2+posX,(640-32)/2+posY,640,480,this);
		if(direction==1) g.drawImage(act1,(480-32)/2,(640-32)/2-10,32,32,this);
		else if(direction==2) g.drawImage(act2,(480-32)/2,(640-32)/2-10,32,32,this);
		else if(direction==3) g.drawImage(act3,(480-32)/2,(640-32)/2-10,32,32,this);
		else if(direction==4) g.drawImage(act4,(480-32)/2,(640-32)/2-10,32,32,this);
	}
}
