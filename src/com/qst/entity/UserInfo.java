package com.qst.entity;

import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author 袁滢yuanying
 * @date 2019-8-28下午3:22:55
 * @version v1.0
 * 用户信息表
 */
public class UserInfo {
	
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userEmail;
	private Timestamp userRegisterTime;
	private Double usedSpace;
	private String code;
	

	private Double totalSpace;
	private String userAvatar;//头像地址
	
	
	private MemberInfo userMemberInfo;
	/* private MultipartFile file;
*/
	public UserInfo() {
		super();
	}
	
	
	public UserInfo(Integer userId, String userName, String userPassword,
			String userEmail, Timestamp userRegisterTime, Double usedSpace,
			Double totalSpace, String userAvatar) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userRegisterTime = userRegisterTime;
		this.usedSpace = usedSpace;
		this.totalSpace = totalSpace;
		this.userAvatar = userAvatar;
	}


	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Timestamp getUserRegisterTime() {
		return userRegisterTime;
	}
	public void setUserRegisterTime(Timestamp userRegisterTime) {
		this.userRegisterTime = userRegisterTime;
	}
	
	public Double getTotalSpace() {
		return totalSpace;
	}
	public void setTotalSpace(Double totalSpace) {
		this.totalSpace = totalSpace;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
	}
	public Double getUsedSpace() {
		return usedSpace;
	}
	public void setUsedSpace(Double usedSpace) {
		this.usedSpace = usedSpace;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}




	public MemberInfo getUserMemberInfo() {
		return userMemberInfo;
	}


	public void setUserMemberInfo(MemberInfo userMemberInfo) {
		this.userMemberInfo = userMemberInfo;
	}

/*
	public MultipartFile getFile() {
		return file;
	}


	public void setFile(MultipartFile file) {
		this.file = file;
	}*/


	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userEmail=" + userEmail
				+ ", userRegisterTime=" + userRegisterTime + ", usedSpace="
				+ usedSpace + ", code=" + code + ", totalSpace=" + totalSpace
				+ ", userAvatar=" + userAvatar + ", userMemberInfo=" + userMemberInfo
				+ "]";
	}

}
