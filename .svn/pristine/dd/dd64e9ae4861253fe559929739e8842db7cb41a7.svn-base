package com.qst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qst.entity.UserInfo;
import com.qst.service.FileTransferService;

@Controller
public class DelUserAllTransferList {
	@Autowired
	FileTransferService fileTransferService;
	
	@RequestMapping(value="delUserAllTransferList.form")
	public String delTransferList(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		UserInfo user=(UserInfo) session.getAttribute("user");
		int userId=user.getUserId();
		fileTransferService.delUserAllTransferList(userId);
		
		return "redirect:transferList.form";	
	}
}
