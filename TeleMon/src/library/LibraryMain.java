package library;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import character.Character;
import data.Save;
import bait.Bait;

public class LibraryMain extends JFrame implements ActionListener{
	final String back = "back";			//ページ戻る
	final String forward = "forward";//ページめくる
	final String GoHome = "GoHome";
	final String favoriteL = "favoriteL";
	final String favoriteR = "favoriteR";
	LibraryDraw LD;
	JButton btn4,btn5;
	
	private int compCount,compRate;
	
	Character ms[]=new Character[Save.cl];
	Bait[] ba = new Bait[Save.bl];

		public LibraryMain(String title, int width, int height,Character c[]) {
			super(title);

			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(width,height);
			setLocationRelativeTo(null);
			
			String data[] = new String[Save.ec];
			for(int i=0;i<14;i++) data[i] = "0";
			for (int i = 0; i < Save.cl; i++) {
				data[0]=c[i].getName();
				ms[i] = new Character(data);
			}
			
			for (int i = 0; i < 6; i++) data[i] = "0";
			for (int i = 0; i < 6; i++) data[i + 6] = "0";
			for (int i = 0; i < 4; i++) data[i + 12] = "0";
			ba[0] = new Bait(data);
			
			LD=new LibraryDraw(ms);
			//LB=new LibraryBack();
			LD.setBounds(0,0,480,620);
			//LB.setBounds(0,0,480,620);
			LD.setOpaque(true);
			Container contentPane = getContentPane();

			JLayeredPane pane = new JLayeredPane();

			JButton btn1 = new JButton("←");	//戻るボタン
			JButton btn2 = new JButton("→");	//進むボタン
			JButton btn3 = new JButton("ホーム");
			btn4 = new JButton("★");
			btn5 = new JButton("★");


			btn1.setActionCommand(back);
			btn1.addActionListener(this);		//ボタンが押された
			btn2.setActionCommand(forward);
            btn2.addActionListener(this);
            btn3.setActionCommand(GoHome);
            btn3.addActionListener(this);
            btn4.setActionCommand(favoriteL);
            btn4.addActionListener(this);
            btn5.setActionCommand(favoriteR);
            btn5.addActionListener(this);
            //contentPane.setLayout(null);		//自分で位置設定するならnullを入れる

            btn1.setBounds(25,520,80,20);		//戻るボタン
			btn2.setBounds(365,520,80,20);		//進むボタン
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
		
		public void openLibrary(Character c[],Bait b[]) {
			compCount=0;
			for (int i = 0; Save.cl > i; i++) {
				ms[i].setName(c[i].getName());
				ms[i].setCapture(c[i].getCapture());
				ms[i].setPartner(c[i].getPartner());
				ms[i].setLikability(c[i].getLikability());
				ms[i].setRequiredLikabilityToGet(c[i].getRequiredLikabilityToGet());
				ms[i].setAppearPlace(c[i].getAppearPlace());
				ms[i].setFriendship(c[i].getFriendship());
				ms[i].setLimitOfReceiveBait(c[i].getLimitOfReceiveBait());
				ms[i].setLimitOfReceiveBaitForReset(c[i].getLimitOfReceiveBaitForReset());
				ms[i].setIncreaseValueOfReceiveBait(c[i].getIncreaseValueOfReceiveBait0(),
						c[i].getIncreaseValueOfReceiveBait1(), c[i].getIncreaseValueOfReceiveBait2(),
						c[i].getIncreaseValueOfReceiveBait3(), c[i].getIncreaseValueOfReceiveBait4(),
						c[i].getIncreaseValueOfReceiveBait5());
				if(c[i].getCapture()==1) compCount++;
			}
			for (int i = 0; i < 6; i++) {
				ba[0].setName(i, b[0].getName(i));
			}
			for (int i = 0; i < 6; i++) {
				ba[0].setNumberOfBait(i, b[0].getNumberOfBait(i));
			}
			for (int i = 0; i < 4; i++) {
				ba[0].setCompleteBonus(i, b[0].getCompleteBonus(i));
			}
			
			compRate = (compCount * 100) / Save.cl;
			ba[0].libraryCompleteBonus(compRate);
			
			LD.settingLibraryDraw(ms,compRate);
		}

		public void actionPerformed(ActionEvent event){

			String cmd = event.getActionCommand();

			/*ページ切り替え*/
			if(cmd.equals(back)) {					//戻るボタンクリックでLD.pageをデクリメント
				LD.setVisible(false);
				if(LD.page>0) {LD.page--;}
				System.out.println(LD.page);		//ボタンが押されるとコンソールに文字表示
				LD.setVisible(true);
				}
			else if(cmd.equals(forward)) {			//進むボタンクリックでLD.pageをインクリメント
				LD.setVisible(false);
				if(LD.page<6) {LD.page++;}
				System.out.println(LD.page);		//ボタンが押されるとコンソールに文字表示
				LD.setVisible(true);
				}
			else if(cmd.equals(GoHome)) {
				main.Main.OpenH(ms,ba);
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
				for(int i=0;i<12;i++) ms[i].setPartner(0);
				switch(2*(LD.page-1)) {
				case 0:
					ms[0].setPartner(1);
					break;
				case 2:
					ms[2].setPartner(1);
					break;
				case 4:
					ms[4].setPartner(1);
					break;
				case 6:
					ms[6].setPartner(1);
					break;
				case 8:
					ms[8].setPartner(1);
					break;
				case 10:
					ms[10].setPartner(1);
					break;
				
				}
				
				LD.setVisible(true);
			}
			
			if(cmd.equals(favoriteR)) {					//戻るボタンクリックでLD.pageをデクリメント
				LD.setVisible(false);
				for(int i=0;i<12;i++) ms[i].setPartner(0);
				switch(2*(LD.page-1)+1) {
				case 1:
					ms[1].setPartner(1);
					break;
				case 3:
					ms[3].setPartner(1);
					break;
				case 5:
					ms[5].setPartner(1);
					break;
				case 7:
					ms[7].setPartner(1);
					break;
				case 9:
					ms[9].setPartner(1);
					break;
				case 11:
					ms[11].setPartner(1);
					break;
				
				}
				
				LD.setVisible(true);
			}
		}

}