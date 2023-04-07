package com.qst.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qst.entity.UserInfo;
import com.qst.service.UserInfoService;

@Controller
public class RegisterCheckController {

	@Autowired
	private UserInfoService userService;

	@RequestMapping("/isUserRegister.form")
	@ResponseBody
	public String isRegister(HttpServletRequest request) {
		String userName = request.getParameter("userName");
		System.out.println("用户名" + userName);
		String flag = null;
		if (userService.findUserName(userName) != null) {
			flag = "R";
			System.out.println("用户名已存在");
		} else {
			if (userName.equals("")) {
				flag = "Z";
				System.out.println("用户名为空");
			} else if (userName.length() < 3) {
				flag = "S";
				System.out.println("用户名过短");
			} else if (userName.length() > 16) {
				flag = "L";
				System.out.println("用户名过长");
			} else {
				flag = "Y";
				System.out.println("用户名可用");
			}
		}
		return flag;
	}

	@RequestMapping("/isPwdCheck.form")
	@ResponseBody
	public String isPwd(HttpServletRequest request) {
		String pwd = request.getParameter("userPassword");
		System.out.println("密码" + pwd);
		String flag = null;
		char[] p = pwd.toCharArray();
		for (int i = 0; i < pwd.length(); i++) {
			if (p[i] == ' ') {
				flag = "K";
				System.out.println("密码格式错误，不含有空格");
				break;
			}
		}
		if (pwd.equals("")) {
			flag = "Z";
			System.out.println("密码不能为空");
		} else if (pwd.length() < 6 || pwd.length() > 14) {
			flag = "S";
			System.out.println("密码长度错误，由6-14位字符组成");
		} else {
			flag = "Y";
			System.out.println("密码可用");
		}
		return flag;

	}
	
	@RequestMapping("/isEmailCheck.form")
	@ResponseBody
	public String isEmail(HttpServletRequest request) {
		String mail = request.getParameter("userEmail");
		System.out.println("邮箱" + mail);
		String flag = null;
		String reg="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
		System.out.println("?????"+mail.matches(reg));
		   if(userService.findUserEamil(mail)!=null){
			     flag="R";
			System.out.println("邮箱号已存在");
		    }
			if(mail.equals("")){
				flag ="N";
				System.out.println("邮箱号不能为空");
			}
			if (mail.matches(reg)==true) {
				flag = "Y";
				System.out.println("邮箱可用");
			} else {
				flag = "S";
				System.out.println("邮箱格式有误");
			}
		
		return flag;
	}
}