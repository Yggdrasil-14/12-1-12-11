package encount;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import bait.Bait;
import character.Character;
import data.Save;
import home.Home;
import map.MapMain;

public class EncountFrame extends JFrame implements ActionListener {

	public static final String run = "run";
	public static final String sweet = "sweet";
	public static final String bitter = "bitter";
	public static final String sour = "sour";
	public static final String astringent = "astringent";
	public static final String spicy = "spicy";
	public static final String delicious = "delicious";

	Character ch[] = new Character[Save.cl];
	Bait ba[] = new Bait[Save.bl];
	MapMain map;
	JLabel anc = new JLabel();
	int randomvalue = 0;
	private int vertical,horizontal,directions;
	private int receive;

	JLayeredPane pane;
	Container contentPane;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JButton btn7;

	public EncountFrame(Character c[], Bait b[]) {
		String data[] = new String[Save.ec];
		for(int i=0;i<14;i++) data[i] = "0";
		for (int i = 0; i < Save.cl; i++) ch[i] = new Character(data);
		
		for (int i = 0; i < 6; i++) data[i] = "0";
		for (int i = 0; i < 6; i++) data[i + 6] = "0";
		for (int i = 0; i < 4; i++) data[i + 12] = "0";
		ba[0] = new Bait(data);
	}

	public void OpenEncount(Character c[],Bait b[],int rand,int place,int vertical,int horizontal,int directions) {
		this.vertical=vertical;
		this.horizontal=horizontal;
		this.directions=directions;
		this.randomvalue = rand;
		this.receive=0;
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; Save.cl > i; i++) {
			ch[i].setName(c[i].getName());
			ch[i].setCapture(c[i].getCapture());
			ch[i].setPartner(c[i].getPartner());
			ch[i].setLikability(c[i].getLikability());
			ch[i].setRequiredLikabilityToGet(c[i].getRequiredLikabilityToGet());
			ch[i].setAppearPlace(c[i].getAppearPlace());
			ch[i].setFriendship(c[i].getFriendship());
			ch[i].setLimitOfReceiveBait(c[i].getLimitOfReceiveBait());
			ch[i].setLimitOfReceiveBaitForReset(c[i].getLimitOfReceiveBaitForReset());
			ch[i].setIncreaseValueOfReceiveBait(c[i].getIncreaseValueOfReceiveBait0(),
					c[i].getIncreaseValueOfReceiveBait1(), c[i].getIncreaseValueOfReceiveBait2(),
					c[i].getIncreaseValueOfReceiveBait3(), c[i].getIncreaseValueOfReceiveBait4(),
					c[i].getIncreaseValueOfReceiveBait5());
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
		System.out.println(ch[randomvalue].getLimitOfReceiveBait());
		ch[randomvalue].setLimitOfReceiveBait();
		System.out.println(ch[randomvalue].getLimitOfReceiveBait());

		if(place==1) this.setTitle("草原エリア");
		else if(place==2) this.setTitle("水辺エリア");
		else if(place==3) this.setTitle("砂漠エリア");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(480, 620);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		EncountLayout EL = new EncountLayout(ch[rand].getName(),place);
		EL.setBounds(0, 0, 480, 620);
		pane = new JLayeredPane();
		JLabel label = new JLabel(ch[rand].getName());
		label.setBounds(280, 250, 300, 30);
		label.setFont(new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.ITALIC, 20));
		label.setForeground(Color.BLACK);// MonsterNameColor

		anc.setBounds(20, ５, 300, 50);
		anc.setBackground(Color.PINK);
		anc.setFont(new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.ITALIC, 20));
		anc.setForeground(Color.BLACK);// AnnounceColor

		contentPane = getContentPane();

		btn1 = new JButton("退散");
		btn2 = new JButton("甘い" + "x" + ba[0].getNumberOfBait(0));
		btn3 = new JButton("苦い" + "x" + ba[0].getNumberOfBait(1));
		btn4 = new JButton("辛い" + "x" + ba[0].getNumberOfBait(2));
		btn5 = new JButton("すっぱい" + "x" + ba[0].getNumberOfBait(3));
		btn6 = new JButton("渋い" + "x" + ba[0].getNumberOfBait(4));
		btn7 = new JButton("虹" + "x" + ba[0].getNumberOfBait(5));

		btn2.setBackground(Color.PINK);
		btn3.setBackground(Color.GREEN);
		btn4.setBackground(Color.RED);
		btn5.setBackground(Color.YELLOW);
		btn6.setBackground(Color.LIGHT_GRAY);
		btn7.setBackground(Color.WHITE);

//		btn2.setOpaque(true);
//		btn2.setBorderPainted(false);

		btn1.setActionCommand(run);
		btn1.addActionListener(this);
		btn2.setActionCommand(sweet);
		btn2.addActionListener(this);
		btn3.setActionCommand(bitter);
		btn3.addActionListener(this);
		btn4.setActionCommand(spicy);
		btn4.addActionListener(this);
		btn5.setActionCommand(sour);
		btn5.addActionListener(this);
		btn6.setActionCommand(astringent);
		btn6.addActionListener(this);
		btn7.setActionCommand(delicious);
		btn7.addActionListener(this);

		btn1.setBounds(10, 530, 80, 50);
		btn2.setBounds(100, 530, 110, 20);
		btn3.setBounds(220, 530, 110, 20);
		btn4.setBounds(340, 530, 110, 20);
		btn5.setBounds(100, 560, 110, 20);
		btn6.setBounds(220, 560, 110, 20);
		btn7.setBounds(340, 560, 110, 20);

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
		pane.add(label);
		pane.setLayer(label, 60);
		pane.add(anc);
		pane.setLayer(anc, 60);
		pane.add(EL);
		pane.setLayer(EL, 42);
		contentPane.add(pane);

		///////////////////////////////////////////////////////////
//		TimerTask task = new TimerTask() {
//	       	@Override
//
//			public void run() {
//				System.out.println("aaa");
//				timer.cancel();
//			}
//		};
//		timer.schedule(task,5000);
		///////////////////////////////////////////////////////////
	}
	
	public void actionPerformed(ActionEvent event) {
		String cmd = event.getActionCommand();

		if (cmd.equals(run)) {
//			if (ch[randomvalue].getRequiredLikabilityToGet() <= ch[randomvalue].getLikability()) {
//				
//				ch[randomvalue].setCapture();
//				JOptionPane.showMessageDialog(null, "get!!");
//				JOptionPane.showMessageDialog(null, "get All polock(x2) bonus!!");
//				ba[0].monsterGetBonus();
//			} else {
//				Random randomValue = new Random();
//				int rand = randomValue.nextInt(100);
//				int probabilityOfGet = 100 * ch[randomvalue].getLikability()
//						/ ch[randomvalue].getRequiredLikabilityToGet() * 4 / 5;
//				if (probabilityOfGet > rand) {
//					ch[randomvalue].setCapture();
//					JOptionPane.showMessageDialog(null, "kakuritu-get");
//					JOptionPane.showMessageDialog(null, "get All polock(x2) bonus!!");
//					ba[0].monsterGetBonus();
//				}
//			}
			if (ch[randomvalue].getRequiredLikabilityToGet() <= ch[randomvalue].getLikability()) {
				ch[randomvalue].setCapture();
				int option = JOptionPane.showConfirmDialog(this, "仲間になりたそうにこちらをみている。\n仲間にしますか？",
					      "", JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION){
				JOptionPane.showMessageDialog(null, "モンスターをゲットした！！\n情報が図鑑に登録されます！");
				JOptionPane.showMessageDialog(null, "ゲットボーナスでポロックを２個ずつゲット！");
				ba[0].monsterGetBonus();}
				else if (option == JOptionPane.NO_OPTION){
					JOptionPane.showMessageDialog(null, "この場を立ち去った。");}
			} else {
				Random randomValue = new Random();
				int rand = randomValue.nextInt(100);
				int probabilityOfGet = 100 * ch[randomvalue].getLikability()
						/ ch[randomvalue].getRequiredLikabilityToGet() * 4 / 5;
				if (probabilityOfGet > rand) {
					ch[randomvalue].setCapture();
					int option = JOptionPane.showConfirmDialog(this, "仲間になりたそうにこちらをみている。\n仲間にしますか？",
						      "", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "モンスターをゲットした！！\n情報が図鑑に登録されます！");
					JOptionPane.showMessageDialog(null, "ゲットボーナスでポロックを２個ずつゲット！");
					ba[0].monsterGetBonus();}
					else if (option == JOptionPane.NO_OPTION){
						JOptionPane.showMessageDialog(null, "この場を立ち去った。");}
				}
			}
			ch[randomvalue].resetLimitOfReceiveBait();
			ch[randomvalue].resetLikability();
			home.Home.OpenM(ch, ba, vertical, horizontal, directions);
			this.setVisible(false);
		}

		else if (cmd.equals(sweet)) {
			
			if(ch[randomvalue].getLimitOfReceiveBait()==receive) {
				JOptionPane.showMessageDialog(null, "ポロックに興味を示さなかった...");
				return;
			}
			if (ba[0].getNumberOfBait(0) > 0) {
				anc.setText("sweetを投げた！！！");
				ba[0].useBait(0);
				receive++;
				btn2.setText("甘い" + "x" + ba[0].getNumberOfBait(0));
				pane.add(btn2);

				ch[randomvalue].increaseLikability(0);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Timer timer = new Timer(false);
				TimerTask task = new TimerTask() {
					// @Override
					public void run() {
						anc.setText("");
						timer.cancel();
					}
				};
				timer.schedule(task, 2000);
			} else {
				JOptionPane.showMessageDialog(null, "Sweet Porock Empty!!");
			}
		}

		else if (cmd.equals(bitter)) {
			if(ch[randomvalue].getLimitOfReceiveBait()==receive) {
				JOptionPane.showMessageDialog(null, "ポロックに興味を示さなかった...");
				return;
			}
			if (ba[0].getNumberOfBait(1) > 0) {
				anc.setText("bitterを投げた！！！");
				ba[0].useBait(1);
				receive++;
				btn3.setText("苦い" + "x" + ba[0].getNumberOfBait(1));
				pane.add(btn3);
				
				ch[randomvalue].increaseLikability(1);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Timer timer = new Timer(false);
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						anc.setText("");
						timer.cancel();
					}
				};
				timer.schedule(task, 2000);
			} else {
				JOptionPane.showMessageDialog(null, "Bitter Porock Empty!!");
			}
		}
		
		else if (cmd.equals(sour)) {
			if(ch[randomvalue].getLimitOfReceiveBait()==receive) {
				JOptionPane.showMessageDialog(null, "ポロックに興味を示さなかった...");
				return;
			}
			if (ba[0].getNumberOfBait(3) > 0) {
				anc.setText("sourを投げた！！！");
				ba[0].useBait(3);
				receive++;
				btn5.setText("すっぱい" + "x" + ba[0].getNumberOfBait(3));
				pane.add(btn5);
				
				ch[randomvalue].increaseLikability(3);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Timer timer = new Timer(false);
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						anc.setText("");
						timer.cancel();
					}
				};
				timer.schedule(task, 2000);
			} else {
				JOptionPane.showMessageDialog(null, "Sour Porock Empty!!");
			}
		}
		
		else if (cmd.equals(astringent)) {
			if(ch[randomvalue].getLimitOfReceiveBait()==receive) {
				JOptionPane.showMessageDialog(null, "ポロックに興味を示さなかった...");
				return;
			}
			if (ba[0].getNumberOfBait(4) > 0) {
				anc.setText("astringentを投げた！！！");
				ba[0].useBait(4);
				receive++;
				btn6.setText("渋い" + "x" + ba[0].getNumberOfBait(4));
				pane.add(btn6);
				
				ch[randomvalue].increaseLikability(4);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Timer timer = new Timer(false);
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						anc.setText("");
						timer.cancel();
					}
				};
				timer.schedule(task, 2000);
			} else {
				JOptionPane.showMessageDialog(null, "Astringent Porock Empty!!");
			}
		}
		
		else if (cmd.equals(spicy)) {
			if(ch[randomvalue].getLimitOfReceiveBait()==receive) {
				JOptionPane.showMessageDialog(null, "ポロックに興味を示さなかった...");
				return;
			}
			if (ba[0].getNumberOfBait(2) > 0) {
				anc.setText("spicyを投げた！！！");
				ba[0].useBait(2);
				receive++;
				btn4.setText("辛い" + "x" + ba[0].getNumberOfBait(2));
				pane.add(btn4);
				
				ch[randomvalue].increaseLikability(2);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Timer timer = new Timer(false);
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						anc.setText("");
						timer.cancel();
					}
				};
				timer.schedule(task, 2000);
			} else {
				JOptionPane.showMessageDialog(null, "Spicy Porock Empty!!");
			}
		}
		
		else if (cmd.equals(delicious)) {
			if(ch[randomvalue].getLimitOfReceiveBait()==receive) {
				JOptionPane.showMessageDialog(null, "ポロックに興味を示さなかった...");
				return;
			}
			if (ba[0].getNumberOfBait(5) > 0) {
				anc.setText("deliciousを投げた！！！");
				ba[0].useBait(5);
				receive++;
				btn7.setText("虹" + "x" + ba[0].getNumberOfBait(5));
				pane.add(btn7);
				
				ch[randomvalue].increaseLikability(5);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Timer timer = new Timer(false);
				TimerTask task = new TimerTask() {
					@Override
					public void run() {
						anc.setText("");
						timer.cancel();
					}
				};
				timer.schedule(task, 2000);
			} else {
				JOptionPane.showMessageDialog(null, "Delicious Porock Empty!!");
			}
		}

	}
}
