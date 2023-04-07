package com.qst.service;

import java.util.List;

import com.qst.entity.FileShare;

public interface FileShareService {

	// 添加一个分享文件
	void addFileShare(FileShare fileShare);

	// 删除一个分享文件
	void deleteFileShare(int fileId, int userId);

	// 清空用户的分享文件
	void clearFileShare(int userId);

	// 通过id获取用户一个分享文件
	FileShare findFileShare(int fileId, int userId);
	
	// 通过外链获取一个分享文件
	FileShare findFileShareByShareLink(String shareLink);

	// 获取用户所有的分享文件
	List<FileShare> findAllFileShare(int userId);

	// 更改分享文件的状态（是否加密）
	void updateFileShareStatus(int fileId, int userId);
}
