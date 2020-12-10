package title;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class TitleMain extends JFrame implements ActionListener {
	public void OpenTitle() {
		this.setTitle("ÉeÉåÇ‡ÇÒ!!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(480, 620);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		JLayeredPane pane = new JLayeredPane();

		TitleDraw TD = new TitleDraw();
		TD.setBounds(0, 0, 480, 620);
		pane.setLayer(TD, 49);
		Container contentPane = getContentPane();

		JButton btn1 = new JButton("Ç∞Å[ÇﬁÇ∑ÇΩÅ[Ç∆!!");
		btn1.addActionListener(this);
		// contentPane.setLayout(null);
		btn1.setBounds(480 / 5, 560, 300, 20);
		pane.add(btn1);
		pane.add(TD);
		pane.setLayer(btn1, 50);
		contentPane.add(pane);
	}

	public void actionPerformed(ActionEvent event) {
		main.Main.OpenH();
	}
}
