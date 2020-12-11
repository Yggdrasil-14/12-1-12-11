package library;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import character.Character;
import data.Save;

public class LibraryDraw extends JPanel {

	Character Mon[] = new Character[Save.cl];

	Image N[] = new Image[13];
	Image Mon_Ex[] = new Image[Save.cl];
	Image MonImg[] = new Image[Save.cl];
	int[] FriendShip = new int[Save.cl];
	Image Heart[] = new Image[5];
	Image HeartSpace[] = new Image[5];

	int Comprate, Compcount;

	public LibraryDraw(Character c[]) {
		String data[] = new String[Save.ec];
		for(int i=0;i<14;i++) data[i] = "0";
		for (int i = 0; i < Save.cl; i++) {
			data[0]=c[i].getName();
			Mon[i] = new Character(data);
			
			MonImg[i] = Toolkit.getDefaultToolkit().getImage("src/character/Material/" + data[0] + ".png");
			Mon_Ex[i] = Toolkit.getDefaultToolkit().getImage("img/Monster_Ex_" + (i + 1) + ".png");
			if (Mon[i].getCapture() == 1) Compcount++;
		}
		
		Comprate = (Compcount * 100) / Save.cl;

		for (int i = 0; i < 10; i++) {
			String s = Integer.toString(i);
			N[i] = Toolkit.getDefaultToolkit().getImage("img/" + s + ".png"); // ナンバー
			// System.out.println("img/"+i+".png");
		}

		for (int i = 0; i < 5; i++) {
			Heart[i] = Toolkit.getDefaultToolkit().getImage("img/Heart.png");
			HeartSpace[i] = Toolkit.getDefaultToolkit().getImage("img/HeartSpace.png");
		}

	}

	public void settingLibraryDraw(Character c[],int comprate) {
		for (int i = 0; Save.cl > i; i++) {
			Mon[i].setName(c[i].getName());
			Mon[i].setCapture(c[i].getCapture());
			Mon[i].setPartner(c[i].getPartner());
			Mon[i].setLikability(c[i].getLikability());
			Mon[i].setRequiredLikabilityToGet(c[i].getRequiredLikabilityToGet());
			Mon[i].setAppearPlace(c[i].getAppearPlace());
			Mon[i].setFriendship(c[i].getFriendship());
			Mon[i].setLimitOfReceiveBait(c[i].getLimitOfReceiveBait());
			Mon[i].setIncreaseValueOfReceiveBait(c[i].getIncreaseValueOfReceiveBait0(),
					c[i].getIncreaseValueOfReceiveBait1(), c[i].getIncreaseValueOfReceiveBait2(),
					c[i].getIncreaseValueOfReceiveBait3(), c[i].getIncreaseValueOfReceiveBait4(),
					c[i].getIncreaseValueOfReceiveBait5());
			FriendShip[i] = c[i].getFriendship();
		}
		Comprate=comprate;
	}

	public static int page = 0;

	///////////
	// 画像ロード
	///////////

	Image book = Toolkit.getDefaultToolkit().getImage("img/Library.png"); // 本
	Image Back = Toolkit.getDefaultToolkit().getImage("img/Background.jpg"); // 背景
	Image question = Toolkit.getDefaultToolkit().getImage("img/UnKnown.png"); // はてな
	Image Mess_win = Toolkit.getDefaultToolkit().getImage("img/Messagewindow.png"); // メッセージウィンドウ
	Image Achive_re_T = Toolkit.getDefaultToolkit().getImage("img/Achievementreward_Title.png"); // 達成報酬(タイトル)
	Image Achive_re = Toolkit.getDefaultToolkit().getImage("img/Achievementreward.png"); // 達成報酬
	Image Comp_rate_T = Toolkit.getDefaultToolkit().getImage("img/Completerate_Title.png"); // コンプリート率(タイトル)
	Image No = Toolkit.getDefaultToolkit().getImage("img/No.png"); // ナンバー（No.）
	Image Percent = Toolkit.getDefaultToolkit().getImage("img/Percent.png"); // コンプリート率表示(%)
	Image Comp_rate_line = Toolkit.getDefaultToolkit().getImage("img/Comprateunder.png");
	Image Hanamaru = Toolkit.getDefaultToolkit().getImage("img/Hanamaru.png"); // はなまる
	Image AllPolocks = Toolkit.getDefaultToolkit().getImage("img/AllPolocks.png"); // すべてのポロック
	Image kakeru = Toolkit.getDefaultToolkit().getImage("img/×.png"); // 達成報酬(×)

	// Image HeartSpace =
	// Toolkit.getDefaultToolkit().getImage("img/HeartSpace.png");

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		///////////
		// 描画
		///////////

		int No_digit_1; // 図鑑ナンバー表示1桁目
		int No_digit_2; // 図鑑ナンバー表示2桁目

		int Comp_digit_1; // コンプリート率表示1桁目
		int Comp_digit_2; // コンプリート率表示2桁目
		int Comp_digit_3; // コンプリート率表示3桁目

		g.drawImage(Back, 0, 0, 480, 620, this); // 背景
		g.drawImage(book, 0, 0, 480, 620, this); // 本

		Comp_digit_3 = Comprate / 100;
		Comp_digit_2 = Comprate / 10;
		Comp_digit_1 = Comprate - Comp_digit_2 * 10;

		if (page == 0) {
			g.drawImage(Comp_rate_T, 40, 60, 180, 50, this); // コンプリート率(タイトル)
			g.drawImage(Achive_re_T, 260, 60, 180, 50, this); // 達成報酬(タイトル)
			g.drawImage(Achive_re, 225, 120, 300, 380, this); // 達成報酬

			g.drawImage(AllPolocks, 350, 120, 70, 70, this); // 報酬ポロック
			g.drawImage(kakeru, 380, 183, 35, 35, this); // 達成報酬(×)
			g.drawImage(N[2], 410, 187, 30, 30, this); // 報酬数

			g.drawImage(AllPolocks, 350, 220, 70, 70, this); // 報酬ポロック
			g.drawImage(kakeru, 380, 283, 35, 35, this); // 達成報酬(×)
			g.drawImage(N[5], 410, 287, 30, 30, this); // 報酬数

			g.drawImage(AllPolocks, 350, 320, 70, 70, this); // 報酬ポロック
			g.drawImage(kakeru, 380, 383, 35, 35, this); // 達成報酬(×)
			g.drawImage(N[7], 410, 387, 30, 30, this); // 報酬数

			g.drawImage(AllPolocks, 350, 420, 70, 70, this); // 報酬ポロック
			g.drawImage(kakeru, 380, 483, 35, 35, this); // 達成報酬(×)
			g.drawImage(N[1], 410, 487, 30, 30, this); // 報酬数
			g.drawImage(N[0], 430, 487, 30, 30, this); // 報酬数

			if (Comprate != 100) {
				g.drawImage(N[Comp_digit_1], 120, 240, 40, 60, this); // コンプリート率表示1桁目
				if (Comp_digit_2 != 0) {
					g.drawImage(N[Comp_digit_2], 80, 240, 40, 60, this); // コンプリート率表示2桁目
				}
				if (Comp_digit_3 != 0) {
					g.drawImage(N[Comp_digit_3], 40, 240, 40, 60, this); // コンプリート率表示3桁目
				}
			} else if (Comprate == 100) {
				g.drawImage(N[0], 120, 240, 40, 60, this); // コンプリート率表示1桁目
				g.drawImage(N[0], 80, 240, 40, 60, this); // コンプリート率表示2桁目
				g.drawImage(N[1], 40, 240, 40, 60, this); // コンプリート率表示3桁目
				g.drawImage(Hanamaru, 100, 100, 150, 150, this); // はなまる
			}
			g.drawImage(Percent, 160, 240, 40, 60, this); // コンプリート率表示(%)
			g.drawImage(Comp_rate_line, 20, 290, 220, 50, this); // コンプリート率のアンダーライン

		}

		else if (page != 0) {

			g.drawImage(Mess_win, 18, 350, 215, 130, this); // メッセージウィンドウ(左)

			if (Mon[2 * (page - 1)].getCapture() == 1) {
				g.drawImage(MonImg[2 * (page - 1)], 50, 130, 140, 180, this); // モンスター
				g.drawImage(Mon_Ex[2 * (page - 1)], 30, 380, 195, 80, this); // モンスター説明テキスト

				g.drawImage(HeartSpace[0], 20 + 110, 325, 20, 20, this);
				g.drawImage(HeartSpace[1], 20 * 2 + 110, 325, 20, 20, this);
				g.drawImage(HeartSpace[2], 20 * 3 + 110, 325, 20, 20, this);
				g.drawImage(HeartSpace[3], 20 * 4 + 110, 325, 20, 20, this);
				g.drawImage(HeartSpace[4], 20 * 5 + 110, 325, 20, 20, this);

				switch ((FriendShip[2 * (page - 1)]) / 20) {
				case 0:
					break;
				case 1:
					g.drawImage(Heart[0], 20 + 110, 325, 20, 20, this);
					break;
				case 2:
					g.drawImage(Heart[0], 20 + 110, 325, 20, 20, this);
					g.drawImage(Heart[1], 20 * 2 + 110, 325, 20, 20, this);
					break;
				case 3:
					g.drawImage(Heart[0], 20 + 110, 325, 20, 20, this);
					g.drawImage(Heart[1], 20 * 2 + 110, 325, 20, 20, this);
					g.drawImage(Heart[2], 20 * 3 + 110, 325, 20, 20, this);
					break;
				case 4:
					g.drawImage(Heart[0], 20 + 110, 325, 20, 20, this);
					g.drawImage(Heart[1], 20 * 2 + 110, 325, 20, 20, this);
					g.drawImage(Heart[2], 20 * 3 + 110, 325, 20, 20, this);
					g.drawImage(Heart[3], 20 * 4 + 110, 325, 20, 20, this);
					break;
				case 5:
					g.drawImage(Heart[0], 20 + 110, 325, 20, 20, this);
					g.drawImage(Heart[1], 20 * 2 + 110, 325, 20, 20, this);
					g.drawImage(Heart[2], 20 * 3 + 110, 325, 20, 20, this);
					g.drawImage(Heart[3], 20 * 4 + 110, 325, 20, 20, this);
					g.drawImage(Heart[4], 20 * 5 + 110, 325, 20, 20, this);
					break;
				}

			} else {
				g.drawImage(question, 40, 140, 150, 150, this);
			} // はてな

			g.drawImage(No, 20, 70, 60, 30, this); // ナンバー（No.）

			No_digit_1 = (2 * (page - 1) + 1) % 10;
			No_digit_2 = (2 * (page - 1) + 1) / 10;
			g.drawImage(N[No_digit_1], 105, 70, 35, 35, this); // 図鑑ナンバー1桁目の数字
			g.drawImage(N[No_digit_2], 80, 70, 35, 35, this); // 図鑑ナンバー2桁目の数字

			g.drawImage(Mess_win, 480 / 2, 350, 215, 130, this); // メッセージウィンドウ(右)

			if (Mon[2 * (page - 1) + 1].getCapture() == 1) {
				g.drawImage(MonImg[2 * (page - 1) + 1], 270, 130, 140, 180, this); // モンスター
				g.drawImage(Mon_Ex[2 * (page - 1) + 1], 250, 380, 195, 80, this); // モンスター説明テキスト

				g.drawImage(HeartSpace[0], 20 + 330, 325, 20, 20, this);
				g.drawImage(HeartSpace[1], 20 * 2 + 330, 325, 20, 20, this);
				g.drawImage(HeartSpace[2], 20 * 3 + 330, 325, 20, 20, this);
				g.drawImage(HeartSpace[3], 20 * 4 + 330, 325, 20, 20, this);
				g.drawImage(HeartSpace[4], 20 * 5 + 330, 325, 20, 20, this);

				switch ((FriendShip[2 * (page - 1) + 1]) / 20) {
				case 0:
					break;
				case 1:
					g.drawImage(Heart[0], 20 + 330, 325, 20, 20, this);
					break;
				case 2:
					g.drawImage(Heart[0], 20 + 330, 325, 20, 20, this);
					g.drawImage(Heart[1], 20 * 2 + 330, 325, 20, 20, this);
					break;
				case 3:
					g.drawImage(Heart[0], 20 + 330, 325, 20, 20, this);
					g.drawImage(Heart[1], 20 * 2 + 330, 325, 20, 20, this);
					g.drawImage(Heart[2], 20 * 3 + 330, 325, 20, 20, this);
					break;
				case 4:
					g.drawImage(Heart[0], 20 + 330, 325, 20, 20, this);
					g.drawImage(Heart[1], 20 * 2 + 330, 325, 20, 20, this);
					g.drawImage(Heart[2], 20 * 3 + 330, 325, 20, 20, this);
					g.drawImage(Heart[3], 20 * 4 + 330, 325, 20, 20, this);
					break;
				case 5:
					g.drawImage(Heart[0], 20 + 330, 325, 20, 20, this);
					g.drawImage(Heart[1], 20 * 2 + 330, 325, 20, 20, this);
					g.drawImage(Heart[2], 20 * 3 + 330, 325, 20, 20, this);
					g.drawImage(Heart[3], 20 * 4 + 330, 325, 20, 20, this);
					g.drawImage(Heart[4], 20 * 5 + 330, 325, 20, 20, this);
					break;
				}

			} else {
				g.drawImage(question, 275, 140, 150, 150, this); // はてな
			}

			g.drawImage(No, 250, 70, 60, 30, this); // 図鑑ナンバー（No.）

			No_digit_1 = (2 * (page - 1) + 2) % 10;
			No_digit_2 = (2 * (page - 1) + 2) / 10;
			g.drawImage(N[No_digit_1], 335, 70, 35, 35, this); // 図鑑ナンバー(1桁目の数字)
			g.drawImage(N[No_digit_2], 310, 70, 35, 35, this); // 図鑑ナンバー(2桁目の数字)

		}

	}
}
