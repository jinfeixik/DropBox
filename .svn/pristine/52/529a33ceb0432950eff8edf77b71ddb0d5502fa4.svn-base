package com.qst.util;

import java.io.File;

/**
 * @author 周浩zhouhao
 * @date 2019-8-30下午8:02:48
 * @version v1.0
 */
public class DeleteFileUtil {
	/**
	 * function:根据指定路径删除文件，无法撤回，可扩展为删除文件夹
	 * 
	 * @param filePath
	 */
	public static void deleteFile(String filePath) {
		try {
			File file = new File(DeleteFileUtil.class.getClassLoader().getResource("../../"+filePath).getPath());

			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
