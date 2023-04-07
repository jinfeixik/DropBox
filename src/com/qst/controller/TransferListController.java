package com.qst.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qst.dao.FileInfoMapper;
import com.qst.entity.FileInfo;
import com.qst.entity.FileTransfer;
import com.qst.entity.UserInfo;
import com.qst.service.FileInfoService;
import com.qst.service.FileTransferService;
import com.qst.vo.FileTransferLsit;

@Controller
public class TransferListController {
	@Autowired
	FileTransferService fileTransferService;

	@Autowired
	FileInfoMapper fileDao;
	
	@Autowired
	FileInfoService fileInfoService;
	
	@RequestMapping("transferList.form")
	public String transferList(ModelMap map,HttpServletRequest request){
		System.out.println("进入传输列表");
		
		HttpSession session = request.getSession();
		UserInfo user=(UserInfo) session.getAttribute("user");
		//得到当前用户id
		int i=user.getUserId();
		//查出当前用户所有传输列表
		List<FileTransfer> fs=fileTransferService.findUserAllFileTransferList(i);

		List<FileTransferLsit> fileTransferLsits = new ArrayList<FileTransferLsit>();
        int sum=0;
		//对信息进行处理
		for(FileTransfer f:fs){
		
			FileTransferLsit fileTransferLsit=new FileTransferLsit();
			fileTransferLsit.setFileTransferLsitId(f.getTransferId());
			//根据文件id，查出文件信息
		    FileInfo fileInfo=fileInfoService.findFileInfo(f.getFileId());
		    System.out.println("?????"+fileInfo.getFileType());
   	        if(f.getFileId()!=0){
		      fileTransferLsit.setFileType(fileInfo.getFileType());
			}
			else{
				fileTransferLsit.setFileType(0);
				
			}
   	 	    System.out.println(f.getTransferFileName());
			fileTransferLsit.setFileName(f.getTransferFileName());
			fileTransferLsit.setFileSize(f.getTransferFileSize());
			
			fileTransferLsit.setFileTime(f.getTransferTime());
		
			fileTransferLsit.setTransferUploadaAndDownloadFlag(f.getTransferUploadaAndDownloadFlag());
		
			fileTransferLsit.setStatus(f.getTransferStatus());
			
			fileTransferLsit.setFileId(f.getFileId());
		    sum++;
			fileTransferLsits.add(fileTransferLsit);
		}

		session.setAttribute("fileTransferLsit", fileTransferLsits);
		session.setAttribute("sum",sum);
	
		return "transfer";
	}
	
	
	
}
