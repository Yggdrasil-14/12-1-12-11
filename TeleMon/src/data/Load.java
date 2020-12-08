package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Load {
	public void load(String[][] str) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("saveFile1.txt"));
			String line = null;
			//セーブデータの読み込み
			for(int j=0;j<Save.tdl;j++) {
				line = bf.readLine();
				str[j] = line.split(",");
			}
			bf.close();//読み込みのオブジェクトを閉じる
		}catch(FileNotFoundException e) {
					System.out.println(e);
				}catch(IOException e){
					System.out.println(e);
				}
	}
	public void firstLoad(String[][] str) {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("saveFile2.txt"));
			String line = null;
			//セーブデータの読み込み
			for(int j=0;j<Save.tdl;j++) {
				line = bf.readLine();
				str[j] = line.split(",");
			}
			bf.close();//読み込みのオブジェクトを閉じる
		}catch(FileNotFoundException e) {
					System.out.println(e);
				}catch(IOException e){
					System.out.println(e);
				}
	}

}
