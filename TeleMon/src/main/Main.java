package main;

import encount.EncountFrame;
import home.Home;
import library.LibraryDraw;
import library.LibraryMain;
import title.TitleMain;


public class Main {

	 static TitleMain Tframe;
	 static Home home;
	 static LibraryMain Lframe;
	 static LibraryDraw LD;
	 static EncountFrame EF;


  public static void main(String[] args) {

    Tframe = new TitleMain();
    home = new Home();
      Lframe = new LibraryMain("ZUKAN",480,620);
	  LD =new LibraryDraw();
	  Lframe.add(LD);
	EF = new EncountFrame();
	EF.OpenEncount();
    Tframe.OpenTitle();
	Tframe.setVisible(true);

  }

  public static void OpenH() {
	  Tframe.setVisible(false);
	  home.OpenHome();
	  home.setVisible(true);
  }
  public static void OpenL() {
	  home.setVisible(false);
	  Lframe.setVisible(true);
  }
  public static void OpenE() {
	  home.setVisible(false);
	  EF.setVisible(true);
  }


}
