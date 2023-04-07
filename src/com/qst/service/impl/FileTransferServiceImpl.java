package com.qst.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.dao.FileInfoMapper;
import com.qst.dao.FileTransferMapper;
import com.qst.entity.FileInfo;
import com.qst.entity.FileTransfer;
import com.qst.service.FileTransferService;
import com.qst.util.TimeUtil;


/**
 * @author 赵海庭（zhaohaiting）
 * @date 2019-9-4上午10:47:09
 * @version v1.0
 */
@Service
public class FileTransferServiceImpl implements FileTransferService{
	@Autowired
	FileInfoMapper fileInfoDao;
	@Autowired
	FileTransferMapper fileTransferDao;
	//单个文件传输列表属性赋值
	@Override
	public void oneStartValue(int fileId) {
		
		FileTransfer ft=new FileTransfer();
		
		FileInfo finfo=fileInfoDao.findFileInfo(fileId);
	
		ft.setFileId(finfo.getFileId());
	
		ft.setTransferFileSize(finfo.getFileSize());
		
		ft.setTransferProgress(100);
		ft.setTransferStatus(2);
		ft.setTransferTime(TimeUtil.time2Timestamp());
		ft.setTransferUploadaAndDownloadFlag(2);
		ft.setUserId(1);//暂设userID为1 后期从session中获取
		ft.setTransferFileName(finfo.getFileName());
	    System.out.println(ft.toString());
	    
		fileTransferDao.addTransferDao(ft);

	}
	
	
   //已知当前用户id，查出用户所有传输列表
	@Override
	public List<FileTransfer> findUserAllFileTransferList(int i) {
	
		return fileTransferDao.findUserAllFileTransferList(i);
		
	}

   //删除单个传输记录
	@Override
	public void delTransferList(int fileTransferLsitId) {
	fileTransferDao.delTransferList(fileTransferLsitId);
	}

//删除所有传输记录
	@Override
	public void delUserAllTransferList(int userId) {
		
		fileTransferDao.delUserAllTransferList(userId);
	}


	@Override
	public void addTrandsferDao(FileTransfer ft) {
		fileTransferDao.addTransferDao(ft); 
		
	}


	

}
