package com.qst.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qst.entity.FolderInfo;

/**
 * @author 袁滢yuanying
 * @date 2019-8-29下午10:22:27
 * @version v1.0
 * 文件夹管理
 */
public interface FolderInfoService {

	/**
	 * @param folderInfo
	 *添加文件夹
	 */
	public void addFolderInfo(FolderInfo folderInfo);
	
	/**
	 * @param folderInfo
	 * 修改文件夹名字
	 */
	public void updateFolderName(FolderInfo folderInfo);
	
	
	public boolean findFolderInfoByName(String folderName);
	
	/**
	 * @param id
	 * 删除文件夹信息  并把文件夹的子文件夹删除，文件放入回收站
	 */
	public void deleteFolderInfo(Integer id);
	
	
	/**
	 * @param request
	 * @return
	 * 查找用户的所有文件夹
	 */
	public List<FolderInfo> findFolder(HttpServletRequest request);
	
	
	
	
}
