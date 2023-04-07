package com.qst.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.qst.entity.UserInfo;
import com.qst.service.UserInfoService;

@Controller
public class UploadImageController {
   
	@Autowired
	private UserInfoService userService;
	
	@RequestMapping("updateUserInfo.form")
	public String updateUserInfo(@RequestParam("some") MultipartFile file,HttpServletRequest request,Model model){
		System.out.println("进入信息编辑");
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("user");
		System.out.println("用户id"+userInfo.getUserId());
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		System.out.println("userName"+userName+" userEmail:"+userEmail);
		//获取指定目录的相对路径
		  String path =  request.getSession().getServletContext().getRealPath("aaa");
		  
		  //获取源文件名
		  String fileName = file.getOriginalFilename();
		  model.addAttribute("image", "aaa/"+fileName);
		  System.out.println("文件位置:" +"aaa/"+fileName);
          File file1 = new File(path, fileName);
          //文件路径
          String filepath = "aaa/"+fileName;
		  try {
		   file.transferTo(file1);
		   
		  } catch (Exception e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  userInfo.setUserAvatar(filepath);
          userInfo.setUserName(userName);
          userInfo.setUserEmail(userEmail);   
		userService.updateUserInfo(userInfo);
	    UserInfo userInfo2 =  userService.findUserInfoById(userInfo.getUserId());
	    System.out.println("编辑后的用户信息："+userInfo2.toString());
		HttpSession session2 = request.getSession();
		session2.setAttribute("user", userInfo2);
		session2.setAttribute("image", userInfo2.getUserAvatar());
		session2.setAttribute("userName", userInfo2.getUserName());
		session2.setAttribute("userEmail", userInfo2.getUserEmail());
		session2.setAttribute("used", userInfo.getUsedSpace());
		session2.setAttribute("total", userInfo.getTotalSpace());
			
		return "personalInfo";
	}
}
