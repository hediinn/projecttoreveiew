import java.time.LocalTime;
import  java.time.DateTimeException;

public class TimeKepper {
	


	public static LocalTime stringToTime(String[] time) {
		

		int minutes = Integer.parseInt(time[1]);
		int hours = Integer.parseInt(time[0]);

		LocalTime timeAsTime;

			timeAsTime = LocalTime.of(hours, minutes);

		return timeAsTime;
	}

	public static String[] timeUp(String[] time) {

		int minutes = Integer.parseInt(time[1]);
		int hours = Integer.parseInt(time[0]);
		String[] tempTime = new String[2];

		minutes += 10;

		if (minutes >= 60) {

			minutes %= 60;
			hours += 1;
		}

		if (hours < 10) {

			tempTime[0] = "0"+Integer.toString(hours);

		} else {

			tempTime[0] = Integer.toString(hours);
		}

		if (minutes < 10) {

			tempTime[1] = "0"+Integer.toString(minutes);

		} else {

			tempTime[1] = Integer.toString(minutes);
			
		}
		if(hours == 24) {
			tempTime[0] = "00";
		}

		return tempTime;
	}
}
