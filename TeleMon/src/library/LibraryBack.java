package library;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;



import javax.swing.JPanel;



	public class LibraryBack extends JPanel{
		
		///////////
		//âÊëúÉçÅ[Éh
		///////////
		
		
		Image book = Toolkit.getDefaultToolkit().getImage("img/Library.png");				//ñ{
		
		Image Back = Toolkit.getDefaultToolkit().getImage("img/Background.jpg");			//îwåi
		
		
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
						
			///////////
			//ï`âÊ
			///////////			
			
			g.drawImage(Back, 0, 0,480,620, this);				//îwåi
			
			g.drawImage(book, -3, 0,480,620, this);				//ñ{


		}
	
	
	}
