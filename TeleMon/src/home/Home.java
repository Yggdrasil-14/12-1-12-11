package home;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Home extends JFrame{

		public void OpenHome() {
			this.setTitle("Home");
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(480,620);
			this.setLocationRelativeTo(null);
			this.setResizable(false);

			HomeLayout HL = new HomeLayout();
			HL.setBounds(0,0,480,570);
			//LayeredPane.add(TD);

			Container contentPane = getContentPane();
			// ボタンのインスタンスを生成
			JButton btn1 = new JButton("探索");
			JButton btn2 = new JButton("図鑑");
			JButton btn3 = new JButton("ポロック");
			JButton btn4 = new JButton("セーブ");
//btn1.addActionListener(this);
			contentPane.setLayout(null);
		 // ラベルをContentPaneに配置


			contentPane.add(btn1);
			contentPane.add(btn2);
			contentPane.add(btn3);
			contentPane.add(btn4);
			contentPane.add(HL);

			btn1.setBounds(150,570,80,30);
			btn2.setBounds(60,570,80,30);
			btn3.setBounds(240,570,80,30);
			btn4.setBounds(330,570,80,30);

			validate();

}
		}

//public void actionPerformed(ActionEvent event){
//System.out.println("キーイベントです");
////mainFrame.setVisible(false);
////StartMain Sframe = new StartMain();//インスタンス化
//
////Sframe.startWindow();
//
////FrameMain frame = new FrameMain();//インスタンス化
//
//
//}


