package encount;


	import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import setting.MonsterSet;

	public class EncountFrame extends JFrame implements ActionListener{
		public void OpenEncount() {
			this.setTitle("ëêå¥ÉGÉäÉA");
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(480,620);
			this.setLocationRelativeTo(null);
			this.setResizable(false);

			JLayeredPane pane = new JLayeredPane();
			EncountLayout EL = new EncountLayout();
			EL.setBounds(0,0,480,620);
			MonsterSet MS = new MonsterSet();
			MS.setBounds(200,100,100,100);
			MS.setOpaque(true);
			Container contentPane = getContentPane();
			JButton btn1 = new JButton("GAME START!!");
			btn1.addActionListener(this);
			//contentPane.setLayout(null);
						//btn1.setBounds(150,570,300,30);
						//contentPane.add(btn1, BorderLayout.SOUTH);
			pane.add(EL);
			pane.setLayer(EL, 1);
			pane.add(MS);
			pane.setLayer(MS, 2);
			contentPane.add(pane);
			//contentPane.add(EL);


		}

		public void actionPerformed(ActionEvent event){
			System.out.println("bottn press");
			main.Main.OpenH();





			}
	}


