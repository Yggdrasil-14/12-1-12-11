package encount;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class EncountLayout extends JPanel{
	public String name;
	public EncountLayout(String name) {
		
		this.name = name;
		
	}
	
	
		public void paintComponent(Graphics g) {

			
//			int random = (int)(Math.random()*4);//�����X�^�[�̐�4�Ђ�
//			switch(random) {
//
//			case 0:
//				name = "�I���`";
//			break;
//
//			case 1:
//				name = "���C���{�[�X���C��";;
//			break;
//
//			case 2:
//				name = "���b�h�C�[�O��";;
//			break;
//
//			case 3:
//				name = "�V���E�T�M";;
//			break;
//			}
			Image grass = Toolkit.getDefaultToolkit().getImage("img/Grass.png");
			Image cat = Toolkit.getDefaultToolkit().getImage("src/charactor/Material/" + name + ".png");
			super.paintComponent(g);

			g.drawImage(grass, 0, 0, 480,620,this);
			//grass.setBounds();
			g.drawImage(cat, 200, 50,480/3,620/3, this);
		}


		public String getName() {return name;}
		public void setName(String name) {this.name = name;}


	}


