package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import bait.Bait;
import character.Character;
import time.Time;

public class Save {
////////////////////////////////////////////////////////////////////////////////////
	public static final int ec = 16;//ElemntsCulumn
////////////////////////////////////////////////////////////////////////////////////
	//保存データの数に変更があった�合に記述
	public static final int tdl = 14;//TotalDataLines
	public static final int cl = 12;//CharacterLines
	public static final int bl = 1;//BaitLines
	public static final int tl = 1;//TimeLines
	public static final int ll = 0;//LibraryDrawLines
	public void save(Character ch[],Bait ba[],Time ti[]) {//数�けわかったらオ�ケー
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
try {
//ファイルの書き込みを行う
PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("saveFile1.txt")));
int j = 0;
for(int i = 0;i<=tdl;i++) {
if(i==0||i==cl||i==cl+bl) {j = 0;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if(i<cl){pw.println(ch[j].getName()+","+ch[j].getCapture()+","+
ch[j].getPartner()+","+ch[j].getAppearPlace()+","+ch[j].getLikability()+","+
ch[j].getRequiredLikabilityToGet()+","+ch[j].getFriendship()+","+ch[j].getLimitOfReceiveBait()+","+
ch[j].getIncreaseValueOfReceiveBait()+","+0+","+0);
j++;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if(cl<=i&i<cl+bl){pw.println(ba[j].getName(0)+","+ba[j].getName(1)+","+
ba[j].getName(2)+","+ba[j].getName(3)+","+ba[j].getName(4)+","+ba[j].getName(5)+","+
ba[j].getNumberOfBait(0)+","+ba[j].getNumberOfBait(1)+","+ba[j].getNumberOfBait(2)+","+
ba[j].getNumberOfBait(3)+","+ba[j].getNumberOfBait(4)+","+ba[j].getNumberOfBait(5)+","+
ba[j].getCompleteBonus(0)+","+ba[j].getCompleteBonus(1)+","+
ba[j].getCompleteBonus(2)+","+ba[j].getCompleteBonus(3)+",");
j++;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if(cl+bl<=i&i<cl+bl+tl){pw.println(ti[j].getNowYear()+","+ti[j].getNowMonth()+","+
ti[j].getNowDay()+","+ti[j].getNowHour()+","+ti[j].getNowMinute()+","+ti[j].getNowSecond()+","+
0+","+0+","+0+","+0+","+0+","+0+","+
0+","+0+","+0+","+0);
j++;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if(i == tdl){
System.out.println(i+"Data of Save");
break;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
pw.close();//ファイルを閉じる
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}catch(Exception ee) {
System.out.println(ee);
}
}
}
