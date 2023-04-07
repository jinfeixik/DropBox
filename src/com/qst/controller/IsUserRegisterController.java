package com.qst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qst.entity.UserInfo;
import com.qst.service.UserInfoService;

@Controller
public class IsUserRegisterController {

	@Autowired
	private UserInfoService userService;

	@RequestMapping("/isRegisterUser.form")
	@ResponseBody
	public String isRegisterEmail(HttpServletRequest request) {
		String uname = request.getParameter("userName");
		/* String pwd = request.getParameter("userPassword"); */
		System.out.println("username哈哈哈 " + uname);
		String flag = "N";
		if (userService.findUserName(uname) != null) {
			flag = "Y";
			System.out.println("用户名wei" + uname);
			/*
			 * if(pwd.equals(user.getUserPassword())){ flag = "Y";
			 * System.out.println("密码为："+pwd); }else{
			 * System.out.println("密码输入错误"); }
			 */
		} else {
			System.out.println("该用户不存在");
		}
		return flag;
	}

	@RequestMapping("/isRegisterUserPwd.form")
	@ResponseBody
	public String isRegisterUserPwd(HttpServletRequest request) {
		String uname = request.getParameter("userName");
		String pwd = request.getParameter("userPassword");
		String flag = "N";
		UserInfo userInfo = userService.findUserName(uname);
		System.out.println("xxxxx:"+userInfo);
		if(userInfo!=null){
		if (userInfo.getUserPassword().equals(pwd)) {
			flag = "Y";
			System.out.println("密码为：" + pwd);
		} else {
			System.out.println("密码输入错误");
		}
		}
		return flag;
	}

}
