package library;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import character.Character;


public class LibraryMain extends JFrame implements ActionListener{
	final String back = "back";			//�y�[�W�߂�
	final String forward = "forward";//�y�[�W�߂���
	final String GoHome = "GoHome";
	final String favoriteL = "favoriteL";
	final String favoriteR = "favoriteR";
	int FavoriteMonster;
	LibraryDraw LD;
	JButton btn4,btn5;

		public LibraryMain(String title, int width, int height,Character[] ms) {
			super(title);

			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(width,height);
			setLocationRelativeTo(null);

			LD=new LibraryDraw(ms);
			//LB=new LibraryBack();
			LD.setBounds(0,0,480,620);
			//LB.setBounds(0,0,480,620);
			LD.setOpaque(true);
			Container contentPane = getContentPane();

			JLayeredPane pane = new JLayeredPane();

			JButton btn1 = new JButton("��");	//�߂�{�^��
			JButton btn2 = new JButton("��");	//�i�ރ{�^��
			JButton btn3 = new JButton("�z�[��");
			btn4 = new JButton("��");
			btn5 = new JButton("��");


			btn1.setActionCommand(back);
			btn1.addActionListener(this);		//�{�^���������ꂽ
			btn2.setActionCommand(forward);
            btn2.addActionListener(this);
            btn3.setActionCommand(GoHome);
            btn3.addActionListener(this);
            btn4.setActionCommand(favoriteL);
            btn4.addActionListener(this);
            btn5.setActionCommand(favoriteR);
            btn5.addActionListener(this);
            //contentPane.setLayout(null);		//�����ňʒu�ݒ肷��Ȃ�null������



            btn1.setBounds(25,520,80,20);		//�߂�{�^��
			btn2.setBounds(365,520,80,20);		//�i�ރ{�^��
			btn3.setBounds(25,550,80,30);
			btn4.setBounds(25,315,80,30);
			btn5.setBounds(245,315,80,30);

			pane.add(btn1);
			pane.add(btn2);
			pane.add(btn3);
			
			
			pane.add(btn4);
			pane.add(btn5);
			btn4.setVisible(false);
			btn5.setVisible(false);

			pane.setLayer(btn1, 50);
			pane.setLayer(btn2, 51);
			pane.setLayer(btn3, 51);
			pane.setLayer(btn4, 51);
			pane.setLayer(btn5, 51);

			pane.add(LD);
			pane.setLayer(LD, 42);

			contentPane.add(pane);

		}

		public void actionPerformed(ActionEvent event){

			String cmd = event.getActionCommand();

			/*�y�[�W�؂�ւ�*/
			if(cmd.equals(back)) {					//�߂�{�^���N���b�N��LD.page���f�N�������g
				LD.setVisible(false);
				if(LD.page>0) {LD.page--;}
				System.out.println(LD.page);		//�{�^�����������ƃR���\�[���ɕ����\��
				LD.setVisible(true);
				}
			else if(cmd.equals(forward)) {			//�i�ރ{�^���N���b�N��LD.page���C���N�������g
				LD.setVisible(false);
				if(LD.page<6) {LD.page++;}
				System.out.println(LD.page);		//�{�^�����������ƃR���\�[���ɕ����\��
				LD.setVisible(true);
				}
			else if(LD.page == 7){}
			else if(cmd.equals(GoHome)) {
				main.Main.OpenH();
				this.setVisible(false);
					}
			if(LD.page==0) {
				btn4.setVisible(false);
				btn5.setVisible(false);
			}else {
				btn4.setVisible(true);
				btn5.setVisible(true);
			}
			
			if(cmd.equals(favoriteL)) {					
				LD.setVisible(false);
				switch(2*(LD.page-1)) {
				case 0:
					FavoriteMonster=0;
					break;
				case 2:
					FavoriteMonster=2;
					break;
				case 4:
					FavoriteMonster=4;
					break;
				case 6:
					FavoriteMonster=6;
					break;
				case 8:
					FavoriteMonster=8;
					break;
				case 10:
					FavoriteMonster=10;
					break;
				
				}
				
				
				System.out.println("FavoriteMonster:"+FavoriteMonster);		//���C�ɓ��胂���X�^�[�ԍ��\��
				LD.setVisible(true);
				}
			
			if(cmd.equals(favoriteR)) {					//�߂�{�^���N���b�N��LD.page���f�N�������g
				LD.setVisible(false);
				switch(2*(LD.page-1)+1) {
				case 1:
					FavoriteMonster=1;
					break;
				case 3:
					FavoriteMonster=3;
					break;
				case 5:
					FavoriteMonster=5;
					break;
				case 7:
					FavoriteMonster=7;
					break;
				case 9:
					FavoriteMonster=9;
					break;
				case 11:
					FavoriteMonster=11;
					break;
				
				}
				
				
				System.out.println("FavoriteMonster:"+FavoriteMonster);		//���C�ɓ��胂���X�^�[�ԍ��\��
				LD.setVisible(true);
				}
		}

}