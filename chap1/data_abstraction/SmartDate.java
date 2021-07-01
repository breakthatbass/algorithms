/*
 * exercise 1.2.11
 *
 * develop an implementation SmartDate of our Date API that raises an exception
 * if the date is not legal
 *
 * Date class is on page 91
 *
 * exercise 1.2.12
 *
 * add a method `dayOfTheWeek()` to SmartDate that returns a string value
 * monday, tuesday, wednesday, thursday, friday, saturday, or sunday, giving the
 * appropriate day of the week for the date. you may assume that the date is in
 * the 21st century.
 *
 * there is a Date class in the algs4 lib, however, it doesn't really do what we
 * would need it for here. i found a solution by just using the java stdlib.
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;

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


	// dayOfTheWeek: print the day of the week of the date in instance
	public String dayOfTheWeek() {
		
		// Calendar class returns days as ints 1..7 so there needs to be
		// something here at the 0 index
		String[] weekdays = {
			null, "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
		};

		try {
			Calendar tmp = new GregorianCalendar(this.year, this.month, this.day);
			int dayOfWeek = tmp.get(Calendar.DAY_OF_WEEK);
			return weekdays[dayOfWeek];

		} catch (Exception e) {
			return "error: dayOfTheWeek: failed to return day";
		}
	}


	// isValid: check if the date is a valid date
	// ...does not check for leap years, aint nobody got time for that
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


	
	/******* MAIN **********/

	public static void main(String[] args)
	{
		try { // this will work
			SmartDate works = new SmartDate(6, 28, 2021);
			System.out.println(works.toString() + " -> " + works.dayOfTheWeek());
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
