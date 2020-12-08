package library;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;



import javax.swing.JPanel;



	public class LibraryDraw extends JPanel{
		
		int page;
		
		///////////
		//�摜���[�h
		///////////
		
		Image book = Toolkit.getDefaultToolkit().getImage("img/Library.png");							//�{		
		Image Back = Toolkit.getDefaultToolkit().getImage("img/Background.jpg");						//�w�i
		Image mon1 = Toolkit.getDefaultToolkit().getImage("img/Mon1.png");								//�����X�^�[
		Image question = Toolkit.getDefaultToolkit().getImage("img/UnKnown.png");						//�͂Ă�
		Image Mess_win = Toolkit.getDefaultToolkit().getImage("img/Messagewindow.png");					//���b�Z�[�W�E�B���h�E
		Image Achive_re_T = Toolkit.getDefaultToolkit().getImage("img/Achievementreward_Title.png");	//�B����V(�^�C�g��)
		Image Achive_re = Toolkit.getDefaultToolkit().getImage("img/Achievementreward.png");			//�B����V
		Image Mon_ex = Toolkit.getDefaultToolkit().getImage("img/ArlauneExplanation.png");				//�����X�^�[�����e�L�X�g
		Image Comp_rate_T = Toolkit.getDefaultToolkit().getImage("img/Completerate_Title.png");			//�R���v���[�g��(�^�C�g��)
		Image No = Toolkit.getDefaultToolkit().getImage("img/No.png");			//�i���o�[�iNo.�j

		
		

		
		
		
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
						
			///////////
			//�`��
			///////////
			
			g.drawImage(Back, 0, 0,480,620, this);					//�w�i			
			g.drawImage(book, -3, 0,480,620, this);					//�{
			
			
			switch(page) {											//�y�[�W�؂�ւ�
			case 0:
				g.drawImage(Comp_rate_T, 40, 60,180,50, this);		//�R���v���[�g��(�^�C�g��)
				g.drawImage(Achive_re_T, 260, 60,180,50, this);		//�B����V(�^�C�g��)
				g.drawImage(Achive_re, 225, 120,300,360, this);		//�B����V
			break;
			
			case 1:
				g.drawImage(mon1, 0, 50,480/2,620/2, this);			//�����X�^�[
				g.drawImage(question, 275, 140,150,150, this);		//�͂Ă�
				g.drawImage(Mess_win, 18, 350,210,130, this);		//���b�Z�[�W�E�B���h�E(��)
				g.drawImage(Mon_ex, 30, 370,190,100, this);			//�����X�^�[�����e�L�X�g
				g.drawImage(Mess_win, 480/2, 350,210,130, this);	//���b�Z�[�W�E�B���h�E(�E)
			break;			
			
			case 2:
				g.drawImage(question, 50, 140,150,150, this);		//�͂Ă�
				g.drawImage(question, 275, 140,150,150, this);		//�͂Ă�
				g.drawImage(No, 20, 60,60,30, this);		//�i���o�[�iNo.�j
				g.drawImage(No, 250, 60,60,30, this);		//�i���o�[�iNo.�j
				g.drawImage(Mess_win, 18, 350,210,130, this);		//���b�Z�[�W�E�B���h�E(��)
				g.drawImage(Mess_win, 480/2, 350,210,130, this);	//���b�Z�[�W�E�B���h�E(�E)
				break;
			case 3:
				g.drawImage(question, 50, 140,150,150, this);		//�͂Ă�
				g.drawImage(question, 275, 140,150,150, this);		//�͂Ă�
				g.drawImage(Mess_win, 18, 350,210,130, this);		//���b�Z�[�W�E�B���h�E(��)
				g.drawImage(Mess_win, 480/2, 350,210,130, this);	//���b�Z�[�W�E�B���h�E(�E)
				break;
				
			case 4:
				g.drawImage(question, 50, 140,150,150, this);		//�͂Ă�
				g.drawImage(question, 275, 140,150,150, this);		//�͂Ă�
				g.drawImage(Mess_win, 18, 350,210,130, this);		//���b�Z�[�W�E�B���h�E(��)
				g.drawImage(Mess_win, 480/2, 350,210,130, this);	//���b�Z�[�W�E�B���h�E(�E)
				break;
				
			case 5:
				g.drawImage(question, 50, 140,150,150, this);		//�͂Ă�
				g.drawImage(question, 275, 140,150,150, this);		//�͂Ă�
				g.drawImage(Mess_win, 18, 350,210,130, this);		//���b�Z�[�W�E�B���h�E(��)
				g.drawImage(Mess_win, 480/2, 350,210,130, this);	//���b�Z�[�W�E�B���h�E(�E)
				break;
				
				}
			}
		}
	
	

