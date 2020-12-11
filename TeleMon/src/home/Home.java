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
import encount.EncountFrame;
import library.LibraryMain;
import map.MapMain;
import time.Time;

public class Home extends JFrame implements ActionListener {

	public static final String search = "search";
	public static final String library = "library";
	public static final String polock = "polock";
	public static final String save = "save";
	
	static EncountFrame EF;
	static LibraryMain Lframe;
	static MapMain map;
	
	JButton btn1,btn2,btn3,btn4;
	JLayeredPane pane;
	HomeLayout HL;

	Load ld = new Load();
	Save sv = new Save();
	Character[] ms = new Character[Save.cl];
	Bait[] ba = new Bait[Save.bl];
	Time[] ti = new Time[Save.tl];
	// LibraryDraw[] ld = new LibraryDraw[Save.ll];
	String[][] str = new String[Save.tdl][Save.ec];
	private int partner;
	
	Container contentPane;
	
	public Home() {
		this.partner=-1;
		ld.load(str);
		storeData(str);
		for(int i=0;i<Save.cl;i++) ms[i].increaseFriendshipOverTime(ti[0].getDifferenceValue());
		ba[0].increaseBait(ti[0].getDifferenceValue());
		
		HL = new HomeLayout(); 
		pane=new JLayeredPane();
		contentPane = getContentPane();
		Lframe = new LibraryMain("図鑑", 480, 620,ms);
		map=new MapMain();
		EF=new EncountFrame(ms,ba);
		
		btn1 = new JButton("探索");
		btn2 = new JButton("図鑑");
		btn3 = new JButton("虹ポロック");
		btn4 = new JButton("セーブ");
		
		btn1.setActionCommand(search);
		btn1.addActionListener(this);
		btn2.setActionCommand(library);
		btn2.addActionListener(this);
		btn3.setActionCommand(polock);
		btn3.addActionListener(this);
		btn4.setActionCommand(save);
		btn4.addActionListener(this);

		btn1.setBounds(80, 510, 150, 30);
		btn2.setBounds(240, 510, 150, 30);
		btn3.setBounds(80, 550, 150, 30);
		btn4.setBounds(240, 550, 150, 30);

		pane.add(btn1);
		pane.add(btn2);
		pane.add(btn3);
		pane.add(btn4);
		pane.setLayer(btn1, 50);
		pane.setLayer(btn2, 51);
		pane.setLayer(btn3, 52);
		pane.setLayer(btn4, 53);
	}

	public Home(int a) {
		;
	}

	public void storeData(String[][] str) {
		//
		int j = 0;
		for (int i = 0; i < Save.tdl; i++) {
			//
			if (i == 0 || i == Save.cl || i == Save.cl + Save.bl || i == Save.cl + Save.bl + Save.tl) {
				j = 0;
			}
			// Monster
			if (i < Save.cl) {
				ms[j] = new Character(str[i]);
				j++;
			}
			// Porock
			if (Save.cl <= i & i < Save.cl + Save.bl) {
				ba[j] = new Bait(str[i]);
				j++;
			}
			// Time
			if (Save.cl + Save.bl <= i & i < Save.cl + Save.bl + Save.tl) {
				ti[j] = new Time(str[i]);
				j++;
			}
			// if(Save.ml+Save.pl+Save.tl<=i&i<Save.ml+Save.pl+Save.tl+Save.ll) {
			// ld[j] = new LibraryDraw(str[i]);j++;
			// }
		}
		for(int i=0;i<12;i++) {
			if(ms[i].getPartner()==1) {
				partner=i;
				break;
			}
		}
	}

	public void OpenHome() {
		this.setTitle("Home");

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(480, 620);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		if(partner!=-1) HL.setPartnerName(ms[partner].getName());
		HL.setBounds(0, 0, 480, 620);

		pane.add(HL);
		pane.setLayer(HL, 42);
		
		contentPane.add(pane);
	}

	public void OpenHome(Character ch[], Bait b[]) {
		for (int i = 0; Save.cl > i; i++) {
			ms[i].setName(ch[i].getName());
			ms[i].setCapture(ch[i].getCapture());
			ms[i].setPartner(ch[i].getPartner());
			ms[i].setLikability(ch[i].getLikability());
			ms[i].setRequiredLikabilityToGet(ch[i].getRequiredLikabilityToGet());
			ms[i].setAppearPlace(ch[i].getAppearPlace());
			ms[i].setFriendship(ch[i].getFriendship());
			ms[i].setLimitOfReceiveBait(ch[i].getLimitOfReceiveBait());
			ch[i].setLimitOfReceiveBaitForReset(ch[i].getLimitOfReceiveBaitForReset());
			ms[i].setIncreaseValueOfReceiveBait(ch[i].getIncreaseValueOfReceiveBait0(),
					ch[i].getIncreaseValueOfReceiveBait1(), ch[i].getIncreaseValueOfReceiveBait2(),
					ch[i].getIncreaseValueOfReceiveBait3(), ch[i].getIncreaseValueOfReceiveBait4(),
					ch[i].getIncreaseValueOfReceiveBait5());
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
		for(int i=0;i<12;i++) {
			if(ms[i].getPartner()==1) {
				partner=i;
				break;
			}
		}
		if(partner!=-1) HL.setPartnerName(ms[partner].getName()); 

		this.setTitle("Home");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(480, 620);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		HL.setBounds(0, 0, 480, 620);

		pane = new JLayeredPane();
		
		pane.add(HL);
		pane.setLayer(HL, 42);
		
		contentPane.add(pane);
	}

	public void actionPerformed(ActionEvent event) {

		String cmd = event.getActionCommand();

		if (cmd.equals(search)) {
			map.openMap(ms,ba,MapMain.initialPositionVertical,MapMain.initialPositionHorizontal,MapMain.initialDirection);
			map.setVisible(true);
			this.setVisible(false);
		} else if (cmd.equals(library)) {
			Lframe.openLibrary(ms,ba);
			Lframe.setVisible(true);
			this.setVisible(false);
		} else if (cmd.equals(polock)) {
			if(partner==-1) return;
			int option = JOptionPane.showConfirmDialog(this, "ポロックが欲しそうに見ている\nポロックをあげますか？(残り:"+ba[0].getNumberOfBait(5)+"個)",
				      "", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.YES_OPTION){
				
				if (ba[0].getNumberOfBait(5) > 0) {
					ba[0].useBait(5);
					ms[partner].increaseFriendshipOverBait(5);
					JOptionPane.showMessageDialog(null, "ポロックをあげた\n喜んでいるようだ！");
				} else {
					JOptionPane.showMessageDialog(null, "虹色ポロックがなくなってしまった...");
				}
			}else if (option == JOptionPane.NO_OPTION){
					JOptionPane.showMessageDialog(null, "");
			}
		} else if (cmd.equals(save)) {
			JOptionPane.showMessageDialog(null, "セーブしました");
			sv.save(ms, ba, ti);
		}
	}

	public static void CloseL() {
		Lframe.setVisible(false);
	}
	
	public static void OpenM(Character ch[], Bait ba[],int vertical,int horizontal,int directions) {
		EF.setVisible(false);
		map.openMap(ch,ba,vertical,horizontal,directions);
		map.setVisible(true);
	}
}
