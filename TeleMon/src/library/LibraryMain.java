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
	LibraryDraw LD;

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
			JButton btn3 = new JButton("Home");


			btn1.setActionCommand(back);
			btn1.addActionListener(this);		//�{�^���������ꂽ
			btn2.setActionCommand(forward);
            btn2.addActionListener(this);
            btn3.setActionCommand(GoHome);
            btn3.addActionListener(this);
            //contentPane.setLayout(null);		//�����ňʒu�ݒ肷��Ȃ�null������



            btn1.setBounds(25,490,80,30);		//�߂�{�^��
			btn2.setBounds(365,490,80,30);		//�i�ރ{�^��
			btn3.setBounds(25,550,80,50);

			pane.add(btn1);
			pane.add(btn2);
			pane.add(btn3);

			pane.setLayer(btn1, 50);
			pane.setLayer(btn2, 51);
			pane.setLayer(btn3, 51);

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
				home.Home.CloseL();
					}
		}

}