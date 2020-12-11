package map;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import bait.Bait;
import character.Character;
import data.Save;
import encount.EncountFrame;

public class MapMain extends JFrame implements ActionListener {
	public static final int initialPositionVertical=3;
	public static final int initialPositionHorizontal=9;
	public static final int initialDirection=1;

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
	private int vertical,horizontal,directions;
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
		directions=initialDirection;
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		String data[] = new String[Save.ec];
		for(int i=0;i<14;i++) data[i] = "0";
		for (int i = 0; i < Save.cl; i++) ms[i] = new Character(data);

		for (int i = 0; i < 6; i++) data[i] = "0";
		for (int i = 0; i < 6; i++) data[i + 6] = "0";
		for (int i = 0; i < 4; i++) data[i + 12] = "0";
		ba[0] = new Bait(data);

		this.setTitle("探索");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(480,640);
		this.setLocationRelativeTo(null);

		pane=new JLayeredPane();
		contentPane=getContentPane();
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


		draw=new MapDraw();
		pane.add(draw);
		for(int i=0;i<4;i++) {
			pane.add(btn[i]);
			pane.setLayer(btn[i],20);
		}
	}

	public void openMap(Character c[],Bait b[],int vertical,int horizontal,int directions) {
		this.vertical=vertical;
		this.horizontal=horizontal;
		this.directions=directions;

		for (int i = 0; Save.cl > i; i++) {
			ms[i].setName(c[i].getName());
			ms[i].setCapture(c[i].getCapture());
			ms[i].setPartner(c[i].getPartner());
			ms[i].setLikability(c[i].getLikability());
			ms[i].setRequiredLikabilityToGet(c[i].getRequiredLikabilityToGet());
			ms[i].setAppearPlace(c[i].getAppearPlace());
			ms[i].setFriendship(c[i].getFriendship());
			ms[i].setLimitOfReceiveBait(c[i].getLimitOfReceiveBait());
			ms[i].setLimitOfReceiveBaitForReset(c[i].getLimitOfReceiveBaitForReset());
			ms[i].setIncreaseValueOfReceiveBait(c[i].getIncreaseValueOfReceiveBait0(),
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

		draw.settingMapDraw(vertical,horizontal,directions);
		draw.setBounds(0,0,480,640);

		pane.setLayer(draw,10);
		contentPane.add(pane);
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
				directions=i+1;
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
			JOptionPane.showMessageDialog(null, "ホームに戻ります");
			main.Main.OpenH(ms,ba);
			this.setVisible(false);
		}

		if(encountJudge()) {
			JOptionPane.showMessageDialog(null, "モンスターを発見!");
			EF = new EncountFrame(ms,ba);
			randomvalue = MonRan(mapJudge[vertical][horizontal]);
			EF.OpenEncount(ms,ba,randomvalue,mapJudge[vertical][horizontal],vertical,horizontal,directions);
			this.setVisible(false);
			EF.setVisible(true);
		}
	}
}