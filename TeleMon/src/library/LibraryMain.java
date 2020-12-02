package library;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LibraryMain {

	JFrame mainFrame = new JFrame("図鑑");

	public void OpenLib() {

		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);//閉じるボタンの処理
		 mainFrame.setSize(600,620);//ウィンドウサイズ
		 mainFrame.setLocationRelativeTo(null);//画面中央に配置
		 mainFrame.setResizable(false);//リサイズ禁止


		 Container contentPane = mainFrame.getContentPane();
							// ラベルのインスタンスを生成
							JLabel label = new JLabel("Library");
							label.setHorizontalAlignment(SwingConstants.CENTER);
							// ボタンのインスタンスを生成
							JButton button = new JButton("Press here...");


						 // ラベルをContentPaneに配置
						 contentPane.add(label, BorderLayout.CENTER);
						 // ボタンをContentPaneに配置
						 contentPane.add(button, BorderLayout.SOUTH);

						 mainFrame.setVisible(true);//ウィンドウ表示



	}


}
