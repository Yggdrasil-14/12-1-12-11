package time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Time {
	private LocalDateTime nowDateTime,previousDateTime;
	private int year,month,date,hour,minute,second;

	//コンストラクタ
	public Time(String[] str){
		//previousDateTime=recordDate;
		nowDateTime=LocalDateTime.now();
	}

	//値更新
	public void updateDateTime() {
		previousDateTime=nowDateTime;
		nowDateTime=LocalDateTime.now();
	}

	//時間の差分算出
	public int getDifferenceValue() {
		long differenceValue;
		differenceValue=ChronoUnit.SECONDS.between(previousDateTime,nowDateTime);
		return (int)differenceValue;
	}
	public int getDifferenceValue(LocalDateTime start,LocalDateTime end) {
		long differenceValue;
		differenceValue=ChronoUnit.SECONDS.between(start,end);
		return (int)differenceValue;
	}

	//値取得
	public LocalDateTime getNowDateTime() {
		return nowDateTime;
	}
}
