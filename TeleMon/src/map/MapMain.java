package map;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	int vertical,horizontal;
	
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
	
	public void openMap() {
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
		System.out.println("false");
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
		
		if(encountJudge()) JOptionPane.showMessageDialog(null, "Encount!!");;
	}
}