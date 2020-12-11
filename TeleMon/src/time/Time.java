package time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Time {
	private LocalDateTime nowDateTime,previousDateTime;

	//�R���X�g���N�^
	public Time(String[] str){
		previousDateTime=LocalDateTime.of(Integer.parseInt(str[0]),
				Integer.parseInt(str[1]),Integer.parseInt(str[2]),
				Integer.parseInt(str[3]),Integer.parseInt(str[4]),
				Integer.parseInt(str[5]));
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
		differenceValue=ChronoUnit.HOURS.between(previousDateTime,nowDateTime);
		return (int)differenceValue;
	}
//	public int getDifferenceValue(LocalDateTime start,LocalDateTime end) {
//		long differenceValue;
//		differenceValue=ChronoUnit.SECONDS.between(start,end);
//		return (int)differenceValue;
//	}

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
