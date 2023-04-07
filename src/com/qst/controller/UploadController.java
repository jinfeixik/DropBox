package com.qst.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.qst.entity.FileInfo;
import com.qst.entity.FileTransfer;
import com.qst.entity.UserInfo;
import com.qst.service.FileInfoService;
import com.qst.service.FileTransferService;
import com.qst.util.FileType;
import com.qst.util.FileTypeJudge;
import com.qst.util.FileUtil;
import com.qst.util.Office2Util;
import com.qst.vo.FileTransferLsit;

/**
 * @author 袁滢yuanying
 * @date 2019-8-29上午10:17:00
 * @version v1.0
 * 文件上传
 */
@Controller
public class UploadController {

	@Autowired
	FileInfoService fileInfoService;
	
	@Autowired
	FileTransferService fileTransferService;
	
	@RequestMapping("upload.form")
	public String uploadFiles(@RequestParam("files") MultipartFile files[], HttpServletRequest request, int parentId) {
		
		System.out.println("上传多个文件");
		for(MultipartFile file  :files) {
			System.out.println(file.getOriginalFilename());
			if(uploadFile(file, request, parentId) == null) {
				System.out.println("aaa");
				return "redirect:/listAllFile.form";
			}
		}
		System.out.println("aaa");
		return "redirect:/listAllFile.form";
	}
	
	
	
	/**
	 * @param file
	 * @param request
	 * @param model
	 * @param folderId
	 * @return
	 * 上传单个文件
	 */
	public String uploadFile(MultipartFile file, HttpServletRequest request, int parentId) {
		System.out.println("上传文件");
		
		if(file == null || file.isEmpty()) {
			return null;
		}
	
		FileInfo fileInfo = new FileInfo();
		//获取用户
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("user");
		/*System.out.println("用户信息");
		System.out.println(userInfo.toString());
		System.out.println("....");*/
		fileInfo.setUserId(userInfo.getUserId());
		
		System.out.println("上传文件");
		//获取指定目录的相对路径
		String path =  request.getSession().getServletContext().getRealPath("upload");
		
		//计算文件大小
		BigDecimal size = new BigDecimal(file.getSize());
		BigDecimal mod = new BigDecimal(1024);
		double size1 = size.divide(mod).divide(mod).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("文件实际大小 = " +size +", 文件大小 = " +size1);
		
		//获取源文件名
		String fileName = file.getOriginalFilename();
		
		if(fileInfoService.findFileInfoByName(fileName, parentId)) {
			fileName = (new Date()).getTime() +fileName;
		}
		System.out.println("文件名为:" +fileName);
		//model.addAttribute("url", "upload/"+fileName);
		//System.out.println("文件位置:" +"upload/"+fileName);
		File file1 = new File(path, fileName);
		
		
		fileInfo.setFileName(fileName);
		fileInfo.setFilePath("upload/"+fileName);
		fileInfo.setFileSize(size1);
		fileInfo.setFolderId(parentId);
		
		File toFile = null;
		InputStream ins = null;
		
		try {
			ins = file.getInputStream();
			
			//文件类型
			FileType type = FileTypeJudge.getType(ins);
			int temp = FileTypeJudge.isFileType(type);
			fileInfo.setFileType(temp);
			
			toFile = new File(file.getOriginalFilename());
			FileUtil.inputStreamToFile(ins, toFile);
			file.transferTo(file1);
			System.out.println((ins == null) + "========");
			
			//文件预览地址
			if(type == FileType.XLSX_DOCX || type == FileType.XLS_DOC) {
				String pdf =  Office2Util.office2pdf(toFile, request);
				fileInfo.setFileTransformPDF("upload/" +pdf);
			} else {
				fileInfo.setFileTransformPDF("upload/"+fileName);
			}
			System.out.println(fileInfo.toString());
			
			//zhaoHaiting得到插入数据自动增长的id
			int fileId=fileInfoService.addFileInfo(fileInfo, userInfo);
			System.out.println("fileId"+fileId);
			//zhaohaiting 添加上传数据至传输列表
		    FileTransfer fileTransfer =new FileTransfer(); 
		    fileTransfer.setFileId(fileId);
		    fileTransfer.setTransferFileName(fileName);
		    fileTransfer.setTransferFileSize(size1);
		    fileTransfer.setTransferProgress(100);
		    fileTransfer.setTransferStatus(2);
		    fileTransfer.setTransferTime(fileInfo.getUploadTime());
		    fileTransfer.setTransferUploadaAndDownloadFlag(1);
		    fileTransfer.setUserId(userInfo.getUserId());
			fileTransferService.addTrandsferDao(fileTransfer);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				ins.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "redirect:/listAllFile.form";
	}
	

}
