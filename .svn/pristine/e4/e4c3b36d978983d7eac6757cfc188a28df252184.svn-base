package com.qst.service;


import com.qst.entity.UserInfo;
/**
 * @author 袁滢yuanying
 * @date 2019-8-28下午3:58:06
 * @version v1.0
 * 用户管理
 */

public interface UserInfoService {
	
	/**
	 * @param userInfo
	 * 添加一条用户记录
	 */
	public void addUserInof(UserInfo userInfo);

	/**
	 * @param userInfo
	 * 查找用户名
	 */
	public UserInfo findUserInfoByName(UserInfo userInfo);
	
	/**
	 * @param userInfo
	 * 通过邮箱查找用户信息
	 */
	public UserInfo findUserEamil(String userEmail);
	
	/**
	 * @param userInfo
	 * 通用户名查找用户信息
	 */
	public UserInfo findUserName(String userName);
	
	/**
	 * @param userInfo
	 * 通用户id查找用户信息
	 */
	public UserInfo findMemberById(int userId);
	
	/**
	 * @param userInfo
	 * 通用户名修改用户密码
	 */
	public void updatePwdByName(UserInfo userInfo);
	
	/**
	 * @param userInfo
	 * 编辑用户信息
	 */
	public void updateUserInfo(UserInfo userInfo);
	
	/**
	 * @param userId
	 * 通过用户id查找用户信息
	 */
	public UserInfo findUserInfoById(int userId);

	/**
	 * @param 
	 * 创建订单号
	 */
	String createOrderNum();
	 
	/**
	 * @param userInfo
	 * 修改用户信息
	 */
	 public void updateUsers(UserInfo userInfo);
	 
	 /**
	  * 根据邮箱号查询用户信息
	  * @param userEmail
	  * @return
	  */
	 public UserInfo findUserInfoByEmail(String userEmail);
}
