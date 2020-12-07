package library;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class LibraryMain extends JFrame implements ActionListener{
	final String back = "back";			//ページ戻る
	final String forward = "forward";   //ページめくる
	LibraryDraw LD;
	
		public LibraryMain(String title, int width, int height) {			
			super(title);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(width,height);
			setLocationRelativeTo(null);
			
			LD=new LibraryDraw();
			//LB=new LibraryBack();
			LD.setBounds(0,0,480,620);
			//LB.setBounds(0,0,480,620);
			LD.setOpaque(true);
			Container contentPane = getContentPane();
			
			JLayeredPane pane = new JLayeredPane();

			JButton btn1 = new JButton("←");	//戻るボタン
			JButton btn2 = new JButton("→");	//進むボタン
			

			
			btn1.setActionCommand(back);
			btn1.addActionListener(this);		//ボタンが押された
			btn2.setActionCommand(forward);
            btn2.addActionListener(this);
			//contentPane.setLayout(null);		//自分で位置設定するならnullを入れる
			

            
            btn1.setBounds(25,490,80,30);		//戻るボタン
			btn2.setBounds(365,490,80,30);		//進むボタン

			pane.add(btn1);
			pane.add(btn2);

			pane.setLayer(btn1, 50);
			pane.setLayer(btn2, 51);
			
			pane.add(LD);
			pane.setLayer(LD, 42);
			//pane.add(LB);
			//pane.setLayer(LB, 40);
			contentPane.add(pane);			
			
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
				if(LD.page<2) {LD.page++;}
				System.out.println(LD.page);		//ボタンが押されるとコンソールに文字表示
				LD.setVisible(true);
				}
		}

}