package bait;

public class Bait {
	private int numberOfBait[]=new int[6];
	
	
	public void increaseBait(int kind,int number) {
		numberOfBait[kind]++;
	}
	public void useBait(int kind) {
		numberOfBait[kind]--;
	}
}
