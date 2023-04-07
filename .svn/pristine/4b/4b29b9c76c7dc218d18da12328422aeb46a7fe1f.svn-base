package com.qst.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qst.dao.FolderInfoMapper;
import com.qst.entity.FolderInfo;
import com.qst.entity.UserInfo;
import com.qst.service.FolderInfoService;
@Service
@Transactional
public class FolderInfoServiceImpl implements FolderInfoService{

	@Autowired
	FolderInfoMapper folderDao;
	
	@Transactional
	@Override
	public void addFolderInfo(FolderInfo folderInfo) {

		folderDao.addFolderInfo(folderInfo);

	}


	@Override
	public void updateFolderName(FolderInfo folderInfo) {

		folderDao.updateFolderName(folderInfo);
		
	}


	@Override
	public boolean findFolderInfoByName(String folderName) {
		
		if(folderDao.findFolderInfoByName(folderName).size() == 0) {
			return false;
		} else {
			return true;
		}
	}


	@Override
	public void deleteFolderInfo(Integer id) {

		folderDao.deleteFolderById(id);
		folderDao.deleteFolderParById(id);
		folderDao.updateFileByFolderId(id);
		
		
	}


	@Override
	public List<FolderInfo> findFolder(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("user");
		
		//System.out.println("用户信息为：" +userInfo.toString());
		
		return folderDao.findFolderYY(userInfo.getUserId());
	}


}
