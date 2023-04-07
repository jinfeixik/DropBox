package com.qst.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qst.entity.FolderInfo;

/**
 * 
 * @author 李阳liyang
 * @date 2019-8-29下午9:38:33
 * @version v1.0
 */

public interface FindAllFolderService {
	
	
	
	public List<FolderInfo> findFolder(HttpServletRequest request);
	
	/**
	 * @param folderInfo
	 * @return
	 * 查询用户userid的文件夹 folderId下的文件夹
	 */
	public List<FolderInfo> findFolder(FolderInfo folderInfo);

}
