package time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Time {
	private LocalDateTime nowDateTime,previousDateTime,previousEndDateTime;
	
	//�R���X�g���N�^
	public Time(String data[]){
		previousEndDateTime=LocalDateTime.of(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]));
		nowDateTime=LocalDateTime.now();
	}
	
	//�l�X�V
	public void updateDateTime() {
		previousDateTime=nowDateTime;
		nowDateTime=LocalDateTime.now();
	}
	
	//�O��v�����Ԃƌ��ݎ��Ԃ̍������Z�o
	public int getHourBetweenPreviousNow() {
		return (int)getHourBetweenArgumentNow(previousDateTime);
	}
	
	//�O��I�����Ԃƌ��ݎ��Ԃ̍������Z�o
	public int getHourBetweenEndNow() {
		return (int)getHourBetweenArgumentNow(previousEndDateTime);
	}
	
	//�����̎��Ԃƌ��ݎ��Ԃ̍������Z�o
	public long getHourBetweenArgumentNow(LocalDateTime start) {
		long differenceValue;
		differenceValue=ChronoUnit.HOURS.between(start,LocalDateTime.now());
		return differenceValue;
	}
	public long getSecondBetweenArgumentNow(LocalDateTime start) {
		long differenceValue;
		differenceValue=ChronoUnit.SECONDS.between(start,LocalDateTime.now());
		return differenceValue;
	}
	
	//�l�擾
	public int getNowYear() {
		return nowDateTime.getYear();
	}
	public int getNowMonth() {
		return nowDateTime.getMonthValue();
	}
	public int getNowDay() {
		return nowDateTime.getDayOfMonth();
	}
	public int getNowHour() {
		return nowDateTime.getHour();
	}
	public int getNowMinute() {
		return nowDateTime.getMinute();
	}
	public int getNowSecond() {
		return nowDateTime.getSecond();
	}
}
