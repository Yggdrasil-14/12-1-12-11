package library;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;



	public class LibraryDraw extends JPanel{
		
		///////////
		//�摜���[�h
		///////////
		
		
		Image book = Toolkit.getDefaultToolkit().getImage("img/Library.png");				//�{
		
		Image Back = Toolkit.getDefaultToolkit().getImage("img/Background.jpg");			//�w�i
		
		Image mon1 = Toolkit.getDefaultToolkit().getImage("img/�A�����E�l1.png");					//�����X�^�[
		
		Image question = Toolkit.getDefaultToolkit().getImage("img/UnKnown.png");			//�͂Ă�
		
		Image Mess_Win = Toolkit.getDefaultToolkit().getImage("img/Messagewindow.png");		//���b�Z�[�W�E�B���h�E
		
		Image Mess_Win2 = Toolkit.getDefaultToolkit().getImage("img/Messagewindow.png");	//���b�Z�[�W�E�B���h�E2
		

		
		
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
						
			///////////
			//�`��
			///////////
		
			
			g.drawImage(Back, 0, 0,480,620, this);				//�w�i
			
			g.drawImage(book, -3, 0,480,620, this);				//�{
					
			g.drawImage(mon1, 0, 50,480/2,620/2, this);		//�����X�^�[
			
			g.drawImage(question, 275, 140,150,150, this);		//�͂Ă�
			
			g.drawImage(Mess_Win, 18, 350,210,130, this);		//���b�Z�[�W�E�B���h�E
			
			g.drawImage(Mess_Win2, 480/2, 350,210,130, this);	//���b�Z�[�W�E�B���h�E2

		}
	
	
	}

