package com.qst.controller;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qst.entity.MemberInfo;
import com.qst.entity.UserInfo;
import com.qst.service.MemberInfoService;
import com.qst.service.UserInfoService;
import com.qst.util.Code;
import com.qst.util.Email;

/**
 * @author 袁滢yuanying
 * @date 2019-8-29下午5:53:07
 * @version v1.0
 * 登录
 */
@Controller
public class LoginController {
	
	@Autowired
	private  UserInfoService userService;
	@Autowired
	private  MemberInfoService memberService;
	/**
	 * @param userInfo
	 * @param request
	 * @return
	 * 登录（用户名和密码）
	 */
	@RequestMapping("login.form")
	 public String loginTo(UserInfo userInfo, HttpServletRequest request){
	  System.out.println(userInfo.toString());
	  UserInfo user = userService.findUserInfoByName(userInfo);
	  HttpSession session = request.getSession();
	  UserInfo userInfoccc=(UserInfo) request.getSession().getAttribute("user");
	  if(userInfoccc!=null){
	   return "redirect:/listAllFile.form";
	  }
	  else if(user != null) {
	   //HttpSession session = request.getSession();
	   session.setAttribute("user", user);
	   request.getSession().setAttribute("userId", user.getUserId());
	   System.out.println("session中存的id为："+session.getAttribute("userId"));
	   System.out.println("登录成功");
	   System.out.println(user.toString());
	   return "redirect:/listAllFile.form";
	  }else{
	   return "userNamePasswordLogin";
	  }
	 
	  
	 }
	 @RequestMapping("loginOut.form")
	 public String loginOut(HttpServletRequest request){
	  
	  HttpSession session = request.getSession();
	  session.invalidate();
	  
	  return "userNamePasswordLogin";
	 }
	/**
	 * @param userInfo
	 * @param request
	 * @return
	 * 登录（邮箱快捷登录）
	 */
	@RequestMapping("login1.form")
	public String emailLoginTo(String emailcode,HttpServletRequest request){
		
		/*HttpSession session = ServletActionContext.getRequest().getSession();
		String code = (String) session.getAttribute("code");*/
		
		HttpSession session =  request.getSession();
		String code = (String) session.getAttribute("code");
		System.out.println("输入code:"+code+"****"+"emailcode:"+emailcode);
        
		
		if(emailcode.equalsIgnoreCase(code)){
			System.out.println("登录成功");
			
			return "redirect:/listAllFile.form";
		}else{
			session.invalidate();
			System.out.println("登录失败");
			return "emailLogin";
		}
		
	}
	
	@ResponseBody
	@RequestMapping("sendEmail.form")
	public String sendEmail(HttpServletRequest request){
		String userEmail = request.getParameter("userEmail");
		/*System.out.println("userEmail "+userEmail);*/
		UserInfo userInfo = userService.findUserEamil(userEmail);
		
		HttpSession session =  request.getSession();
		session.setAttribute("user", userInfo);
		session.setAttribute("userId", userInfo.getUserId());
		
		//System.out.println("邮箱"+userInfo.getUserEmail());
		String ss = Code.getNumber(4);
		try {
			Email.send(userEmail, ss);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("code", ss);
		return ss;
	}


	

	
	

}
