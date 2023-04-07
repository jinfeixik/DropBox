package com.qst.dao;

import java.util.List;

import com.qst.entity.FileInfo;
import com.qst.entity.RecycleInfo;
import com.qst.entity.UserInfo;

/**
 * @author 周浩zhouhao
 * @date 2019-8-28下午3:30:56
 * @version v1.0
 * 回收站管理
 */
public interface RecycleInfoMapper {

	public void addRecycle(RecycleInfo recycle);
	
	public void deleteRecycle(RecycleInfo recycle);
	
	public void deleteFile(FileInfo fileInfo);
	
	public void clearRecycle(int userId);
	
	public void clearFile(int userId);

	public List<RecycleInfo> findAllRecycle(int userId);
	
	public FileInfo findFileById(int fileId);
	
	public List<FileInfo> findAllFile(int userId);
	
	public void updateFileStatus(FileInfo fileInfo);
	
	public void updateUsedSpace(UserInfo userInfo);
}
