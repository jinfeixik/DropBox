package com.qst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qst.entity.FileInfo;
import com.qst.service.FileInfoService;


@Controller
public class FileInfoController {

	
	@Autowired
	FileInfoService fileService;
	
	/**
	 * @param fileId
	 * @param parentId
	 * @return
	 * 修改文件位置（移动）
	 */
	@RequestMapping("/updateParentId")
	@ResponseBody
	public String updateParentId(Integer fileId, Integer parentId  ){
		
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileId(fileId);
		fileInfo.setFolderId(parentId);
		
		System.out.println("文件" +fileInfo.getFileId() +"移动到" +fileInfo.getFolderId() +"文件夹下");
		fileService.updateParentId(fileInfo);
		return "Y";
	}
	
	
	@RequestMapping("/copyFileInfo")
	@ResponseBody
	public String copyFileInfo(Integer fileId, Integer parentId  ){
		
		System.out.println("文件" +fileId +"移动到" +parentId +"文件夹下");
		
		FileInfo fileInfo = fileService.findFileInfo(fileId);
		System.out.println("复制文件信息" +fileInfo.toString());
		if(fileInfo.getFolderId() == parentId) {
			return "N";
		} else {
			fileInfo.setFolderId(parentId);
			fileService.addCopyFileInfo(fileInfo);
			return "Y";
		}
	}
	
	
	
	
	
	
}
