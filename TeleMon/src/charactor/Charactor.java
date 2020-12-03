package charactor;

import java.util.Random;

public class Charactor {
	//likability="�D���x",friendship="�Ȃ��x"
	private int no,capture,partner,appearPlace,likability,requiredLikabilityToGet,friendship,limitOfReceiveBait,limitOfReceiveBaitForReset;
	private int increaseValueOfReceiveBait[]=new int[6];
	private String name,imagePass;
	
	//�R���X�g���N�^
	Charactor(String data[]){
		//�f�[�^���i�[
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
		this.imagePass="���΃p�X"+data[1]+".png";	//���΃p�X�����ƂŋL�ځ@���Y����
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
	public void increaseFriendship() {
		if(friendship!=100) friendship++;
	}
	//�|���b�N�ŏ㏸
	public void increaseFriendship(int kind) {
		if(friendship+increaseValueOfReceiveBait[kind]<100) friendship+=increaseValueOfReceiveBait[kind];
		else friendship=100;
	}
	
	//�f�[�^�l�擾
	public String getImagePass() {
		return imagePass;
	}
}
