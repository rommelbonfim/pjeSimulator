package com.icev.pjesimulator.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	
	public static Date parse(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			date = null;
			e.printStackTrace();
		}
		return date;
	}

	public static String GenerateNumProcess() {
		long numberPart1 = (long) (1000000l + Math.random() * 8999999l);
		int  numberPart2 = (int) (10 + Math.random() * 89);
		int  numberPart3 = (int) (1000 + Math.random() * 8999);
		int  numberPart4 = (int) (1 + Math.random() * 8);
		int  numberPart5 = (int) (10 + Math.random() * 89);
		int  numberPart6 = (int) (1000 + Math.random() * 8999);
		return (numberPart1 + "-" + numberPart2 + "." + numberPart3 + "." + numberPart4 + "." + numberPart5 + "." + numberPart6);
	}
}
