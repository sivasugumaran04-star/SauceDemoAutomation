package Utilities;

import java.util.Date;
import java.util.Random;

public class Java_utilities {

	public static String getName() {
		
	return new Date().toString().replace(':', ' ');
	}
	
	public static String get() {
		
		int i=new Random().nextInt(1000000);
		Integer i2=i;
		return i2.toString();
		
	}
	
}
