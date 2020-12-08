package title;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMain extends JFrame {
	public void startWindow() {

		//setDefaultCloseOperation(EXIT_ON_CLOSE);//閉じる�タンの処�
		setSize(600,620);//ウィンドウサイズ
		setLocationRelativeTo(null);//画面中央に配置
		setResizable(false);//リサイズ禁止
		setVisible(true);//ウィンドウ表示
		setDefaultCloseOperation(EXIT_ON_CLOSE);//閉じる�タンの処�

		JLabel label = new JLabel("start!!!");

		    JPanel p = new JPanel();
		    p.add(label);

		    Container contentPane = getContentPane();
		    contentPane.add(p, BorderLayout.NORTH);
	}
}