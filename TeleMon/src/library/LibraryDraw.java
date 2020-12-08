package library;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;



import javax.swing.JPanel;



	public class LibraryDraw extends JPanel{
		
		int page;
		
		///////////
		//画像ロード
		///////////
		
		Image book = Toolkit.getDefaultToolkit().getImage("img/Library.png");							//本		
		Image Back = Toolkit.getDefaultToolkit().getImage("img/Background.jpg");						//背景
		Image mon1 = Toolkit.getDefaultToolkit().getImage("img/Mon1.png");								//モンスター
		Image question = Toolkit.getDefaultToolkit().getImage("img/UnKnown.png");						//はてな
		Image Mess_win = Toolkit.getDefaultToolkit().getImage("img/Messagewindow.png");					//メッセージウィンドウ
		Image Achive_re_T = Toolkit.getDefaultToolkit().getImage("img/Achievementreward_Title.png");	//達成報酬(タイトル)
		Image Achive_re = Toolkit.getDefaultToolkit().getImage("img/Achievementreward.png");			//達成報酬
		Image Mon_ex = Toolkit.getDefaultToolkit().getImage("img/ArlauneExplanation.png");				//モンスター説明テキスト
		Image Comp_rate_T = Toolkit.getDefaultToolkit().getImage("img/Completerate_Title.png");			//コンプリート率(タイトル)
		Image No = Toolkit.getDefaultToolkit().getImage("img/No.png");			//ナンバー（No.）

		
		

		
		
		
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
						
			///////////
			//描画
			///////////
			
			g.drawImage(Back, 0, 0,480,620, this);					//背景			
			g.drawImage(book, -3, 0,480,620, this);					//本
			
			
			switch(page) {											//ページ切り替え
			case 0:
				g.drawImage(Comp_rate_T, 40, 60,180,50, this);		//コンプリート率(タイトル)
				g.drawImage(Achive_re_T, 260, 60,180,50, this);		//達成報酬(タイトル)
				g.drawImage(Achive_re, 225, 120,300,360, this);		//達成報酬
			break;
			
			case 1:
				g.drawImage(mon1, 0, 50,480/2,620/2, this);			//モンスター
				g.drawImage(question, 275, 140,150,150, this);		//はてな
				g.drawImage(Mess_win, 18, 350,210,130, this);		//メッセージウィンドウ(左)
				g.drawImage(Mon_ex, 30, 370,190,100, this);			//モンスター説明テキスト
				g.drawImage(Mess_win, 480/2, 350,210,130, this);	//メッセージウィンドウ(右)
			break;			
			
			case 2:
				g.drawImage(question, 50, 140,150,150, this);		//はてな
				g.drawImage(question, 275, 140,150,150, this);		//はてな
				g.drawImage(No, 20, 60,60,30, this);		//ナンバー（No.）
				g.drawImage(No, 250, 60,60,30, this);		//ナンバー（No.）
				g.drawImage(Mess_win, 18, 350,210,130, this);		//メッセージウィンドウ(左)
				g.drawImage(Mess_win, 480/2, 350,210,130, this);	//メッセージウィンドウ(右)
				break;
			case 3:
				g.drawImage(question, 50, 140,150,150, this);		//はてな
				g.drawImage(question, 275, 140,150,150, this);		//はてな
				g.drawImage(Mess_win, 18, 350,210,130, this);		//メッセージウィンドウ(左)
				g.drawImage(Mess_win, 480/2, 350,210,130, this);	//メッセージウィンドウ(右)
				break;
				
			case 4:
				g.drawImage(question, 50, 140,150,150, this);		//はてな
				g.drawImage(question, 275, 140,150,150, this);		//はてな
				g.drawImage(Mess_win, 18, 350,210,130, this);		//メッセージウィンドウ(左)
				g.drawImage(Mess_win, 480/2, 350,210,130, this);	//メッセージウィンドウ(右)
				break;
				
			case 5:
				g.drawImage(question, 50, 140,150,150, this);		//はてな
				g.drawImage(question, 275, 140,150,150, this);		//はてな
				g.drawImage(Mess_win, 18, 350,210,130, this);		//メッセージウィンドウ(左)
				g.drawImage(Mess_win, 480/2, 350,210,130, this);	//メッセージウィンドウ(右)
				break;
				
				}
			}
		}
	
	

