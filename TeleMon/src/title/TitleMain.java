package title;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TitleMain extends JFrame implements ActionListener{
	public void OpenTitle() {
		this.setTitle("ƒeƒŒ‚à‚ñ");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(480,620);
		this.setLocationRelativeTo(null);
		this.setResizable(false);


		TitleDraw TD = new TitleDraw();
		TD.setBounds(0,0,480,620);
		Container contentPane = getContentPane();

		JButton btn1 = new JButton("GAME START!!");
		btn1.addActionListener(this);
		//contentPane.setLayout(null);
		//btn1.setBounds(150,570,300,30);
		contentPane.add(btn1, BorderLayout.SOUTH);
		contentPane.add(TD);

	}

	public void actionPerformed(ActionEvent event){
		System.out.println("bottn press");
		main.Main.OpenH();

		}




}



