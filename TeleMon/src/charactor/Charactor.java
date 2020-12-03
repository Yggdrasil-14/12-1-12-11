package charactor;

import java.util.Random;

public class Charactor {
	//likability="好感度",friendship="なつき度"
	private int no,capture,partner,appearPlace,likability,requiredLikabilityToGet,friendship,limitOfReceiveBait,limitOfReceiveBaitForReset;
	private int increaseValueOfReceiveBait[]=new int[6];
	private String name,imagePass;
	
	//コンストラクタ
	Charactor(String data[]){
		//データを格納
		this.no=Integer.parseInt(data[0]);
		this.name=data[1];
		this.capture=Integer.parseInt(data[2]);
		this.partner=Integer.parseInt(data[3]);
		this.appearPlace=Integer.parseInt(data[4]);
		this.likability=Integer.parseInt(data[5]);
		this.requiredLikabilityToGet=Integer.parseInt(data[6]);
		this.friendship=Integer.parseInt(data[7]);
		this.limitOfReceiveBait=Integer.parseInt(data[8]);
		limitOfReceiveBaitForReset=this.limitOfReceiveBait;
		for(int i=0;i<6;i++) this.increaseValueOfReceiveBait[i]=Integer.parseInt(data[9+i]);
		this.imagePass="相対パス"+data[1]+".png";	//相対パスをあとで記載　※忘れるな
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
	public void increaseFriendship() {
		if(friendship!=100) friendship++;
	}
	//ポロックで上昇
	public void increaseFriendship(int kind) {
		if(friendship+increaseValueOfReceiveBait[kind]<100) friendship+=increaseValueOfReceiveBait[kind];
		else friendship=100;
	}
	
	//データ値取得
	public String getImagePass() {
		return imagePass;
	}
}
