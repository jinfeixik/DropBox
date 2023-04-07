package com.qst.dao;


import com.qst.entity.FolderInfo;
import java.util.List;


/**
 * @author 袁滢yuanying
 * @date 2019-8-28下午3:32:54
 * @version v1.0
 * 文件夹管理
 */

public interface FolderInfoMapper {
	
	public List<FolderInfo> findAllFolder(FolderInfo folderInfo);
	
	public void addFolderInfo(FolderInfo folderInfo);
	
	/**
	 * @param folderInfo
	 * 修改文件夹名字
	 */
	public void updateFolderName(FolderInfo folderInfo);
	
	/**
	 * @param folderName
	 * @return
	 * 获取当前文件夹名是否存在
	 */
	public List<FolderInfo> findFolderInfoByName(String folderName);
	
	public List<FolderInfo> findFolderBySearch(FolderInfo folderInfo);
	
	
	/**
	 * @param id
	 * 删除文件夹
	 */
	public void deleteFolderById(Integer id);
	
	
	/**
	 * @param folderParentFolderId
	 * 根据父文件夹id删除文件夹
	 */
	public void deleteFolderParById(Integer folderParentFolderId);
	
	/**
	 * @param folderId
	 * 根据文件夹id修改状态信息
	 */
	public void updateFileByFolderId(Integer folderId);
	
	
	public List<FolderInfo> findFolderYY(Integer id);
	
	
	/**
	 * @param folderInfo
	 * @return
	 * 查询用户userid的文件夹 folderId下的文件夹
	 */
	public List<FolderInfo> findFolderFolderUserYY(FolderInfo folderInfo);
	
}
