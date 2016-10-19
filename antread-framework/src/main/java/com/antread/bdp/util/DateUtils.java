package com.antread.bdp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.antread.bdp.framework.exception.BaseException;

public class DateUtils {
	public static final String FORMAT_DETAIL = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_SIMPLE = "yyyy-MM-dd";
	public static final String FORMAT_MEDIUM = "yyyy-MM-dd HH:mm";

	public static String formatDetialDate(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String formatSimpleDate(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}

	public static String formatMediumDate(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm");
	}

	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat ft = new SimpleDateFormat(pattern);
		return ft.format(date);
	}

	public static Date convertToDate(String dateStr, String pattern) throws ParseException {
		SimpleDateFormat ft = new SimpleDateFormat(pattern);
		return ft.parse(dateStr);
	}

	public static Date getDayBegin(Date day) {
		try {
			return convertToDate(formatSimpleDate(day) + " 00:00:00", FORMAT_DETAIL);
		} catch (ParseException e) {
			throw new BaseException("convert date error!");
		}
	}

	public static Date getDayEnd(Date day) {
		try {
			return convertToDate(formatSimpleDate(day) + " 23:59:59", FORMAT_DETAIL);
		} catch (ParseException e) {
			throw new BaseException("convert date error!");
		}
	}

	public static int getDateDaysDiff(Date start, Date end) {

		int days = (int) ((end.getTime() - start.getTime()) / 86400000);
		return days;
	}

	/**
	 * 获取N天前的日期
	 */
	public static Date getFormateDateNDaysAgo(int n) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -n);
		Date monday = c.getTime();
		return convertToDate(formatDate(monday, FORMAT_SIMPLE), FORMAT_SIMPLE);
	}

	public static String getSpecifiedDayAfterN(String specifiedDay, int n) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			throw new BaseException(e);
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + n);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}

	public static String getSpecifiedDayAfterN(Date specifiedDay, int n) {
		Calendar c = Calendar.getInstance();
		c.setTime(specifiedDay);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + n);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
		return dayAfter;
	}

	/**
	 * 根据日期获取星期几
	 */
	public static String getWeekByDate(String time) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(time);
		String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDaysName[intWeek];
	}
}
