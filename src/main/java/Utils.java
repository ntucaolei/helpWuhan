package main.java;

import org.joda.time.DateTime;

public class Utils {

	public static void log(Object logData) {
		DateTime dt = new DateTime();
		String data = dt.toString() + " - " + logData.toString();
		System.out.println(data);
	}
}
