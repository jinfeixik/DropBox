package com.qst.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.qst.entity.MemberInfo;
import com.qst.entity.UserInfo;
import com.qst.service.MemberInfoService;
import com.qst.service.UserInfoService;

@Controller
public class RegisterTestController {
	
	@Autowired
	private  UserInfoService userService;
	@Autowired
	private MemberInfoService memberService;
	
	
	@RequestMapping("registerTo.form")
	public String registerTo() {
		return "RegisterTest";
	}
	
	@RequestMapping("registerTest.form")
	public ModelAndView register(UserInfo userInfo,MemberInfo memberInfo) {
		Map <String, String> map = new HashMap<String, String>();
		if(userInfo.getUserEmail() != null) {
			userService.addUserInof(userInfo);
			
			UserInfo userInfo2  = userService.findUserInfoByName(userInfo);
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = new Date();
			System.out.println("当前按时间"+sdf.format(date));
			String dateStr = sdf.format(new Date(date.getTime() + (long)30 * 24 * 60 * 60 * 1000));
			try {
				date = sdf.parse(dateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Timestamp time=new Timestamp(date.getTime());
			System.out.println("string"+dateStr);
			System.out.println("会员截止时间"+time);
			
			memberInfo.setUserId(userInfo2.getUserId());
			memberInfo.setMemberStatus(0);
			memberInfo.setMemberStartTime(userInfo2.getUserRegisterTime());
			memberInfo.setMemberEndTime(time);
			memberService.addMemberInfo(memberInfo);
			map.put("hello", "添加成功");
		} else {
			map.put("hello", "没有输入用户信息");
		}
		return new ModelAndView("userNamePasswordLogin", map);
	}

}
