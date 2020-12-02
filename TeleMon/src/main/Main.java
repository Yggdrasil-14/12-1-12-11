package main;




import javax.swing.JButton;

import title.TitleDraw;
import title.TitleMain;


public class Main {


  public static void main(String[] args) {

   TitleMain Tframe = new TitleMain("テストウィンドウ",480,620);//インスタンス化
   

	JButton btn1 = new JButton("探索");
	JButton btn2 = new JButton("図鑑");
	JButton btn3 = new JButton("探索");
	JButton btn4 = new JButton("セーブ");
	Tframe.setLayout(null);
	btn1.setBounds(10,10,80,30);
	btn2.setBounds(50,50,80,30);
	btn3.setBounds(100,100,80,30);
	btn4.setBounds(180,180,80,30);
	

   Tframe.add(btn1);
   Tframe.add(btn2);
   Tframe.add(btn3);
   Tframe.add(btn4);

   TitleDraw TD = new TitleDraw();
   TD.setBounds(0,0,480,620);
   //Tframe.add(TD);
   Tframe.setVisible(true);//ウィンドウ表示

   //Tframe.halo();
   //Lframe.OpenLib();
   // StartMain Sframe = new StartMain();//インスタンス化
   // Sframe.startWindow();
  }
}