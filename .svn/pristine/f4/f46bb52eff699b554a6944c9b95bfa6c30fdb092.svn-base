package com.qst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qst.service.FileTransferService;

/**
 * @author 赵海庭（zhaohaiting）
 * @date 2019-9-4上午10:36:30
 * @version v1.0
 */

@Controller
public class DeleteTransferList {
	@Autowired
	FileTransferService fileTransferService;
	@RequestMapping(value="delTransferList.form",method=RequestMethod.GET)
	public String delTransferList(HttpServletRequest request, HttpServletResponse response){
		System.out.println("进入删除单个文件 DeleteTransferList");
		
		//得到当前传输列表文件id
		int fileTransferLsitId=Integer.parseInt(request.getParameter("fileTransferLsitId"));
		//删除记录
		fileTransferService.delTransferList(fileTransferLsitId);
		
		return "redirect:transferList.form";		
	}
}
