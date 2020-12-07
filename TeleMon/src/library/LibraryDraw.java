package library;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;



	public class LibraryDraw extends JPanel{
		
		///////////
		//画像ロード
		///////////
		
		
		Image book = Toolkit.getDefaultToolkit().getImage("img/Library.png");				//本
		
		Image Back = Toolkit.getDefaultToolkit().getImage("img/Background.jpg");			//背景
		
		Image mon1 = Toolkit.getDefaultToolkit().getImage("img/アルラウネ1.png");					//モンスター
		
		Image question = Toolkit.getDefaultToolkit().getImage("img/UnKnown.png");			//はてな
		
		Image Mess_Win = Toolkit.getDefaultToolkit().getImage("img/Messagewindow.png");		//メッセージウィンドウ
		
		Image Mess_Win2 = Toolkit.getDefaultToolkit().getImage("img/Messagewindow.png");	//メッセージウィンドウ2
		

		
		
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
						
			///////////
			//描画
			///////////
		
			
			g.drawImage(Back, 0, 0,480,620, this);				//背景
			
			g.drawImage(book, -3, 0,480,620, this);				//本
					
			g.drawImage(mon1, 0, 50,480/2,620/2, this);		//モンスター
			
			g.drawImage(question, 275, 140,150,150, this);		//はてな
			
			g.drawImage(Mess_Win, 18, 350,210,130, this);		//メッセージウィンドウ
			
			g.drawImage(Mess_Win2, 480/2, 350,210,130, this);	//メッセージウィンドウ2

		}
	
	
	}

