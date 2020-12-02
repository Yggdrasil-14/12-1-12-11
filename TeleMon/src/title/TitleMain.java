package title;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class TitleMain extends JFrame implements ActionListener{

	JFrame mainFrame = new JFrame("タイトル");

public void TitleM(){

		 mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);//閉じるボタンの処理
		 mainFrame.setSize(600,620);//ウィンドウサイズ
		 mainFrame.setLocationRelativeTo(null);//画面中央に配置
		 mainFrame.setResizable(false);//リサイズ禁止


		 Container contentPane = mainFrame.getContentPane();
							// ラベルのインスタンスを生成
							JLabel label = new JLabel("title");
							label.setHorizontalAlignment(SwingConstants.CENTER);
							// ボタンのインスタンスを生成
							JButton button = new JButton("Press here...");
              button.addActionListener(this);

						 // ラベルをContentPaneに配置
						 contentPane.add(label, BorderLayout.CENTER);
						 // ボタンをContentPaneに配置
						 contentPane.add(button, BorderLayout.SOUTH);

						 mainFrame.setVisible(true);//ウィンドウ表示

}

public void halo(){

	System.out.println("ハローー");

}


public void actionPerformed1(ActionEvent event){

mainFrame.setVisible(false);
StartMain Sframe = new StartMain();//インスタンス化

Sframe.startWindow();


}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO 自動生成されたメソッド・スタブ

}

}

