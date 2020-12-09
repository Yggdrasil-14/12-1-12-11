package bait;

public class Bait {
	public static final int baitKindNumber=6;
	public static final int completeBonusNumber=4;

	private String name[]=new String[baitKindNumber];
	private int numberOfBait[]=new int[baitKindNumber];
	private int completeBonus[]=new int[completeBonusNumber];
	//�R���X�g���N�^
	public Bait(String data[]) {
		for(int i=0;i<baitKindNumber;i++) this.name[i]=data[i];
		for(int i=0;i<baitKindNumber;i++) this.numberOfBait[i]=Integer.parseInt(data[baitKindNumber+i]);
		for(int i=0;i<completeBonusNumber;i++) this.completeBonus[i]=Integer.parseInt(data[baitKindNumber*2+i]);
	}
	//�����X�^�[�Q�b�g�{�[�i�X
	public void monsterGetBonus() {
		increaseBait(2);
	}

	//�Ȃ��x�}�b�N�X�{�[�i�X
	public void friendshipMaxBonus() {
		increaseBait(5);
	}
	//�}�ӃR���v���[�g���{�[�i�X
	public void libraryCompleteBonus(int completeRate) {
		if(completeBonus[0]==0&&completeRate>25) {
			increaseBait(2);
			completeBonus[0]=1;
		}
		if(completeBonus[1]==0&&completeRate>50) {
			increaseBait(5);
			completeBonus[1]=1;
		}
		if(completeBonus[2]==0&&completeRate>75) {
			increaseBait(7);
			completeBonus[2]=1;
		}
		if(completeBonus[3]==0&&completeRate==100) {
			increaseBait(10);
			completeBonus[3]=1;
		}
	}
	//�|���b�N����
		public void increaseBait(int elapsedTime) {
			for(int i=0;i<baitKindNumber;i++) {
				if(numberOfBait[i]+elapsedTime<10) numberOfBait[i]+=elapsedTime;
				else numberOfBait[i]=10;
			}
		}
		//�|���b�N����
		public void useBait(int kind) {
			numberOfBait[kind]--;
		}
		//�l�擾
		public String getName(int i) {
			return name[i];
		}
		public void setName(int i,String name) {
			this.name[i]=name;
		}
		public int getNumberOfBait(int i) {
			return numberOfBait[i];
		}
		public void setNumberOfBait(int i,int numberOfBait) {
			this.numberOfBait[i]=numberOfBait;
		}
		public int getCompleteBonus(int i) {
			return completeBonus[i];
		}
		public void setCompleteBonus(int i,int completeBonus) {
			this.completeBonus[i]=completeBonus;
		}
}