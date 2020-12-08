package library;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import character.Character;
import data.Save;


	public class LibraryDraw extends JPanel{

		Character Mon[] = new Character[Save.cl];

		Image img[] = new Image[Save.cl];
		public LibraryDraw(Character c[]) {
			String data[] = new String[Save.ec];
			for(int i=0;i<Save.cl;i++) {
			data[0] = c[i].getName();
			data[1] = Integer.toString(c[i].getCapture());
			data[2] = Integer.toString(c[i].getPartner());
			data[3] = "0";
			data[4] = "0";
			data[5] = "0";
			data[6] = Integer.toString(c[i].getFriendship());
			data[7] = "0";
			data[8] = "0";
			data[9] = "0";
			data[10] = "0";
			data[11] = "0";
			data[12] = "0";
			data[13] = "0";
			
			img[i] = Toolkit.getDefaultToolkit().getImage("src/character/Material/" + data[0] +".png");
			
			Mon[i] = new Character(data);

			}
		}


		int page;

		///////////
		//�摜���[�h
		///////////

		Image book = Toolkit.getDefaultToolkit().getImage("img/Library.png");							//�{
		Image Back = Toolkit.getDefaultToolkit().getImage("img/Background.jpg");						//�w�i
		Image question = Toolkit.getDefaultToolkit().getImage("img/UnKnown.png");						//�͂Ă�
		Image Mess_win = Toolkit.getDefaultToolkit().getImage("img/Messagewindow.png");					//���b�Z�[�W�E�B���h�E
		Image Achive_re_T = Toolkit.getDefaultToolkit().getImage("img/Achievementreward_Title.png");	//�B����V(�^�C�g��)
		Image Achive_re = Toolkit.getDefaultToolkit().getImage("img/Achievementreward.png");			//�B����V
		Image Mon_ex = Toolkit.getDefaultToolkit().getImage("img/ArlauneExplanation.png");				//�����X�^�[�����e�L�X�g
		Image Comp_rate_T = Toolkit.getDefaultToolkit().getImage("img/Completerate_Title.png");			//�R���v���[�g��(�^�C�g��)


	public void paintComponent(Graphics g) {
			super.paintComponent(g);

			///////////
			//�`��
			///////////

			g.drawImage(Back, 0, 0,480,620, this);					//�w�i

			g.drawImage(book, -3, 0,480,620, this);					//�{


				if(page == 0) {
				g.drawImage(Comp_rate_T, 40, 60,180,50, this);		//�R���v���[�g��(�^�C�g��)
				g.drawImage(Achive_re_T, 260, 60,180,50, this);		//�B����V(�^�C�g��)
				g.drawImage(Achive_re, 225, 120,300,360, this);		//�B����V
				}
				
				else if(page != 0) {
				if(Mon[2*(page-1)].getCapture() == 1) {
				g.drawImage(img[2*(page-1)], 40, 90,480/3,620/3, this);}			//�����X�^�[
				else{g.drawImage(question, 40, 140,150,150, this);}//�͂Ă�
				
				g.drawImage(Mess_win, 18, 350,210,130, this);		//���b�Z�[�W�E�B���h�E(��)
				g.drawImage(Mon_ex, 30, 370,190,100, this);			//�����X�^�[�����e�L�X�g
				g.drawImage(Mess_win, 480/2, 350,210,130, this);	//���b�Z�[�W�E�B���h�E(�E)

				if(Mon[2*(page-1)+1].getCapture() == 1) {
					g.drawImage(img[2*(page-1)+1], 260, 90,480/3,620/3, this);}			//�����X�^�[
					else{g.drawImage(question, 275, 140,150,150, this);}//�͂Ă�
				g.drawImage(Mess_win, 18, 350,210,130, this);		//���b�Z�[�W�E�B���h�E(��)
				//g.drawImage(Mon_ex, 30, 370,190,100, this);			//�����X�^�[�����e�L�X�g
				g.drawImage(Mess_win, 480/2, 350,210,130, this);	//���b�Z�[�W�E�B���h�E(�E)
			}

			}
		}



