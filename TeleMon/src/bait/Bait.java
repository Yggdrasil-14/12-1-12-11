package bait;

public class Bait {
	private int numberOfBait[]=new int[6];
	private int completeBonus[]=new int[4];
	private String name[]=new String[6];
	
	Bait(String data[]) {
		for(int i=0;i<6;i++) this.name[i]=data[i];
		for(int i=0;i<6;i++) this.numberOfBait[i]=Integer.parseInt(data[6+i]);
		for(int i=0;i<4;i++) this.completeBonus[i]=Integer.parseInt(data[12+i]);
	}
	
	//モンスターゲットボーナス
	public void monsterGetBonus() {
		for(int i=0;i<6;i++) increaseBait(i,2);
	}
	
	//なつき度マックスボーナス
	public void friendshipMaxBonus() {
		for(int i=0;i<6;i++) increaseBait(i,5);
	}
	
	//図鑑コンプリート率ボーナス
	public void libraryCompleteBonus(int completeRate) {
		if(completeBonus[0]==0&&completeRate>25) {
			for(int i=0;i<6;i++) increaseBait(i,2);
			completeBonus[0]=1;
		}
		if(completeBonus[1]==0&&completeRate>50) {
			for(int i=0;i<6;i++) increaseBait(i,5);
			completeBonus[1]=1;
		}
		if(completeBonus[2]==0&&completeRate>75) {
			for(int i=0;i<6;i++) increaseBait(i,7);
			completeBonus[2]=1;
		}
		if(completeBonus[3]==0&&completeRate==100) {
			for(int i=0;i<6;i++) increaseBait(i,10);
			completeBonus[3]=1;
		}
	}
	
	//ポロック増加
	public void increaseBait(int kind,int number) {
		if(numberOfBait[kind]+number<10) numberOfBait[kind]+=number;
		else numberOfBait[kind]=10;
	}
	//ポロック消費
	public void useBait(int kind) {
		numberOfBait[kind]--;
	}
}