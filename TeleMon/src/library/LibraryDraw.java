package library;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;



import javax.swing.JPanel;



	public class LibraryDraw extends JPanel{
		
		///////////
		//�摜���[�h
		///////////
		
		

		
		Image mon1 = Toolkit.getDefaultToolkit().getImage("img/Mon1.png");					//�����X�^�[
		
		Image question = Toolkit.getDefaultToolkit().getImage("img/UnKnown.png");			//�͂Ă�
		
		Image Mess_Win = Toolkit.getDefaultToolkit().getImage("img/Messagewindow.png");		//���b�Z�[�W�E�B���h�E
		
		Image Mess_Win2 = Toolkit.getDefaultToolkit().getImage("img/Messagewindow.png");	//���b�Z�[�W�E�B���h�E2
		

		
		
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
						
			///////////
			//�`��
			///////////
			Graphics2D g2 = (Graphics2D)g;
			 
			//�����x��50%�ɐݒ肷��
			AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f);
			g2.setComposite(ac);
	 
			//g2.drawImage(img, 0, 0, this);
					
			g2.drawImage(mon1, 0, 50,480/2,620/2, this);		//�����X�^�[
			
			g2.drawImage(question, 275, 140,150,150, this);		//�͂Ă�
			
			g2.drawImage(Mess_Win, 18, 350,210,130, this);		//���b�Z�[�W�E�B���h�E
			
			g2.drawImage(Mess_Win2, 480/2, 350,210,130, this);	//���b�Z�[�W�E�B���h�E2

		}
	
	
	}

