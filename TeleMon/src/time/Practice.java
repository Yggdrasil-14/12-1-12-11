package time;

import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Practice {
	private LocalDateTime nowDateTime,previousDateTime;
	
	Practice(int data[]){
		previousDateTime=LocalDateTime.of(data[0],data[1],data[2],data[3],data[4],data[5]);
		nowDateTime=LocalDateTime.now();
	}
	
	public int getDifferenceValue() {
		long differenceValue;
		differenceValue=ChronoUnit.SECONDS.between(previousDateTime,nowDateTime);
		return (int)differenceValue;
	}
}
