package library;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;



import javax.swing.JPanel;



	public class LibraryBack extends JPanel{
		
		///////////
		//�摜���[�h
		///////////
		
		
		Image book = Toolkit.getDefaultToolkit().getImage("img/Library.png");				//�{
		
		Image Back = Toolkit.getDefaultToolkit().getImage("img/Background.jpg");			//�w�i
		
		
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
						
			///////////
			//�`��
			///////////			
			
			g.drawImage(Back, 0, 0,480,620, this);				//�w�i
			
			g.drawImage(book, -3, 0,480,620, this);				//�{


		}
	
	
	}
