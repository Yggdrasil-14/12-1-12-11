package map;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import character.Character;
import data.Save;
import bait.Bait;
import data.Save;
import encount.EncountFrame;

public class MapMain extends JFrame implements ActionListener {
	public static final int initialPositionVertical=3; 
	public static final int initialPositionHorizontal=9;
	
	public static final String direction[]= {"↓","↑","→","←"};
	
	int mapJudge[][]= {
			{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
			{-1, 3, 3, 3, 3, 3, 0, 0 ,0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1,-1},
			{-1, 3, 3, 3, 3, 3, 0, 0 ,0, 4, 4, 0, 0, 0, 1, 1, 1, 1, 1,-1},
			{-1, 3, 3, 3, 3, 3, 0, 0 ,0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1,-1},
			{-1, 3, 3, 3, 3, 3, 0, 0 ,0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1,-1},
			{-1, 3, 3, 3, 3, 3, 0, 0 ,0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1,-1},
			{-1, 3, 3, 3, 3, 3, 0, 0 ,0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1,-1},
			{-1, 3, 3, 3, 3, 3, 0, 0 ,0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1,-1},
			{-1, 3, 3, 3, 3, 3, 0, 0 ,0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1,-1},
			{-1, 3, 3, 3, 3, 3, 0, 0 ,0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1,-1},
			{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1, 0,-1,-1,-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,-1,-1},
			{-1,-1,-1,-1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,-1,-1},
			{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
	};
	private int vertical,horizontal;
	public int randomvalue = 0;
	
	static EncountFrame EF;
	
	Character ms[]=new Character[Save.cl];
	Bait[] ba = new Bait[Save.bl];
	MapDraw draw;
	
	JLayeredPane pane;
	Container contentPane;
	JButton btn[]=new JButton[4];
	
	public MapMain() {
		vertical=initialPositionVertical;
		horizontal=initialPositionHorizontal;
		
		this.setTitle("MyTitle");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(480,640);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void openMap(Character c[],Bait b[]) {
		String data[] = new String[Save.ec];
		for (int i = 0; i < Save.cl; i++) {
			data[0] = c[i].getName();
			data[1] = Integer.toString(c[i].getCapture());
			data[2] = Integer.toString(c[i].getPartner());
			data[3] = Integer.toString(c[i].getAppearPlace());
			data[4] = Integer.toString(c[i].getLikability());
			data[5] = Integer.toString(c[i].getRequiredLikabilityToGet());
			data[6] = Integer.toString(c[i].getFriendship());
			data[7] = Integer.toString(c[i].getLimitOfReceiveBait());
			data[8] = Integer.toString(c[i].getIncreaseValueOfReceiveBait0());
			data[9] = Integer.toString(c[i].getIncreaseValueOfReceiveBait1());
			data[10] = Integer.toString(c[i].getIncreaseValueOfReceiveBait2());
			data[11] = Integer.toString(c[i].getIncreaseValueOfReceiveBait3());
			data[12] = Integer.toString(c[i].getIncreaseValueOfReceiveBait4());
			data[13] = Integer.toString(c[i].getIncreaseValueOfReceiveBait5());
			ms[i] = new Character(data);
		}
		
		for (int i = 0; i < 6; i++) data[i] = b[0].getName(i);
		for (int i = 0; i < 6; i++) data[i + 6] = Integer.toString(b[0].getNumberOfBait(i));
		for (int i = 0; i < 4; i++) data[i + 12] = Integer.toString(b[0].getCompleteBonus(i));
		ba[0] = new Bait(data);
		
		draw=new MapDraw();
		draw.setBounds(0,0,480,640);
		
		pane=new JLayeredPane();
		contentPane=getContentPane();
		pane.setLayer(draw,10);
		contentPane.add(pane);
		
		btn[0]=new JButton("↓");
		btn[1]=new JButton("↑");
		btn[2]=new JButton("→");
		btn[3]=new JButton("←");
		
		for(int i=0;i<4;i++) {
			btn[i].setActionCommand(direction[i]);
			btn[i].addActionListener(this);
		}
		
		btn[0].setBounds(200,580,80,20);
		btn[1].setBounds(200,520,80,20);
		btn[2].setBounds(260,550,80,20);
		btn[3].setBounds(140,550,80,20);
		
		for(int i=0;i<4;i++) {
			pane.add(btn[i]);
			pane.setLayer(btn[i],20);
		}
		pane.add(draw);
	}
	
	//進めるか判定
	public boolean moveJudge(int direction) {
		//direction=1:↓ 2:↑ 3:→ 4:←
		if(direction==1&&mapJudge[vertical+1][horizontal]!=-1) return true;
		if(direction==2&&mapJudge[vertical-1][horizontal]!=-1) return true;
		if(direction==3&&mapJudge[vertical][horizontal+1]!=-1) return true;
		if(direction==4&&mapJudge[vertical][horizontal-1]!=-1) return true;
		return false;
	}
	
	//進める
	public void move(int direction) {
		if(direction==1) vertical++;
		else if(direction==2) vertical--;
		else if(direction==3) horizontal++;
		else if(direction==4) horizontal--;
	}
	
	//エンカウントするか判定
	public boolean encountJudge() {
		if(!(1<=mapJudge[vertical][horizontal]&&mapJudge[vertical][horizontal]<=3)) return false;
		Random rand=new Random();
		if(rand.nextInt(10)!=0) return false;
		return true;
	}
	
	//エンカウントモンスター決定
	public int MonRan(int place) {
		int random = 0;
		if (place == 1) random = (int) (Math.random() * 5);
		if (place == 2) random = (int) (Math.random() * 4 + 5);
		if (place == 3) random = (int) (Math.random() * 3 + 9);
		return random;
	}
	
	//アクションイベント
	public void actionPerformed(ActionEvent e) {
		//contentPane.doLayout();
		String cmd=e.getActionCommand();
		
		for(int i=0;i<4;i++) {
			if(cmd.equals(direction[i])) {
				draw.setDirection(i+1);
				if(!moveJudge(i+1)) {
					repaint();
					return;
				}
				if(i==0) {
					vertical++;
					draw.minusY();
				}
				else if(i==1) {
					vertical--;
					draw.plusY();
				}
				else if(i==2) {
					horizontal++;
					draw.minusX();
				}
				else if(i==3) {
					horizontal--;
					draw.plusX();
				}
				//draw.printXY();
			}
		}
		repaint();
		
		if(mapJudge[vertical][horizontal]==4) {
			JOptionPane.showMessageDialog(null, "Go Home!");
			main.Main.OpenH(ms,ba);
			this.setVisible(false);
		}
		
		if(encountJudge()) {
			JOptionPane.showMessageDialog(null, "Encount!!");
			EF = new EncountFrame(ms, ba);
			randomvalue = MonRan(mapJudge[vertical][horizontal]);
			EF.OpenEncount(randomvalue,mapJudge[vertical][horizontal]);
			this.setVisible(false);
			EF.setVisible(true);
		}
	}
}