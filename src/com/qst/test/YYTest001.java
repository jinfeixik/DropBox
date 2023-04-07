package com.qst.test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qst.dao.UserInfoMapper;
import com.qst.entity.UserInfo;


public class YYTest001 extends Thread{

	
	
	public static void test(YYTest001 test){
		
	}
	
	public static void main(String[] args) {
		YYTest001 t = new YYTest001();
		t.run();
		
	}
	public void start() {
		System.out.println();
	}
	
	
}
