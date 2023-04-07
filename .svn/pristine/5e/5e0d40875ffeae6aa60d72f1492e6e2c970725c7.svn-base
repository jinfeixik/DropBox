package com.qst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qst.service.UserInfoService;


@Controller
public class IsUserEmailRegisterController {

	@Autowired
	private UserInfoService userService;
	

	@RequestMapping("/isRegisterEmail.form")
	@ResponseBody
	public String isRegisterEmail(HttpServletRequest request){
		String userEmail = request.getParameter("userEmail");
		System.out.println("userEmail哈哈哈 " + userEmail);
		String flag = "N";
		if(userService.findUserEamil(userEmail)!=null){
			flag = "Y";
			System.out.println("用户信息"+userService.findUserEamil(userEmail).toString());
		}else{
			System.out.println("未找到该用户信息");
		}
		return flag;
	}
	
	@RequestMapping("/isCheckEmailCode.form")
	@ResponseBody
	public String isCheckEmailCode(HttpServletRequest request){
		String emailCode = request.getParameter("emailcode");
		System.out.println("验证码："+emailCode);
		String flag = "N";
		
		HttpSession session =  request.getSession();
		String code = (String) session.getAttribute("code");
		
		System.out.println("生成验证码"+code);
		if(code.equalsIgnoreCase(emailCode)){
			flag = "Y";
			System.out.println("验证码输入正确");
		}else{
			System.out.println("验证码输入错误");
		}
		return flag;
		
	}
}
