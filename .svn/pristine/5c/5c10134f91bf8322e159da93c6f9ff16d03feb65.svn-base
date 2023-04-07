package com.qst.util;

import java.util.Random;

public class FourRandomUtil {
	/**
	 * 产生4位随机数(0000-9999)
	 * 
	 * @return 4位随机数     
	 */
	public static String getFourRandom() {
		Random random = new Random();
		String fourRandom = random.nextInt(10000) + "";
		int randLength = fourRandom.length();
		if (randLength < 4) {
			for (int i = 1; i <= 4 - randLength; i++) {
				fourRandom = "0" + fourRandom;
			}
		}
		return fourRandom;
	}
}