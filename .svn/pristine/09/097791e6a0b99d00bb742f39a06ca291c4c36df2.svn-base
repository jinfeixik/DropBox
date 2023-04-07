package com.qst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qst.dao.UserInfoMapper;
import com.qst.entity.UserInfo;

@Controller
public class HelloController {
	
	@Autowired
	UserInfoMapper userInfodao;
	
	@RequestMapping("hello.form")
	public String hello(ModelMap map) {
		
		UserInfo user = userInfodao.findUserInfoById(1);
		if(user != null) {
		System.out.println(user);
		} else {
			System.out.println("没有");
		}
		
		return "index";
	}

}
