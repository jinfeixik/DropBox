package com.qst.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTimeUtil {
	/**
	 * function:获取当前时间戳
	 * 
	 * @return 时间戳
	 */
	public static Timestamp getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Date date = new Date();

		Timestamp time = new Timestamp(date.getTime());
		System.out.println("CurrentTime " + sdf.format(time));

		return time;
	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(CurrentTimeUtil.GetCurrentTime()); }
	 */
}
