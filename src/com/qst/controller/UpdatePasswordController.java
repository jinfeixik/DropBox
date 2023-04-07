package com.qst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.components.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qst.entity.UserInfo;
import com.qst.service.UserInfoService;

@Controller
public class UpdatePasswordController {

	@Autowired
	private UserInfoService userService;

	/*
	 * @RequestMapping("updatePwd.form") public String
	 * updatePwd(HttpServletRequest request) { HttpSession session =
	 * request.getSession(); UserInfo userInfo = (UserInfo)
	 * session.getAttribute("userInfo"); System.out.println("用户名：" +
	 * userInfo.getUserName()); userService.updatePwdByName(userInfo); return
	 * "updatepassword"; }
	 */

	@RequestMapping("checkP1.form")
	@ResponseBody
	public String checkP1(HttpServletRequest request) {
		String flag = null;
		String pwd = request.getParameter("userPassword");
		System.out.println("pwd:" + pwd);
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("user");
		UserInfo userInfo2 = userService.findUserName(userInfo.getUserName());
		if (pwd.equals(userInfo2.getUserPassword())) {
			flag = "Y";
			System.out.println("密码正确12345");
		} else {
			flag = "N";
			System.out.println("密码错误12345");
		}
		return flag;
	}

	@RequestMapping("checkPwd.form")
	@ResponseBody
	public String checkPwd(HttpServletRequest request) {
		String flag = "Y";
		String pwd2 = request.getParameter("password2");
		if (pwd2.length() < 6 || pwd2.length() > 14) {
			flag = "S";
			System.out.println("密码长度错误，由6-14位字符组成");
		}
		HttpSession session = request.getSession();
		UserInfo userInfo = (UserInfo) session.getAttribute("user");
		userInfo.setUserPassword(pwd2);
		System.out.println("&&&&&&&&&&&&&"+userInfo.toString());
		userService.updatePwdByName(userInfo);
		System.out.println("密码修改成功"+userInfo.getUserPassword());
		return flag;
	}

}
