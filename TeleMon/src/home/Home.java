package home;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import bait.Bait;
import character.Character;
import data.Load;
import data.Save;
import time.Time;



public class Home extends JFrame implements ActionListener{

	public static final String search = "search";
	public static final String library = "library";
	public static final String polock = "polock";
	public static final String save = "save";

	Load ld = new Load();
	//Save sv = new Save();
	Character[] ms = new Character[Save.cl];
	Bait[] pr = new Bait[Save.bl];
	Time[] ti = new Time[Save.tl];
	//LibraryDraw[] ld = new LibraryDraw[Save.ll];
	String[][] str = new String[Save.tdl][Save.ec];
		public Home() {

			ld.load(str);
			storeData(str);
		}
		public void storeData(String[][] str) {
			//
			int j = 0;
			for(int i = 0;i<Save.tdl;i++) {
				//
				if(i==0||i==Save.cl||i==Save.cl+Save.bl||i==Save.cl+Save.bl+Save.tl) {j = 0;}
				//Monster
			if(i<Save.cl) {ms[j]=new Character(str[i]);j++;}
				//Porock
				if(Save.cl<=i&i<Save.cl+Save.bl) {pr[j]=new Bait(str[i]);j++;}
				//Time
				if(Save.cl+Save.bl<=i&i<Save.cl+Save.bl+Save.tl) {
					ti[j] = new Time(str[i]);j++;
				}
				//if(Save.ml+Save.pl+Save.tl<=i&i<Save.ml+Save.pl+Save.tl+Save.ll) {
					//ld[j] = new LibraryDraw(str[i]);j++;
				//}
			}
				//sv.save()
		}
		public void OpenHome() {
			this.setTitle("Home");
			ms[0].practice();
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(480,620);
			this.setLocationRelativeTo(null);
			this.setResizable(false);

			JLayeredPane pane = new JLayeredPane();
			HomeLayout HL = new HomeLayout();
			HL.setBounds(0,0,480,620);

			Container contentPane = getContentPane();

			JButton btn1 = new JButton("search");
			JButton btn2 = new JButton("library");
			JButton btn3 = new JButton("polock");
			JButton btn4 = new JButton("save");

			btn1.setActionCommand(search);
			btn1.addActionListener(this);
			btn2.setActionCommand(library);
            btn2.addActionListener(this);
            btn3.setActionCommand(polock);
            btn3.addActionListener(this);
            btn4.setActionCommand(save);
            btn4.addActionListener(this);


			btn1.setBounds(60,570,80,20);
			btn2.setBounds(150,570,80,20);
			btn3.setBounds(240,570,80,20);
			btn4.setBounds(330,570,80,20);

			pane.add(btn1);
			pane.add(btn2);
			pane.add(btn3);
			pane.add(btn4);
			pane.setLayer(btn1, 50);
			pane.setLayer(btn2, 51);
			pane.setLayer(btn3, 52);
			pane.setLayer(btn4, 53);
			pane.add(HL);
			pane.setLayer(HL, 42);
			contentPane.add(pane);

}


public void actionPerformed(ActionEvent event){

	String cmd = event.getActionCommand();

	if(cmd.equals(search)) {
System.out.println("press bottun");
int random = (int)(Math.random()*2);//モンスターの数4ひき
switch(random) {

case 0:
	JOptionPane.showMessageDialog(null, "モンスターが出現中！！");
	main.Main.OpenE();
break;

case 1:
	main.Main.OpenE();
break;}
}
	else if(cmd.equals(library)) {
		System.out.println("press bottun");
		main.Main.OpenL();}
	else if(cmd.equals(polock)) {
		JOptionPane.showMessageDialog(null, "polock");
		}
	else if(cmd.equals(save)) {
		JOptionPane.showMessageDialog(null, "セーブ中、、、");
		}
}
}

