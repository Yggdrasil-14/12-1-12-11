package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import bait.Bait;

public class Save {
////////////////////////////////////////////////////////////////////////////////////
	public static final int ec = 16;//ElemntsCulumn
////////////////////////////////////////////////////////////////////////////////////
	//�ۑ��f�[�^�̐��ɕύX���������ꍇ�ɋL�q
	public static final int tdl = 17;//TotalDataLines
	public static final int ml = 13;//MonsterLines
	public static final int pl = 3;//PorockLines
	public static final int tl = 1;//TimeLines
	public static final int ll = 0;//LibraryDrawLines
	public void save(Character ms[],Bait pr[]) {
	Character cr = new Character("ma");
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
try {
//�t�@�C���̏������݂��s��
PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("saveFile1.txt")));
int j = 0;
for(int i = 0;i<=tdl;i++) {
if(i==0||i==ml||i==ml+pl) {j = 0;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if(i<ml){pw.println(ms[j].getName()+","+ms[j].getCapture()+","+
ms[j].getAppearPlace()+","+ms[j].getFriendoship()+","+ms[j].getImagePass()+","+0+","+
0+","+0+","+0+","+0+","+
0+","+0+","+0+","+0);
j++;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if(ml<=i&i<ml+pl){pw.println(pr[j].getA()+","+pr[j].getC()+","+
pr[j].getD()+","+pr[j].getE()+","+pr[j].getF()+","+pr[j].getG()+","+
pr[j].getH()+","+pr[j].getI()+","+pr[j].getJ()+","+pr[j].getK()+","+
pr[j].getL()+","+pr[j].getN()+","+pr[j].getM()+","+pr[j].getO());
j++;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if(i == tdl){
System.out.println(i+"���̃f�[�^��ۑ����܂���");
break;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
pw.close();//�t�@�C�������
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}catch(Exception ee) {
System.out.println("��O����");
}
}
}
