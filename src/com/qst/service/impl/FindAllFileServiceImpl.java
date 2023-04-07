package com.qst.service.impl;

import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.dao.FileInfoMapper;
import com.qst.entity.FileInfo;
import com.qst.entity.FolderInfo;
import com.qst.entity.UserInfo;
import com.qst.service.FindAllFileService;

@Service
public class FindAllFileServiceImpl implements FindAllFileService{

	@Autowired
	FileInfoMapper fileInfoDao;
	
	@Override
	public List<FileInfo> findFileType(int fileType) {
        
		
		
		return null;
	}

	@Override
	public List<FileInfo> findFile(HttpServletRequest request) {
		
		
		
        System.out.println("service获取的userId为："+request.getSession().getAttribute("userId"));
		
        int userId=(Integer) request.getSession().getAttribute("userId");
        
        //int userId=1;
		
		FileInfo fileInfo = new FileInfo();
		 
		fileInfo.setUserId(userId);
		 
		fileInfo.setFolderId(0);
		
		System.out.println("userId为："+userId);
		
		System.out.println("所有文件："+fileInfoDao.findAllFile(fileInfo));
			
		List<FileInfo> fileInfos=fileInfoDao.findAllFile(fileInfo);
			
		
		return fileInfos;
	}

	@Override
	public List<FileInfo> findFile1(HttpServletRequest request) {
		
		
        //int userId=1;
		
		//request.getSession().setAttribute("userId", userId);
		
		int userId=(Integer) request.getSession().getAttribute("userId");
		
		System.out.println("userId为："+userId);
		
		System.out.println("所有文件："+fileInfoDao.findAllFile1(userId));
		
		List<FileInfo> fileInfos=fileInfoDao.findAllFile1(userId);
			
		
		return fileInfos;
	}

	@Override
	public List<FileInfo> findFile(FileInfo fileInfo) {
		 
			
			System.out.println("所有文件："+fileInfoDao.findAllFile(fileInfo));
				
			List<FileInfo> fileInfos=fileInfoDao.findAllFile(fileInfo);
				
			
			return fileInfos;
	}

	@Override
	public double findVolume(HttpServletRequest request) {
		// TODO Auto-generated method stub
		int userId=(Integer) request.getSession().getAttribute("userId");
		
		double number=fileInfoDao.findVolume(userId);
		
		double vol=number/1024;
		
		DecimalFormat df = new DecimalFormat("0.0");
		
		double volume=Double.parseDouble(df.format(vol));
		
		System.out.println("当前空间占用为："+volume+"M");
		
		return volume;
	}

	
}
