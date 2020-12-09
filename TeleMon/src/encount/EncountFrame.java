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
	public class EncountFrame extends JFrame implements ActionListener{

		public static final String run = "run";
		public static final String sweet ="sweet";
		public static final String bitter ="bitter";
		public static final String sour = "sour";
		public static final String astringent = "astringent";
		public static final String spicy = "spicy";
		public static final String delicious = "delicious";

		Character ch[] = new Character[Save.cl];
		Bait ba[] = new Bait[Save.bl];
		JLabel anc = new JLabel();
		int randomvalue =0;
		
		
		JLayeredPane pane;
		Container contentPane;
		JButton btn2;
		public EncountFrame(Character c[],Bait b[]) {
			String data[] = new String[Save.ec];
			for(int i=0;i<Save.cl;i++) {
			data[0] = c[i].getName();
			data[1] = Integer.toString(c[i].getCapture());
			data[2] = Integer.toString(c[i].getPartner());
			data[3] = Integer.toString(c[i].getAppearPlace());;
			data[4] = Integer.toString(c[i].getLikability());;
			data[5] = Integer.toString(c[i].getRequiredLikabilityToGet());;
			data[6] = Integer.toString(c[i].getFriendship());
			data[7] = Integer.toString(c[i].getLimitOfReceiveBait());
			data[8] = Integer.toString(c[i].getIncreaseValueOfReceiveBait0());
			data[9] = Integer.toString(c[i].getIncreaseValueOfReceiveBait1());
			data[10] = Integer.toString(c[i].getIncreaseValueOfReceiveBait2());
			data[11] = Integer.toString(c[i].getIncreaseValueOfReceiveBait3());
			data[12] = Integer.toString(c[i].getIncreaseValueOfReceiveBait4());
			data[13] = Integer.toString(c[i].getIncreaseValueOfReceiveBait5());
			ch[i] = new Character(data);
			}
			for(int i=0;i<6;i++) {
			data[i]=b[0].getName(i);}
			for(int i=0;i<6;i++) {
				data[i+6]=Integer.toString(b[0].getNumberOfBait(i));}
			for(int i=0;i<4;i++) {
				data[i+12]=Integer.toString(b[0].getCompleteBonus(i));}
			ba[0]=new Bait(data);
		}
		public void OpenEncount(int rand) {
	  //public void OpenEncount(Charactor c)
			randomvalue =rand;
			try {
			    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
			 } catch (Exception e) {
			            e.printStackTrace();
			 }

			this.setTitle("草原エリア");
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(480,620);
			this.setLocationRelativeTo(null);
			this.setResizable(false);

			EncountLayout EL = new EncountLayout(ch[rand].getName());
			EL.setBounds(0,0,480,620);
			pane = new JLayeredPane();
			JLabel label = new JLabel(ch[rand].getName());
			label.setBounds(280,250,300,30);
			label.setFont(new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.ITALIC, 20));
	        label.setForeground(Color.BLACK);//MonsterNameColor


			anc.setBounds(20,５,300,50);
			anc.setBackground(Color.PINK);
			anc.setFont(new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.ITALIC, 20));
	        anc.setForeground(Color.BLACK);//AnnounceColor

			 contentPane = getContentPane();

			JButton btn1 = new JButton("run");
			 btn2 = new JButton("甘い"+"x"+ba[0].getNumberOfBait(0));
			JButton btn3 = new JButton("苦い");
			JButton btn4 = new JButton("すっぱい");
			JButton btn5 = new JButton("渋い");
			JButton btn6 = new JButton("辛い");
			JButton btn7 = new JButton("虹");

			btn2.setBackground(Color.PINK);
			btn3.setBackground(Color.GREEN);
			btn4.setBackground(Color.YELLOW);
			btn5.setBackground(Color.LIGHT_GRAY);
			btn6.setBackground(Color.RED);
			btn7.setBackground(Color.WHITE);

//			btn2.setOpaque(true);
//			btn2.setBorderPainted(false);

			btn1.setActionCommand(run);
			btn1.addActionListener(this);
			btn2.setActionCommand(sweet);
			btn2.addActionListener(this);
			btn3.setActionCommand(bitter);
            btn3.addActionListener(this);
            btn4.setActionCommand(sour);
			btn4.addActionListener(this);
			btn5.setActionCommand(astringent);
			btn5.addActionListener(this);
			btn6.setActionCommand(spicy);
			btn6.addActionListener(this);
			btn7.setActionCommand(delicious);
			btn7.addActionListener(this);


			btn1.setBounds(60,540,80,50);
			btn2.setBounds(160,540,90,20);
			btn3.setBounds(260,540,90,20);
			btn4.setBounds(360,540,90,20);
			btn5.setBounds(160,570,90,20);
			btn6.setBounds(260,570,90,20);
			btn7.setBounds(360,570,90,20);

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
//			TimerTask task = new TimerTask() {
//	        	@Override
//
//			public void run() {
//				System.out.println("aaa");
//				timer.cancel();
//			}
//	        };
//	        timer.schedule(task,5000);
	        ///////////////////////////////////////////////////////////
		}

		public void actionPerformed(ActionEvent event){
			String cmd = event.getActionCommand();

			if(cmd.equals(run)) {
				if(ch[randomvalue].getRequiredLikabilityToGet()<=ch[randomvalue].getLikability()) {
					ch[randomvalue].setCapture();
					JOptionPane.showMessageDialog(null,"get!!");
					JOptionPane.showMessageDialog(null,"get All polock(x2) bonus!!");
					ba[0].monsterGetBonus();
				}
				else {
				Random randomValue=new Random();
				int rand=randomValue.nextInt(100);
				int probabilityOfGet=100*ch[randomvalue].getLikability()/ch[randomvalue].getRequiredLikabilityToGet()*4/5;
				if(probabilityOfGet>rand) {
					ch[randomvalue].setCapture();
					JOptionPane.showMessageDialog(null,"kakuritu-get");
					JOptionPane.showMessageDialog(null,"get All polock(x2) bonus!!");
					ba[0].monsterGetBonus();
				}
				}
				ch[randomvalue].resetLikability();
				main.Main.OpenH(ch,ba);
				Home.CloseE();}

			else if(cmd.equals(sweet)) {
				if(ba[0].getNumberOfBait(0)>0) {
		    anc.setText("sweetを投げた！！！");
		    
		    ba[0].useBait(0);
		    btn2.setText("甘い"+"x"+ba[0].getNumberOfBait(0));
		    pane.add(btn2);
		    
		    ch[randomvalue].increaseLikability(0);
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Timer timer = new Timer(false);
		    TimerTask task = new TimerTask() {
		    	//@Override

		    	public void run() {
		    		anc.setText("");;
		    	timer.cancel();
		    	}
		    	};
		    	timer.schedule(task,2000);
				}else {JOptionPane.showMessageDialog(null,"Empty!!");}
			}


			else if(cmd.equals(bitter)) {
				if(ba[0].getNumberOfBait(1)>0) {
			    anc.setText("bitterを投げた！！！");
			    ba[0].useBait(1);
			    ch[randomvalue].increaseLikability(1);
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Timer timer = new Timer(false);
			    TimerTask task = new TimerTask() {
			    	@Override

			    	public void run() {
			    		anc.setText("");;
			    	timer.cancel();
			    	}
			    	};
			    	timer.schedule(task,2000);
			}else {JOptionPane.showMessageDialog(null,"Empty!!");}
				}
			else if(cmd.equals(sour)) {
				if(ba[0].getNumberOfBait(3)>0) {
			    anc.setText("sourを投げた！！！");
			    ba[0].useBait(3);
			    ch[randomvalue].increaseLikability(3);
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Timer timer = new Timer(false);
			    TimerTask task = new TimerTask() {
			    	@Override

			    	public void run() {
			    		anc.setText("");;
			    	timer.cancel();
			    	}
			    	};
			    	timer.schedule(task,2000);
			}else {JOptionPane.showMessageDialog(null,"Empty!!");}
				}
			else if(cmd.equals(astringent)) {
				if(ba[0].getNumberOfBait(4)>0) {
			    anc.setText("astringentを投げた！！！");
			    ba[0].useBait(4);
			    ch[randomvalue].increaseLikability(4);
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Timer timer = new Timer(false);
			    TimerTask task = new TimerTask() {
			    	@Override

			    	public void run() {
			    		anc.setText("");;
			    	timer.cancel();
			    	}
			    	};
			    	timer.schedule(task,2000);
			}else {JOptionPane.showMessageDialog(null,"Empty!!");}
				}
			else if(cmd.equals(spicy)) {
				if(ba[0].getNumberOfBait(2)>0) {
			    anc.setText("spicyを投げた！！！");
			    ba[0].useBait(2);
			    ch[randomvalue].increaseLikability(2);
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Timer timer = new Timer(false);
			    TimerTask task = new TimerTask() {
			    	@Override

			    	public void run() {
			    		anc.setText("");;
			    	timer.cancel();
			    	}
			    	};
			    	timer.schedule(task,2000);
				}else {JOptionPane.showMessageDialog(null,"Empty!!");}
				}
			else if(cmd.equals(delicious)) {
				if(ba[0].getNumberOfBait(5)>0) {
			    anc.setText("deliciousを投げた！！！");
			    ba[0].useBait(5);
			    ch[randomvalue].increaseLikability(5);
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
				Timer timer = new Timer(false);
			    TimerTask task = new TimerTask() {
			    	@Override

			    	public void run() {
			    		anc.setText("");;
			    	timer.cancel();
			    	}
			    	};
			    	timer.schedule(task,2000);
			    	}else {JOptionPane.showMessageDialog(null,"Empty!!");}
				}

			}
	}


