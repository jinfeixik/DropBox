package com.qst.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qst.dao.UserInfoMapper;
import com.qst.entity.UserInfo;
import com.qst.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	private UserInfoMapper userDao;
	@Transactional
	@Override
	public void addUserInof(UserInfo userInfo) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		Date date = new Date();
		
		Timestamp time = new Timestamp(date.getTime());
		System.out.println("time " +sdf.format(time));
		
		
		/*
		 * 未没有输入的字段赋初始值
		 */
		userInfo.setUserAvatar("aaa/timg.jpg");
		userInfo.setUserRegisterTime(time);
		userInfo.setTotalSpace(10*1024.0);
		userInfo.setUsedSpace(0.0);
		System.out.println(userInfo.toString());
		
		userDao.addUserInfo(userInfo);
		
	}
	
	@Transactional
	@Override
	public UserInfo findUserInfoByName(UserInfo userInfo) {
		return userDao.findUserInfoByName(userInfo);
	}
	
	@Override
	public UserInfo findUserEamil(String userEmail) {
		return userDao.findUserEamil(userEmail);
	}
	
	
	@Override
	public UserInfo findUserName(String userName) {
		UserInfo user = userDao.findUserName(userName);
		return user;
	}
	
	@Override
	public UserInfo findMemberById(int userId) {
		UserInfo userInfo =	userDao.findMemberById(userId);
		System.out.println("用户信息" + userInfo.toString());
		return userInfo;
	}
	@Override
	public void updatePwdByName(UserInfo userInfo) {
		userDao.updatePwdByName(userInfo);
		
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		userDao.updateUserInfo(userInfo);
		
	}

	@Override
	public UserInfo findUserInfoById(int userId) {
	  return  userDao.findUserInfoById(userId);
	}
	
	@Override
	public String createOrderNum(){
		int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
		int r2=(int)(Math.random()*(10));
		long now = System.currentTimeMillis();//一个13位的时间戳
		String paymentID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
		return paymentID;
	}


	@Override
	 public void updateUsers(UserInfo userInfo) {
	    userDao.updateUsers(userInfo);
	}

	@Override
	public UserInfo findUserInfoByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return  userDao.findUserInfoByEmail(userEmail);
		
	}
	

}
