package com.qst.entity;

/**
 * @author 袁滢yuanying
 * @date 2019-8-28下午3:22:06
 * @version v1.0
 * 文件夹信息
 */
public class FolderInfo {
	
	private Integer folderId;
	private String folderName;
	private Integer userId;
	private Integer folderParentFolderId;
	private String folderName1;
	
	public FolderInfo(){
		
	}
	
	public FolderInfo(Integer folderId, String folderName, Integer userId,
			Integer folderParentFolderId) {
		super();
		this.folderId = folderId;
		this.folderName = folderName;
		this.userId = userId;
		this.folderParentFolderId = folderParentFolderId;
	}



	public Integer getFolderId() {
		return folderId;
	}



	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}



	public String getFolderName() {
		return folderName;
	}



	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}



	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	

	public Integer getFolderParentFolderId() {
		return folderParentFolderId;
	}

	public void setFolderParentFolderId(Integer folderParentFolderId) {
		this.folderParentFolderId = folderParentFolderId;
	}

	@Override
	public String toString() {
		return "{folderId=" + folderId + ", folderName="
				+ folderName + ", userId=" + userId + ", folderParentFolderId="
				+ folderParentFolderId + "}";
	}

	public String getFolderName1() {
		return folderName1;
	}

	public void setFolderName1(String folderName1) {
		this.folderName1 = folderName1;
	}
	
	
	
	

}
