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
			N[i] = Toolkit.getDefaultToolkit().getImage("img/" + s + ".png"); // �i���o�[
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
	// �摜���[�h
	///////////

	Image book = Toolkit.getDefaultToolkit().getImage("img/Library.png"); // �{
	Image Back = Toolkit.getDefaultToolkit().getImage("img/Background.jpg"); // �w�i
	Image question = Toolkit.getDefaultToolkit().getImage("img/UnKnown.png"); // �͂Ă�
	Image Mess_win = Toolkit.getDefaultToolkit().getImage("img/Messagewindow.png"); // ���b�Z�[�W�E�B���h�E
	Image Achive_re_T = Toolkit.getDefaultToolkit().getImage("img/Achievementreward_Title.png"); // �B����V(�^�C�g��)
	Image Achive_re = Toolkit.getDefaultToolkit().getImage("img/Achievementreward.png"); // �B����V
	Image Comp_rate_T = Toolkit.getDefaultToolkit().getImage("img/Completerate_Title.png"); // �R���v���[�g��(�^�C�g��)
	Image No = Toolkit.getDefaultToolkit().getImage("img/No.png"); // �i���o�[�iNo.�j
	Image Percent = Toolkit.getDefaultToolkit().getImage("img/Percent.png"); // �R���v���[�g���\��(%)
	Image Comp_rate_line = Toolkit.getDefaultToolkit().getImage("img/Comprateunder.png");
	Image Hanamaru = Toolkit.getDefaultToolkit().getImage("img/Hanamaru.png"); // �͂Ȃ܂�
	Image AllPolocks = Toolkit.getDefaultToolkit().getImage("img/AllPolocks.png"); // ���ׂẴ|���b�N
	Image kakeru = Toolkit.getDefaultToolkit().getImage("img/�~.png"); // �B����V(�~)

	// Image HeartSpace =
	// Toolkit.getDefaultToolkit().getImage("img/HeartSpace.png");

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		///////////
		// �`��
		///////////

		int No_digit_1; // �}�Ӄi���o�[�\��1����
		int No_digit_2; // �}�Ӄi���o�[�\��2����

		int Comp_digit_1; // �R���v���[�g���\��1����
		int Comp_digit_2; // �R���v���[�g���\��2����
		int Comp_digit_3; // �R���v���[�g���\��3����

		g.drawImage(Back, 0, 0, 480, 620, this); // �w�i
		g.drawImage(book, 0, 0, 480, 620, this); // �{

		Comp_digit_3 = Comprate / 100;
		Comp_digit_2 = Comprate / 10;
		Comp_digit_1 = Comprate - Comp_digit_2 * 10;

		if (page == 0) {
			g.drawImage(Comp_rate_T, 40, 60, 180, 50, this); // �R���v���[�g��(�^�C�g��)
			g.drawImage(Achive_re_T, 260, 60, 180, 50, this); // �B����V(�^�C�g��)
			g.drawImage(Achive_re, 225, 120, 300, 380, this); // �B����V

			g.drawImage(AllPolocks, 350, 120, 70, 70, this); // ��V�|���b�N
			g.drawImage(kakeru, 380, 183, 35, 35, this); // �B����V(�~)
			g.drawImage(N[2], 410, 187, 30, 30, this); // ��V��

			g.drawImage(AllPolocks, 350, 220, 70, 70, this); // ��V�|���b�N
			g.drawImage(kakeru, 380, 283, 35, 35, this); // �B����V(�~)
			g.drawImage(N[5], 410, 287, 30, 30, this); // ��V��

			g.drawImage(AllPolocks, 350, 320, 70, 70, this); // ��V�|���b�N
			g.drawImage(kakeru, 380, 383, 35, 35, this); // �B����V(�~)
			g.drawImage(N[7], 410, 387, 30, 30, this); // ��V��

			g.drawImage(AllPolocks, 350, 420, 70, 70, this); // ��V�|���b�N
			g.drawImage(kakeru, 380, 483, 35, 35, this); // �B����V(�~)
			g.drawImage(N[1], 410, 487, 30, 30, this); // ��V��
			g.drawImage(N[0], 430, 487, 30, 30, this); // ��V��

			if (Comprate != 100) {
				g.drawImage(N[Comp_digit_1], 120, 240, 40, 60, this); // �R���v���[�g���\��1����
				if (Comp_digit_2 != 0) {
					g.drawImage(N[Comp_digit_2], 80, 240, 40, 60, this); // �R���v���[�g���\��2����
				}
				if (Comp_digit_3 != 0) {
					g.drawImage(N[Comp_digit_3], 40, 240, 40, 60, this); // �R���v���[�g���\��3����
				}
			} else if (Comprate == 100) {
				g.drawImage(N[0], 120, 240, 40, 60, this); // �R���v���[�g���\��1����
				g.drawImage(N[0], 80, 240, 40, 60, this); // �R���v���[�g���\��2����
				g.drawImage(N[1], 40, 240, 40, 60, this); // �R���v���[�g���\��3����
				g.drawImage(Hanamaru, 100, 100, 150, 150, this); // �͂Ȃ܂�
			}
			g.drawImage(Percent, 160, 240, 40, 60, this); // �R���v���[�g���\��(%)
			g.drawImage(Comp_rate_line, 20, 290, 220, 50, this); // �R���v���[�g���̃A���_�[���C��

		}

		else if (page != 0) {

			g.drawImage(Mess_win, 18, 350, 215, 130, this); // ���b�Z�[�W�E�B���h�E(��)

			if (Mon[2 * (page - 1)].getCapture() == 1) {
				g.drawImage(MonImg[2 * (page - 1)], 50, 130, 140, 180, this); // �����X�^�[
				g.drawImage(Mon_Ex[2 * (page - 1)], 30, 380, 195, 80, this); // �����X�^�[�����e�L�X�g

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
			} // �͂Ă�

			g.drawImage(No, 20, 70, 60, 30, this); // �i���o�[�iNo.�j

			No_digit_1 = (2 * (page - 1) + 1) % 10;
			No_digit_2 = (2 * (page - 1) + 1) / 10;
			g.drawImage(N[No_digit_1], 105, 70, 35, 35, this); // �}�Ӄi���o�[1���ڂ̐���
			g.drawImage(N[No_digit_2], 80, 70, 35, 35, this); // �}�Ӄi���o�[2���ڂ̐���

			g.drawImage(Mess_win, 480 / 2, 350, 215, 130, this); // ���b�Z�[�W�E�B���h�E(�E)

			if (Mon[2 * (page - 1) + 1].getCapture() == 1) {
				g.drawImage(MonImg[2 * (page - 1) + 1], 270, 130, 140, 180, this); // �����X�^�[
				g.drawImage(Mon_Ex[2 * (page - 1) + 1], 250, 380, 195, 80, this); // �����X�^�[�����e�L�X�g

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
				g.drawImage(question, 275, 140, 150, 150, this); // �͂Ă�
			}

			g.drawImage(No, 250, 70, 60, 30, this); // �}�Ӄi���o�[�iNo.�j

			No_digit_1 = (2 * (page - 1) + 2) % 10;
			No_digit_2 = (2 * (page - 1) + 2) / 10;
			g.drawImage(N[No_digit_1], 335, 70, 35, 35, this); // �}�Ӄi���o�[(1���ڂ̐���)
			g.drawImage(N[No_digit_2], 310, 70, 35, 35, this); // �}�Ӄi���o�[(2���ڂ̐���)

		}

	}
}
