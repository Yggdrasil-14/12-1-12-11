package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import bait.Bait;
import character.Character;

public class Save {
////////////////////////////////////////////////////////////////////////////////////
	public static final int ec = 16;//ElemntsCulumn
////////////////////////////////////////////////////////////////////////////////////
	//�ۑ��f�[�^�̐��ɕύX���������ꍇ�ɋL�q
	public static final int tdl = 17;//TotalDataLines
	public static final int cl = 13;//CharacterLines
	public static final int bl = 3;//BaitLines
	public static final int tl = 1;//TimeLines
	public static final int ll = 0;//LibraryDrawLines
	public void save(Character ch[],Bait ba[]) {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
try {
//�t�@�C���̏������݂��s��
PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("saveFile1.txt")));
int j = 0;
for(int i = 0;i<=tdl;i++) {
if(i==0||i==cl||i==cl+bl) {j = 0;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if(i<cl){pw.println(ch[j].getName()+","+ch[j].getCapture()+","+
ch[j].getAppearPlace()+","+ch[j].getFriendoship()+","+ch[j].getImagePass()+","+0+","+
0+","+0+","+0+","+0+","+
0+","+0+","+0+","+0);
j++;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//if(ml<=i&i<ml+pl){pw.println(ba[j].getA()+","+ba[j].getC()+","+
//ba[j].getD()+","+ba[j].getE()+","+ba[j].getF()+","+ba[j].getG()+","+
//ba[j].getH()+","+ba[j].getI()+","+ba[j].getJ()+","+ba[j].getK()+","+
//ba[j].getL()+","+ba[j].getN()+","+ba[j].getM()+","+ba[j].getO());
//j++;}
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
