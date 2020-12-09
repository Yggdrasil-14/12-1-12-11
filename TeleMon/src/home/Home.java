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
import encount.DesertFrame;
import encount.EncountFrame;
import encount.WatersideFrame;
import library.LibraryMain;
import time.Time;


public class Home extends JFrame implements ActionListener{

	public static final String search = "search";
	public static final String library = "library";
	public static final String polock = "polock";
	public static final String save = "save";
	public static final String Meadow = "Meadow";
	public static final String Waterside = "Waterside";
	public static final String Desert = "Desert";
	public int randomvalue = 0;

	 static EncountFrame EF;
	static WatersideFrame WF;
	 static DesertFrame DF;
	 static LibraryMain Lframe;

	Load ld = new Load();
	Save sv = new Save();
	Character[] ms = new Character[Save.cl];
	Bait[] ba = new Bait[Save.bl];
	Time[] ti = new Time[Save.tl];
	//LibraryDraw[] ld = new LibraryDraw[Save.ll];
	String[][] str = new String[Save.tdl][Save.ec];

		public Home() {

			ld.load(str);
			storeData(str);
		}
		public Home(int a) {;}
		public void storeData(String[][] str) {
			//
			int j = 0;
			for(int i = 0;i<Save.tdl;i++) {
				//
				if(i==0||i==Save.cl||i==Save.cl+Save.bl||i==Save.cl+Save.bl+Save.tl) {j = 0;}
				//Monster
				if(i<Save.cl) {ms[j]=new Character(str[i]);j++;}
				//Porock
				if(Save.cl<=i&i<Save.cl+Save.bl) {ba[j]=new Bait(str[i]);j++;}
				//Time
				if(Save.cl+Save.bl<=i&i<Save.cl+Save.bl+Save.tl) {
					ti[j] = new Time(str[i]);j++;
				}
				//if(Save.ml+Save.pl+Save.tl<=i&i<Save.ml+Save.pl+Save.tl+Save.ll) {
					//ld[j] = new LibraryDraw(str[i]);j++;
				//}
			}
//			sv.save(ms,ba,ti);
		}
		public void OpenHome() {
			this.setTitle("Home");

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
			JButton btn5 = new JButton("Meadow");
			JButton btn6 = new JButton("Waterside");
			JButton btn7 = new JButton("Desert");

			btn1.setActionCommand(search);
			btn1.addActionListener(this);
			btn2.setActionCommand(library);
            		btn2.addActionListener(this);
            		btn3.setActionCommand(polock);
            		btn3.addActionListener(this);
            		btn4.setActionCommand(save);
            		btn4.addActionListener(this);
			btn5.setActionCommand(Meadow);
            		btn5.addActionListener(this);
            		btn6.setActionCommand(Waterside);
            		btn6.addActionListener(this);
            		btn7.setActionCommand(Desert);
            		btn7.addActionListener(this);


			btn1.setBounds(60,570,80,20);
			btn2.setBounds(150,570,80,20);
			btn3.setBounds(240,570,80,20);
			btn4.setBounds(330,570,80,20);
			btn5.setBounds(150,540,80,20);
			btn6.setBounds(240,540,80,20);
			btn7.setBounds(330,540,80,20);

			pane.add(btn1);
			pane.add(btn2);
			pane.add(btn3);
			pane.add(btn4);
			pane.add(btn5);
			pane.add(btn6);
			pane.add(btn7);
			pane.setLayer(btn1, 50);
			pane.setLayer(btn2, 51);
			pane.setLayer(btn3, 52);
			pane.setLayer(btn4, 53);
			pane.setLayer(btn5, 51);
			pane.setLayer(btn6, 52);
			pane.setLayer(btn7, 53);
			pane.add(HL);
			pane.setLayer(HL, 42);
			contentPane.add(pane);

}
		public void OpenHome(Character ch[],Bait b[]) {
			for(int i = 0 ; Save.cl>i ;i++) {
				ms[i].setName(ch[i].getName());
				ms[i].setCapture(ch[i].getCapture());
				ms[i].setPartner(ch[i].getPartner());
				ms[i].setLikability(ch[i].getLikability());
				ms[i].setRequiredLikabilityToGet(ch[i].getRequiredLikabilityToGet());
				ms[i].setAppearPlace(ch[i].getAppearPlace());
				ms[i].setFriendship(ch[i].getFriendship());
				ms[i].setLimitOfReceiveBait(ch[i].getLimitOfReceiveBait());
				ms[i].setIncreaseValueOfReceiveBait(ch[i].getIncreaseValueOfReceiveBait0(),
						ch[i].getIncreaseValueOfReceiveBait1(),ch[i].getIncreaseValueOfReceiveBait2(),
						ch[i].getIncreaseValueOfReceiveBait3(),ch[i].getIncreaseValueOfReceiveBait4(),
						ch[i].getIncreaseValueOfReceiveBait5());

			}
			for(int i =0;i<6;i++) {
			ba[0].setName(i,b[0].getName(i));
			}
			for(int i =0;i<6;i++) {
			ba[0].setNumberOfBait(i,b[0].getNumberOfBait(i));
			}
			for(int i =0;i<4;i++) {
			ba[0].setCompleteBonus(i,b[0].getCompleteBonus(i));
				}

			this.setTitle("Home");

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
			JButton btn5 = new JButton("Meadow");
			JButton btn6 = new JButton("Waterside");
			JButton btn7 = new JButton("Desert");

			btn1.setActionCommand(search);
			btn1.addActionListener(this);
			btn2.setActionCommand(library);
            		btn2.addActionListener(this);
            		btn3.setActionCommand(polock);
            		btn3.addActionListener(this);
            		btn4.setActionCommand(save);
            		btn4.addActionListener(this);
            		btn5.setActionCommand(Meadow);
            		btn5.addActionListener(this);
            		btn6.setActionCommand(Waterside);
            		btn6.addActionListener(this);
            		btn7.setActionCommand(Desert);
            		btn7.addActionListener(this);


			btn1.setBounds(60,570,80,20);
			btn2.setBounds(150,570,80,20);
			btn3.setBounds(240,570,80,20);
			btn4.setBounds(330,570,80,20);
			btn5.setBounds(150,540,80,20);
			btn6.setBounds(240,540,80,20);
			btn7.setBounds(330,540,80,20);

			pane.add(btn1);
			pane.add(btn2);
			pane.add(btn3);
			pane.add(btn4);
			pane.add(btn5);
			pane.add(btn6);
			pane.add(btn7);
			pane.setLayer(btn1, 50);
			pane.setLayer(btn2, 51);
			pane.setLayer(btn3, 52);
			pane.setLayer(btn4, 53);
			pane.setLayer(btn5, 51);
			pane.setLayer(btn6, 52);
			pane.setLayer(btn7, 53);
			pane.add(HL);
			pane.setLayer(HL, 42);
			contentPane.add(pane);
}

public void actionPerformed(ActionEvent event){

	String cmd = event.getActionCommand();

	if(cmd.equals(search)) {
System.out.println("search");
//int random = (int)(Math.random()*2);
//switch(random) {
//case 0:
	//JOptionPane.showMessageDialog(null, "銉€兂銈广偪銉笺亴搴鐝句腑技");
	JOptionPane.showMessageDialog(null,"search");

//break;

//case 1:
	//main.Main.CloseH();
//break;}
}
	else if(cmd.equals(library)) {
		System.out.println("library");
		 Lframe = new LibraryMain("ZUKAN",480,620,ms);
		Lframe.setVisible(true);
		main.Main.CloseH();
		}
	else if(cmd.equals(polock)) {
		JOptionPane.showMessageDialog(null, "polock");
		}
	else if(cmd.equals(save)) {
		JOptionPane.showMessageDialog(null, "s");
		sv.save(ms,ba,ti);
		}
	else if(cmd.equals(Meadow)) {
		JOptionPane.showMessageDialog(null, "m");
		EF = new EncountFrame(ms,ba);
		randomvalue = MonRan(1);
		EF.OpenEncount(randomvalue);
		main.Main.CloseH();
		EF.setVisible(true);
		}
	else if(cmd.equals(Waterside)) {
		JOptionPane.showMessageDialog(null, "w");
		WF = new WatersideFrame();
		randomvalue = MonRan(2);
		WF.OpenWaterside(ms[randomvalue]);
		main.Main.CloseH();
		WF.setVisible(true);
		}
	else if(cmd.equals(Desert)) {
		JOptionPane.showMessageDialog(null, "d");
		DF = new DesertFrame();
		randomvalue = MonRan(3);
		DF.OpenDesert(ms[randomvalue]);
		main.Main.CloseH();
		DF.setVisible(true);
		}
}

	public int MonRan(int d) {
		int random = 0;
		if(d == 1) {
		random = (int)(Math.random()*5);}
		if(d == 2) {
		random = (int)(Math.random()*4 +5);}
		if(d == 3) {
		random = (int)(Math.random()*3 +9);
		}
		return random;

		}
	public static void CloseE() {
		EF.setVisible(false);
//		if(capture == 1) {ms[randomvalue].setCapture();}
		}
	public static void CloseW() {WF.setVisible(false);}
	public static void CloseD() {DF.setVisible(false);}
	public static void CloseL() {Lframe.setVisible(false);}
	}





