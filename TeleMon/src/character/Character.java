package character;

import java.util.Random;

import bait.Bait;

public class Character {
	//likability="�D���x",friendship="�Ȃ��x"
	private int capture,partner,appearPlace,likability,requiredLikabilityToGet,friendship,limitOfReceiveBait,limitOfReceiveBaitForReset;
	private int increaseValueOfReceiveBait[]=new int[Bait.baitKindNumber];
	private String name,imagePass;
	
	//�R���X�g���N�^
	public Character(String data[]){
		//�f�[�^���i�[
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
		this.imagePass="src/charactor/Material/"+data[1]+".png";	//�K�v�ɉ����đ��΃p�X�ύX
	}
	
	//�|���b�N�t�^����Z�b�g
	public void setLimitOfReceiveBait() {
		Random randomValue=new Random();
		int rand=randomValue.nextInt(5);
		int changeValue;
		if(rand==0) changeValue=-1;
		else if(0<rand&&rand<4) changeValue=0;
		else changeValue=1;
		limitOfReceiveBait+=changeValue;
	}
	//�|���b�N�t�^������Z�b�g
	public void resetLimitOfReceiveBait() {
		limitOfReceiveBait=limitOfReceiveBaitForReset;
	}
	
	//���_�ύX
	public void makePartner() {
		partner=1;
	}
	public void removePartner() {
		partner=0;
	}
	
	//�D���x���Z�b�g
	public void resetLikability() {
		likability=0;
	}
	//�D���x�㏸
	public void increaseLikability(int kind) {
		likability+=increaseValueOfReceiveBait[kind];
	}
	
	//�Q�b�g�ł��邩����
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
	
	//�Ȃ��x�㏸
	//���Ԍo�߂ŏ㏸
	public void increaseFriendshipOverTime(int elapsedTime) {
		if(partner==0) return;
		if(friendship+elapsedTime<100) friendship+=elapsedTime;
		else friendship=100;
	}
	//�|���b�N�ŏ㏸
	public void increaseFriendshipOverBait(int kind) {
		if(friendship+increaseValueOfReceiveBait[kind]<100) friendship+=increaseValueOfReceiveBait[kind];
		else friendship=100;
	}
	
	//�f�[�^�l�擾
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