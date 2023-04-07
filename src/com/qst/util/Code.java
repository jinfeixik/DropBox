package com.qst.util;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * @author 赵海庭（zhaohaiting）
 * @date 2019-8-7下午8:12:13
 * @version v1.0
 */

public class Code {
	/**
	 * @param n
	 * @return
	 * 获取一个随机验证码
	 */
	public  static String getNumber(int n) {
		
		
		
		String str = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random r = new Random();
		String ss = "";
		for (int i = 0; i < n; i++) {
			char c = str.charAt(r.nextInt(str.length()));
			ss = ss + c;
		}
		return ss;
	}
}
