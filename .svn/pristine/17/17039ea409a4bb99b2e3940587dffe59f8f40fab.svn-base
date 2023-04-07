package com.qst.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qst.entity.FolderInfo;
import com.qst.entity.UserInfo;
import com.qst.service.FolderInfoService;
import com.qst.util.FolderTreeUtil;
import com.qst.vo.FolderInfoYYVo;

@Controller
public class FolderController {
	
	@Autowired
	FolderInfoService folderService;
	
	/**
	 * @param folderName
	 * @param parentId
	 * @param request
	 * @return
	 * 添加文件夹
	 */
	@RequestMapping("addFolder.form")
	public String addFolder(String folderName, int parentId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("user");
		System.out.println(userInfo.toString());
		FolderInfo folderInfo = new FolderInfo();
		folderInfo.setFolderName(folderName);
		folderInfo.setFolderParentFolderId(parentId);
		folderInfo.setUserId(userInfo.getUserId());
		
		folderService.addFolderInfo(folderInfo);
		return "index";
	}
	
	
	/**
	 * @param folderInfo
	 * @param folderInfoName
	 * @return
	 * 修改文件夹名字
	 */
	@RequestMapping("updateFolderName.form")
	@ResponseBody
	public String updateFolderName(FolderInfo folderInfo, String folderInfoName) {
		
		System.out.println("文件夹信息" +folderInfo.toString());
		folderInfo.setFolderName(folderInfoName);
		System.out.println(folderInfo.toString());
		folderService.updateFolderName(folderInfo);
		return "Y";
	}
	
	
	@RequestMapping("/deleteFolderInfo.form")
	public String deleteFolderInfo(int folderId) {
		
		folderService.deleteFolderInfo(folderId);
		
		return "redirect:/listAllFile";
	}
	
	
	@RequestMapping("findFolderInfoYY.form") 
	@ResponseBody
	public List<FolderInfoYYVo> findFolderInfoYY(HttpServletRequest request){
		
		List<FolderInfo> folderInfos = folderService.findFolder(request);
		List<FolderInfoYYVo> folders = new ArrayList<FolderInfoYYVo>();
		FolderInfoYYVo v1 = new FolderInfoYYVo(0, null, "我的网盘");
		folders.add(v1);
		for(FolderInfo info : folderInfos) {
			FolderInfoYYVo v2 = new FolderInfoYYVo(info.getFolderId(), info.getFolderParentFolderId(), info.getFolderName());
			folders.add(v2);
		}
	//	folders = FolderInfoMenuUtil.transDepartment(folders);
		
		for(FolderInfoYYVo vo : folders) {
			System.out.println(vo.toString());
		}
		
		List<FolderInfoYYVo> trees = FolderTreeUtil.bulid(folders);
		
		
		return trees;
	}
	
	/*@RequestMapping("findFolderInfoY")
	public String findFolderInfoY(HttpServletRequest request) {
		List<FolderInfo> folders = folderService.findFolder(request);
      //  JSONArray jsonArray = JSONArray.fromObject(folders);  
		
		
		
		return "index";
	}*/
	
	
	
}
