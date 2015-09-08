
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyDate {
	/**
	 * This method generate a date correspoind to the current one
	 * @return string representing the current date
	 */
	public static String getCurrentDate(){
		Calendar calendar =Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		return sdf.format(calendar.getTime());
	}

}
