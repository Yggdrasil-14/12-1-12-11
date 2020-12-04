package character;

import java.util.Random;

import bait.Bait;

public class Character {
	//likability="好感度",friendship="なつき度"
	private int capture,partner,appearPlace,likability,requiredLikabilityToGet,friendship,limitOfReceiveBait,limitOfReceiveBaitForReset;
	private int increaseValueOfReceiveBait[]=new int[Bait.baitKindNumber];
	private String name,imagePass;
	
	//コンストラクタ
	public Character(String data[]){
		//データを格納
		this.name=data[0];
		this.capture=Integer.parseInt(data[1]);
		this.partner=Integer.parseInt(data[2]);
		this.appearPlace=Integer.parseInt(data[3]);
		this.likability=Integer.parseInt(data[4]);
		this.requiredLikabilityToGet=Integer.parseInt(data[5]);
		this.friendship=Integer.parseInt(data[6]);
		this.limitOfReceiveBait=Integer.parseInt(data[7]);
		limitOfReceiveBaitForReset=this.limitOfReceiveBait;
		for(int i=0;i<Bait.baitKindNumber;i++) this.increaseValueOfReceiveBait[i]=Integer.parseInt(data[8+i]);
		this.imagePass="src/charactor/Material/"+data[1]+".png";	//必要に応じて相対パス変更
	}
	
	//ポロック付与上限セット
	public void setLimitOfReceiveBait() {
		Random randomValue=new Random();
		int rand=randomValue.nextInt(5);
		int changeValue;
		if(rand==0) changeValue=-1;
		else if(0<rand&&rand<4) changeValue=0;
		else changeValue=1;
		limitOfReceiveBait+=changeValue;
	}
	//ポロック付与上限リセット
	public void resetLimitOfReceiveBait() {
		limitOfReceiveBait=limitOfReceiveBaitForReset;
	}
	
	//相棒変更
	public void makePartner() {
		partner=1;
	}
	public void removePartner() {
		partner=0;
	}
	
	//好感度リセット
	public void resetLikability() {
		likability=0;
	}
	//好感度上昇
	public void increaseLikability(int kind) {
		likability+=increaseValueOfReceiveBait[kind];
	}
	
	//ゲットできるか判定
	public void judgeCanGet() {
		if(requiredLikabilityToGet<likability) {
			capture=1;
			return;
		}
		Random randomValue=new Random();
		int rand=randomValue.nextInt(100);
		int probabilityOfGet=100*likability/requiredLikabilityToGet*4/5;
		if(probabilityOfGet<rand) capture=1;
	}
	
	//なつき度上昇
	//時間経過で上昇
	public void increaseFriendshipOverTime(int elapsedTime) {
		if(partner==0) return;
		if(friendship+elapsedTime<100) friendship+=elapsedTime;
		else friendship=100;
	}
	//ポロックで上昇
	public void increaseFriendshipOverBait(int kind) {
		if(friendship+increaseValueOfReceiveBait[kind]<100) friendship+=increaseValueOfReceiveBait[kind];
		else friendship=100;
	}
	
	//データ値取得
	public String getName() {
		return name;
	}
	public int getCapture() {
		return capture;
	}
	public int getAppearPlace() {
		return appearPlace;
	}
	public int getFriendoship() {
		return friendship;
	}
	public String getImagePass() {
		return imagePass;
	}
}