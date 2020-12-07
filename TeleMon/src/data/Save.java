package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import bait.Bait;

public class Save {
////////////////////////////////////////////////////////////////////////////////////
	public static final int ec = 16;//ElemntsCulumn
////////////////////////////////////////////////////////////////////////////////////
	//保存データの数に変更があった場合に記述
	public static final int tdl = 17;//TotalDataLines
	public static final int ml = 13;//MonsterLines
	public static final int pl = 3;//PorockLines
	public static final int tl = 1;//TimeLines
	public static final int ll = 0;//LibraryDrawLines
	public void save(Character ms[],Bait pr[]) {
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
try {
//ファイルの書き込みを行う
PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("saveFile1.txt")));
int j = 0;
for(int i = 0;i<=tdl;i++) {
if(i==0||i==ml||i==ml+pl) {j = 0;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if(i<ml){pw.println(ms[j].getA()+","+ms[j].getC()+","+
ms[j].getD()+","+ms[j].getE()+","+ms[j].getF()+","+ms[j].getG()+","+
ms[j].getH()+","+ms[j].getI()+","+ms[j].getJ()+","+ms[j].getK()+","+
ms[j].getL()+","+ms[j].getN()+","+ms[j].getM()+","+ms[j].getO());
j++;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if(ml<=i&i<ml+pl){pw.println(pr[j].getA()+","+pr[j].getC()+","+
pr[j].getD()+","+pr[j].getE()+","+pr[j].getF()+","+pr[j].getG()+","+
pr[j].getH()+","+pr[j].getI()+","+pr[j].getJ()+","+pr[j].getK()+","+
pr[j].getL()+","+pr[j].getN()+","+pr[j].getM()+","+pr[j].getO());
j++;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
if(i == tdl){
System.out.println(i+"件のデータを保存しました");
break;}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
pw.close();//ファイルを閉じる
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}catch(Exception ee) {
System.out.println("例外処理");
}
}
}
