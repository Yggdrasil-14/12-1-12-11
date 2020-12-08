package time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Time {
	private LocalDateTime nowDateTime,previousDateTime;
	private int year,month,date,hour,minute,second;

	//�R���X�g���N�^
	public Time(String[] str){
		//previousDateTime=recordDate;
		nowDateTime=LocalDateTime.now();
	}

	//�l�X�V
	public void updateDateTime() {
		previousDateTime=nowDateTime;
		nowDateTime=LocalDateTime.now();
	}

	//���Ԃ̍����Z�o
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

	//�l�擾
	public LocalDateTime getNowDateTime() {
		return nowDateTime;
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
