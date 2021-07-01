/*
 * exercise 1.2.11
 *
 * develop an implementation SmartDate of our Date API that raises an exception
 * if the date is not legal
 *
 * Date class is on page 91
 */


public class SmartDate
{
	private final int month;
	private final int day;
	private final int year;

	public SmartDate(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;

		if (!isValid(month, day)) {
			throw new IllegalArgumentException(
					"error: " + month +  "/" + day +  "/" + year +
					" -> not a valid date"
					);
		}
	}

	public int month() {
		return month;
	}

	public int day() {
		return day;
	}

	public int year() {
		return year;
	}

	public String toString() {
		return month() + "/" + day() + "/" + year(); 
	}

	private boolean isValid(int month, int day) {
		int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		if (month > maxDays.length) {
			return false;
		}

		if (day > maxDays[month-1]) {
			return false;
		}
		return true;
	}


	public static void main(String[] args)
	{
		try { // this will work
			SmartDate works = new SmartDate(7, 1, 2021);
		}
		catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}


		try { // this will fail
			SmartDate fails = new SmartDate(22, 35, 2021);
		}
		catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
