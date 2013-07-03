package org.stepper.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class DateUtils.
 *
 * Author: Abhishek kapoor
 * 21 Jun, 2013
 */
public class DateUtils {

	/**
	 * Gets the dayof today.
	 *
	 * @return the dayof today
	 */
	public static String getDayofToday() {

		Date d1 = new Date();
		String day = null;
		DateFormat f = new SimpleDateFormat("EEEE");
		try {
			day = f.format(d1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return day;
	}

	/**
	 * Returns true if the two calendars represent dates that fall in the same
	 * year, else false.
	 * 
	 * @param c1
	 *            Calendar one.
	 * @param c2
	 *            Calendar two.
	 * @return boolean.
	 */
	public static boolean inSameYear(Calendar c1, Calendar c2) {
		if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
			return true;
		return false;
	}

	/**
	 * Returns true if the two calendars represent dates that fall in the same
	 * quarter, else false. A quarter here is defined as the each group of three
	 * consecutive months, starting with the month designated as the first month
	 * by the Calendar package. Thus, it is not defined as the average number of
	 * milliseconds in a quarter, which would be {@link #YEAR_MS}/4.
	 * 
	 * @param c1
	 *            Calendar one.
	 * @param c2
	 *            Calendar two.
	 * @return boolean.
	 */
	public static boolean inSameQuarter(Calendar c1, Calendar c2) {
		if (inSameYear(c1, c2)) {
			int m1 = c1.get(Calendar.MONTH);
			int m2 = c2.get(Calendar.MONTH);
			if (m1 >= 9 && m2 >= 9)
				return true;
			if (m1 >= 6 && m1 < 9 && m2 >= 6 && m2 < 9)
				return true;
			if (m1 >= 3 && m1 < 6 && m2 >= 3 && m2 < 6)
				return true;
			if (m1 >= 0 && m1 < 3 && m2 >= 0 && m2 < 3)
				return true;
		}
		return false;
	}

	/**
	 * Returns true if the two calendars represent dates that fall in the same
	 * month, else false.
	 * 
	 * @param c1
	 *            Calendar one.
	 * @param c2
	 *            Calendar two.
	 * @return boolean.
	 */
	public static boolean inSameMonth(Calendar c1, Calendar c2) {
		if (inSameYear(c1, c2)
				&& (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)))
			return true;
		return false;
	}

	/**
	 * Returns true if the two calendars represent dates that fall in the same
	 * week, else false. A week here is defined by the Calendar.WEEK_OF_YEAR
	 * package. Special provisions have been made to test weeks than may span
	 * the end/beginning of a year, and returning true if the two calendars are
	 * specifying dates within such a week, despite Calendar.WEEK_OF_YEAR being
	 * unequal for the two Calendars.
	 * 
	 * @param c1
	 *            Calendar one.
	 * @param c2
	 *            Calendar two.
	 * @return boolean.
	 */
	public static boolean inSameWeek(Calendar c1, Calendar c2) {
		if (inSameYear(c1, c2)
				&& (c1.get(Calendar.WEEK_OF_YEAR) == c2
						.get(Calendar.WEEK_OF_YEAR)))
			return true;

		Calendar tmp;
		if (c1.before(c2)) {
			tmp = c2;
			c2 = c1;
			c1 = tmp;
		}

		int c1week = c1.get(Calendar.WEEK_OF_YEAR);
		int c2week = c1.get(Calendar.WEEK_OF_YEAR);

		if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) + 1) {
			if (c1week == c1.getActualMinimum(Calendar.WEEK_OF_YEAR)
					&& c2week == c2.getActualMaximum(Calendar.WEEK_OF_YEAR)) {
				tmp = (Calendar) c2.clone();
				tmp.add(Calendar.DAY_OF_YEAR, 7);
				if (tmp.get(Calendar.WEEK_OF_YEAR) > c1week)
					return true;
			}
		}

		return false;
	}

	/* Add month (passed as an argument ) in today�s date. */

	/**
	 * Adds the month in date.
	 *
	 * @param month the month
	 * @return the string
	 */
	public static String addMonthInDate(int month) {
		String date = "";
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, month);
		date = date + now.get(Calendar.DATE) + "-"
				+ (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.YEAR);
		return date;
	}

	/*
	 * Subtract month (passed as an argument ) in today's date.
	 */
	/**
	 * Subtract month in date.
	 *
	 * @param month the month
	 * @return the string
	 */
	public static String subtractMonthInDate(int month) {
		String date = "";
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, new Integer("-" + month));
		date = date + now.get(Calendar.DATE) + "-"
				+ (now.get(Calendar.MONTH) + 1) + "-" + now.get(Calendar.YEAR);
		return date;
	}

	/**
	 * Gets the current month.
	 *
	 * @return the current month
	 */
	public static String getCurrentMonth() {
		String[] monthName = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };
		Calendar cal = Calendar.getInstance();
		String month = monthName[cal.get(Calendar.MONTH)];
		return month;
	}

	
	/**
	 * Gets the dayof week name.
	 *
	 * @return the dayof week name
	 */
	public static String getDayofWeekName(){
		String day=null;
		String [] days = {"Sunday","Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday"};
		return days[getDayOfWeek()-1];
		
	}
	
	
	/**
	 * Gets the day of month.
	 *
	 * @return the day of month
	 */
	public static int getDayOfMonth() {
		return Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Gets the hour.
	 *
	 * @return the hour
	 */
	public static int getHour() {
		return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * Gets the month.
	 *
	 * @return the month
	 */
	public static int getMonth() {
		return Calendar.getInstance().get(Calendar.MONTH) + 1;
	}

	/**
	 * Checks if is leap year.
	 *
	 * @return true, if is leap year
	 */
	public static boolean isLeapYear() {
		Calendar calendar = Calendar.getInstance();
		Date d = calendar.getTime();

		try {
			calendar.set(Calendar.MONTH, 2);
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			if (getDayOfMonth() == 29) {
				return true;
			}
			return false;
		} finally {
			calendar.setTime(d);
		}
	}

	/**
	 * Checks if is last day of month.
	 *
	 * @param i the i
	 * @return true, if is last day of month
	 */
	public static boolean isLastDayOfMonth(int i){
		boolean isLastDay=false;
		Calendar calendar = Calendar.getInstance();
		int lastDate = calendar.getActualMaximum(Calendar.DATE);
		calendar.set(Calendar.DATE, lastDate);
		int lastDay = calendar.get(Calendar.DAY_OF_MONTH);
		if(lastDay == i){
			isLastDay=true;
		}
		return isLastDay;
	}
	
	/**
	 * Gets the day of week.
	 *
	 * @return the day of week
	 */
	public static int getDayOfWeek() {
		return Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * Checks if is weekend.
	 *
	 * @return true, if is weekend
	 */
	public static boolean isWeekend() {
		int dow = getDayOfWeek();

		return (dow == Calendar.SATURDAY || dow == Calendar.SUNDAY);
	}

}
