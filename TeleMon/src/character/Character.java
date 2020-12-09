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
		//�ータを��
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
		this.imagePass="src/charactor/Material/"+data[1]+".png";	//�要に応じて相対パス変更
	}
	//ポロ�ク付与上限セ��
	public void setLimitOfReceiveBait() {
		Random randomValue=new Random();
		int rand=randomValue.nextInt(5);
		int changeValue;
		if(rand==0) changeValue=-1;
		else if(0<rand&&rand<4) changeValue=0;
		else changeValue=1;
		limitOfReceiveBait+=changeValue;
	}
	//ポロ�ク付与上限リセ��
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

	//好感度リセ��
	public void resetLikability() {
		likability=0;
	}
	//好感度上�
	public void increaseLikability(int kind) {
		likability+=increaseValueOfReceiveBait[kind];
	}

	//ゲ�トできるか判�
//	public void judgeCanGet() {
//		if(requiredLikabilityToGet<likability) {
//			capture=1;
//			return;
//		}
//		Random randomValue=new Random();
//		int rand=randomValue.nextInt(100);
//		int probabilityOfGet=100*likability/requiredLikabilityToGet*4/5;
//		if(probabilityOfGet<rand) capture=1;
//	}

	//なつき度上�
	//時間経過で上�
	public void increaseFriendshipOverTime(int elapsedTime) {
		if(partner==0) return;
		if(friendship+elapsedTime<100) friendship+=elapsedTime;
		else friendship=100;
	}
	//ポロ�クで上�
	public void increaseFriendshipOverBait(int kind) {
		if(friendship+increaseValueOfReceiveBait[kind]<100) friendship+=increaseValueOfReceiveBait[kind];
		else friendship=100;
	}

	//�ータ値取�
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getCapture() {
		return capture;
	}
	public void setCapture() {
		capture = 1;
	}
	public void setCapture(int capture) {
		this.capture = capture;
	}
	public int getPartner() {
		return partner;
	}
	public void setPartner(int partner) {
		this.partner=partner;
	}
	public int getLikability() {
		return likability;
	}
	public void setLikability(int likability) {
		this.likability=likability;
	}
	public int getRequiredLikabilityToGet() {
		return requiredLikabilityToGet;
	}
	public void setRequiredLikabilityToGet(int requiredLikabilityToGet) {
		this.requiredLikabilityToGet=requiredLikabilityToGet;
	}
	public int getAppearPlace() {
		return appearPlace;
	}
	public void setAppearPlace(int appearPlace) {
		this.appearPlace=appearPlace;
	}
	public int getFriendship() {
		return friendship;
	}
	public void setFriendship(int friendship) {
		this.friendship=friendship;
	}
	public int getLimitOfReceiveBait() {
		return limitOfReceiveBait;
	}
	public void setLimitOfReceiveBait(int limitOfReceiveBait) {
		this.limitOfReceiveBait=limitOfReceiveBait;
	}
	public String getIncreaseValueOfReceiveBait(){
		return increaseValueOfReceiveBait[0]+","+increaseValueOfReceiveBait[1]+","+
				increaseValueOfReceiveBait[2]+","+increaseValueOfReceiveBait[3]+","+
				increaseValueOfReceiveBait[4]+","+increaseValueOfReceiveBait[5];
	}
	public void setIncreaseValueOfReceiveBait(int a,int b,int c,int d,int e,int f) {
		this.increaseValueOfReceiveBait[0]= a;
		this.increaseValueOfReceiveBait[1]= b;
		this.increaseValueOfReceiveBait[2]= c;
		this.increaseValueOfReceiveBait[3]= d;
		this.increaseValueOfReceiveBait[4]= e;
		this.increaseValueOfReceiveBait[5]= f;
	}
	public int getIncreaseValueOfReceiveBait0() {
		return increaseValueOfReceiveBait[0];
	}
	public int getIncreaseValueOfReceiveBait1() {
		return increaseValueOfReceiveBait[1];
	}
	public int getIncreaseValueOfReceiveBait2() {
		return increaseValueOfReceiveBait[2];
	}
	public int getIncreaseValueOfReceiveBait3() {
		return increaseValueOfReceiveBait[3];
	}
	public int getIncreaseValueOfReceiveBait4() {
		return increaseValueOfReceiveBait[4];
	}
	public int getIncreaseValueOfReceiveBait5() {
		return increaseValueOfReceiveBait[5];
	}

	public String getImagePass() {
		return imagePass;
	}
}
