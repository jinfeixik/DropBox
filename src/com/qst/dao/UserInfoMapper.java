package com.qst.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.qst.entity.UserInfo;

/**
 * @author 袁滢yuanying
 * @date 2019-8-28下午3:24:33
 * @version v1.0
 * 用户信息管理
 */
@Component
public interface UserInfoMapper {
	
	//添加一条用户信息
	public void addUserInfo(UserInfo userInfo);

	public UserInfo findUserInfoById(int userId);
	
	public UserInfo findUserInfoByName(UserInfo userInfo);
	
	public void updateUserUsedSize(UserInfo userInfo);
	
	public UserInfo findUserEamil(String userEmail);
	
	//根据用户名查找用户
	public UserInfo findUserName(String userName);
	
	//根据用户id查找用户
	public UserInfo findMemberById(int userId);
	
	////根据用户名修改用户密码
	public void updatePwdByName(UserInfo userInfo);
	
	//编辑用户信息
	public void updateUserInfo(UserInfo userInfo);
	
    
    public void updateUsers(UserInfo userInfo);
    
    public UserInfo findUserInfoByEmail(String userEmail);
	
}




