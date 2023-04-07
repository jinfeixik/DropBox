package com.qst.dao;

import java.util.List;

import com.qst.entity.FileInfo;
import com.qst.entity.FileShare;

/**
 * @author 周浩zhouhao
 * @date 2019-8-28下午3:35:35
 * @version v1.0 分享管理
 */
public interface FileShareMapper {
	// 添加一个分享文件
	void addFileShare(FileShare fileShare);

	// 删除一个分享文件
	void deleteFileShare(FileShare fileShare);

	// 清空用户的分享文件
	void clearFileShare(int userId);

	// 通过id获取一个分享文件
	FileShare findFileShareById(FileShare fileShare);
	
	// 通过外链获取一个分享文件
	FileShare findFileShareByShareLink(String shareLink);

	// 获取用户所有的分享文件
	List<FileShare> findAllFileShare(int userId);

	// 通过id获取一个文件信息
	FileInfo findFileById(int fileId);

	// 修改分享文件的浏览和下载次数
	void updateFileShareNumber(FileShare fileShare);

	// 修改分享文件的状态（是否加密）
	void updateFileShareStatus(FileShare fileShare);
}
