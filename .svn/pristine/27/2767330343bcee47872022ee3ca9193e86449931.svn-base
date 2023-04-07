package com.qst.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.qst.entity.FileInfo;

/**
 * @author 袁滢yuanying
 * @date 2019-8-28下午3:34:00
 * @version v1.0
 * 文件管理
 */

public interface FileInfoMapper {
	
	/**
	 * 
	 * @param request
	 * @return
	 * 空间占用
	 */
	
	public double findVolume(int userId);
	
	public List<FileInfo> findFileByType(int fileType);
	
	public List<FileInfo> findAllFile(FileInfo fileInfo);
	
	public List<FileInfo> findAllFile1(int userId);
	
	public List<FileInfo> findFileBySearch(FileInfo fileInfo);
	
	/**
	 * @param fileName
	 * @return
	 * 查找数据库中是否存在文件名
	 */
	public List<FileInfo> findFileInfoByName(FileInfo fileInfo);
	
	/**
	 * @param fileInfo
	 * 给上传文件添加记录
	 */
	public int addFileInfo(FileInfo fileInfo);


	public FileInfo findFileInfo(int fileInfo);


	
	/**
	 * @param id
	 * 删除文件信息
	 */
	public void deleteFileById(Integer id);
	
	
	public void updateParentId(FileInfo fileInfo);
	
	/**
	 * @param fileInfo
	 * @return
	 * 查询用户userid的文件夹 folderId下的文件
	 */
	public List<FileInfo> findFileInfoByParentYY(FileInfo fileInfo);
	
	
}
	




