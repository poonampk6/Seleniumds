package com.ShopperStack.genericUtility;

import java.time.LocalDate;
import java.util.Random;

public class JavaUtility {

	public int randomNumber(){
		Random r=new Random();
		int num=r.nextInt(1000);
		return num;
	}
	
	public String Localdate() {
		String date=LocalDate.now().toString().replace("-", "");
		System.out.println(date);
		return date;
	}
	
	public String LocalDateTime() {
		String datetime=LocalDate.now().toString().replace("-", "");
		System.out.println(datetime);
		return datetime;
	}

}
