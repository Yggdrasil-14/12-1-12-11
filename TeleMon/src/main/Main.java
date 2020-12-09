package main;

import bait.Bait;
import character.Character;
import home.Home;
import library.LibraryDraw;
import title.TitleMain;


public class Main {

	 static TitleMain Tframe;
	 static Home home;
	 //static LibraryMain Lframe;
	 static LibraryDraw LD;


  public static void main(String[] args) {

    Tframe = new TitleMain();
    home = new Home();
	 // LD =new LibraryDraw();
	  //Lframe.add(LD);

    Tframe.OpenTitle();
	Tframe.setVisible(true);

  }

  /////////////ウィンドウオープナー////////////////////////////////
  public static void OpenH() {
	  Tframe.setVisible(false);
	  home.OpenHome();
	  home.setVisible(true);
  }
  public static void OpenH(Character ch[],Bait ba[]) {
	  Tframe.setVisible(false);
	  home.OpenHome(ch,ba);
	  home.setVisible(true);
  }
  public static void OpenL() {
	  home.setVisible(false);
	 // Lframe.setVisible(true);
  }
  public static void CloseH() {
	  home.setVisible(false);

  }


}
