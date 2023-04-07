package com.qst.util;

/**
 * @author 周浩zhouhao
 * @date 2019-9-6上午10:00:55
 * @version v1.0
 */
public class ShareLinkUtil {
	/**
	 * function:生成八位的分享链接码
	 * 
	 * @return
	 */
	public static String getShareLink() {
		String randomcode = "";
		// 用字符数组的方式随机
		String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] m = model.toCharArray();
		for (int j = 0; j < 8; j++) {
			char c = m[(int) (Math.random() * 36)];
			// 保证八位随机码之间没有重复的
			if (randomcode.contains(String.valueOf(c))) {
				j--;
				continue;
			}
			randomcode = randomcode + c;
		}
		System.out.println("ShareLink " + randomcode);

		return randomcode;
	}

	/*public static void main(String[] args) {
		ShareLinkUtil.getShareLink();
	}*/
}
