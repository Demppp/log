package com.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class CommonUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());
	}

	/**
	 * 取当前天的后几天
	 * @return
	 */
	public static Timestamp getDayAfterToday(int day) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = sdf.parse(sdf.format(new Date()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int x = c.get(Calendar.DATE);
		c.set(Calendar.DATE, x + day);
		return new Timestamp(c.getTime().getTime());
	}
}
