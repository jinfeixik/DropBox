package com.qst.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qst.dao.FolderInfoMapper;
import com.qst.entity.FolderInfo;
import com.qst.service.FindAllFolderService;


@Service
public class FindAllFolderServiceImpl implements FindAllFolderService{
    
	
	@Autowired
	FolderInfoMapper folderInfoDao;
	
	
	
	@Override
	public List<FolderInfo> findFolder(HttpServletRequest request) {
			
			 int  userId=(Integer) request.getSession().getAttribute("userId");
		
		     //int userId=1;
			
			 System.out.println("userId为："+userId);
			
			 FolderInfo folderInfo = new FolderInfo();
			 
			 folderInfo.setUserId(userId);
			 
			 folderInfo.setFolderParentFolderId(0);
			
			 List<FolderInfo> folderInfos=folderInfoDao.findAllFolder(folderInfo);
			 
			 System.out.println("所有文件："+folderInfos);
						
			return folderInfos;
	}



	@Override
	public List<FolderInfo> findFolder(FolderInfo folderInfo) {
		List<FolderInfo> folderInfos=folderInfoDao.findAllFolder(folderInfo);
		return folderInfos;
	}
	
	

}
