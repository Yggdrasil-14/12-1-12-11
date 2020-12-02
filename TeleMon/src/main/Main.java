package main;

import home.Home;
import title.TitleMain;


public class Main {

	 static TitleMain Tframe;
	 static Home home;

  public static void main(String[] args) {

    Tframe = new TitleMain();//インスタンス化
    home = new Home();
   //LibraryMain Lframe = new LibraryMain("図鑑",480,620);

    Tframe.OpenTitle();
	  
	  
	 // home.setVisible(true);//ウィンドウ表示
	  Tframe.setVisible(true);

  }

  public static void OpenHome() {

	  Tframe.setVisible(false);
	  home.OpenHome();
	  home.setVisible(true);

  }

}