package encount;


	import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;

	public class EncountFrame extends JFrame implements ActionListener{

		public static final String run = "run";
		public static final String sweet ="sweet";
		public static final String bitter ="bitter";
		public static final String sour = "sour";
		public static final String astringent = "astringent";
		public static final String spicy = "spicy";
		public static final String delicious = "delicious";
		
		
		JLabel anc = new JLabel();
		
		
		public void OpenEncount() {
	  //public void OpenEncount(Charactor c)
			try {
			    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
			 } catch (Exception e) {
			            e.printStackTrace();
			 }
			
			String name =null;
			
			this.setTitle("草原エリア");
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(480,620);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			int random = (int)(Math.random()*4);//モンスターの数4ひき
			switch(random) {

			case 0:
				name = "オロチ";
			break;

			case 1:
				name = "フォックステール";
			break;

			case 2:
				name = "レッドイーグル";
			break;

			case 3:
				name = "シロウサギ";
			break;
			}
			EncountLayout EL = new EncountLayout(name);
			EL.setBounds(0,0,480,620);
			JLayeredPane pane = new JLayeredPane();
			JLabel label = new JLabel(name);
			label.setBounds(280,250,300,30);
			label.setFont(new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.ITALIC, 20));
	        label.setForeground(Color.BLUE);
	       

			anc.setBounds(20,５,300,50);
			anc.setBackground(Color.PINK);
			anc.setFont(new Font("HGP創英角ﾎﾟｯﾌﾟ体", Font.ITALIC, 20));
	        anc.setForeground(Color.BLUE);
			
			Container contentPane = getContentPane();

			JButton btn1 = new JButton("run");
			JButton btn2 = new JButton("甘い");
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
		main.Main.OpenH();}
			else if(cmd.equals(sweet)) {
		    anc.setText("sweetを投げた！！！");
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
			}
				

			else if(cmd.equals(bitter)) {
			    anc.setText("bitterを投げた！！！");
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
				}
			else if(cmd.equals(sour)) {
			    anc.setText("sourを投げた！！！");
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
				}
			else if(cmd.equals(astringent)) {
			    anc.setText("astringentを投げた！！！");
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
				}
			else if(cmd.equals(spicy)) {
			    anc.setText("spicyを投げた！！！");
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
				}
			else if(cmd.equals(delicious)) {
			    anc.setText("deliciousを投げた！！！");
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
				}

			}
	}


