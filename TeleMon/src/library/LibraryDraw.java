package library;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.AlphaComposite;
import java.awt.Color;

import javax.swing.JPanel;

	public class LibraryDraw extends JPanel{
		//�摜���[�h(�{)
		Image book = Toolkit.getDefaultToolkit().getImage("img/Library.png");
		//Image blackfade = Toolkit.getDefaultToolkit().getImage("img/blackfade.png");
		//�摜���[�h(�����X�^�[)
		Image mon1 = Toolkit.getDefaultToolkit().getImage("img/�A�����E�l1.png");
		//�摜���[�h(�͂Ă�)
		Image question = Toolkit.getDefaultToolkit().getImage("img/UnKnown.png");
		
		Color col = new Color(0,255,255,100);
		
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
		
			//Graphics2D g2 = (Graphics2D)g;
			
			//AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f);
			//g2.setComposite(ac);
			
			//�{�`��
			g.drawImage(book, 0, 0,480,620, this);
			g.drawImage(mon1, 0, 50,480/2,620/2, this);
			g.drawImage(question, 480-230, 120,200,200, this);
			
			//�t�F�[�h�C��
			//g2.drawImage(blackfade,0,0,480,620,this);

		}
	}

