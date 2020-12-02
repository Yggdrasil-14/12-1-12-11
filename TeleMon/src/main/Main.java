package main;




import library.LibraryMain;
import title.TitleMain;


public class Main {


  public static void main(String[] args) {
   //ウインドウを表示
   //FrameMain frame = new FrameMain();//インスタンス化
   TitleMain Tframe = new TitleMain();//インスタンス化
   LibraryMain Lframe = new LibraryMain();//インスタンス化
  // Tframe.TitleM();
   Tframe.halo();
   Lframe.OpenLib();
   // StartMain Sframe = new StartMain();//インスタンス化
   //
   // Sframe.startWindow();
  }
}