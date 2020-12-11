package main;

import bait.Bait;
import character.Character;
import home.Home;
import title.TitleMain;

public class Main {

	static TitleMain Tframe;
	static Home home;

	public static void main(String[] args) {
		Tframe = new TitleMain();
		home = new Home();

		Tframe.OpenTitle();
		Tframe.setVisible(true);

	}

	///////////// ウィンドウオープナー////////////////////////////////
	public static void OpenH() {
		Tframe.setVisible(false);
		home.OpenHome();
		home.setVisible(true);
	}

	public static void OpenH(Character ch[], Bait ba[]) {
		Tframe.setVisible(false);
		home.OpenHome(ch, ba);
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
