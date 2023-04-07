package com.qst.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.qst.dao.FileInfoMapper;
import com.qst.dao.UserInfoMapper;
import com.qst.entity.FileInfo;
import com.qst.entity.UserInfo;
import com.qst.service.FileInfoService;
import com.qst.util.TimeUtil;
@Service
public class FileInfoServiceImpl implements FileInfoService{

	@Autowired
	FileInfoMapper fileDao;
	
	@Autowired
	UserInfoMapper userDao;

	
	@Override
	public int addFileInfo(FileInfo fileInfo, UserInfo userInfo) {
		
		fileInfo.setFileStatus(1);//默认为正常1
		
		fileInfo.setUploadTime(TimeUtil.time2Timestamp());
		
		System.out.println("文件信息：" +fileInfo.toString());
		//增加fileId，保存文件id
		fileDao.addFileInfo(fileInfo);

		
		double size = fileInfo.getFileSize() + userInfo.getUsedSpace();
		userInfo.setUsedSpace(size);//改变已用空间大小
		userDao.updateUserUsedSize(userInfo);
	    
		return fileInfo.getFileId();
		
	}
	@Override
	public FileInfo findFileInfo(int fileId) {
		
		return fileDao.findFileInfo(fileId);
	
	}
	@Override
	public boolean findFileInfoByName(String name, int panrentId) {
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(name);
		fileInfo.setFolderId(panrentId);
		
		
		if(fileDao.findFileInfoByName(fileInfo).size() == 0 ) {
			return false;
		} else {
			return true;
		}
	}
	@Override
	public void deleteFileById(Integer id) {
		
		fileDao.deleteFileById(id);
		
	}
	@Override
	public void updateParentId(FileInfo fileInfo) {
		fileDao.updateParentId(fileInfo);
		System.out.println(fileInfo.toString());
		System.out.println("修改成功");
		
	}
	@Override
	public void addCopyFileInfo(FileInfo fileInfo) {
		fileDao.addFileInfo(fileInfo);
		System.out.println("复制文件信息成功" +fileInfo.toString());
		
	}


}
