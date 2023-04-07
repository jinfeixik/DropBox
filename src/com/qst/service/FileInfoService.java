package com.qst.service;

import com.qst.entity.FileInfo;
import com.qst.entity.UserInfo;

/**
 * @author 袁滢yuanying
 * @date 2019-8-28下午7:34:07
 * @version v1.0
 * 文件信息管理
 */
public interface FileInfoService {
	
	
	/**
	 * @param fileInfo
	 * @param userInfo
	 * 上传文件
	 */
	public int addFileInfo(FileInfo fileInfo, UserInfo userInfo);
	
	/**
	 * @param name
	 * @return
	 * 查找fileInfo中有无name信息 false 没有   /true 有
	 */
	public boolean findFileInfoByName(String name, int parentId);

	public FileInfo findFileInfo(int fileId);
	
	/**
	 * @param id
	 * 删除文件信息
	 */
	public void deleteFileById(Integer id);
	
	/**
	 * @param fileInfo'
	 * 修改文件的文件夹id（移动）
	 */
	public void  updateParentId(FileInfo fileInfo);

	/**
	 * @param fileInfo
	 * 复制文件
	 */
	public void addCopyFileInfo(FileInfo fileInfo);

}
