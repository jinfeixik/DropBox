package com.qst.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class FileTransferLsit implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fileTransferLsitId;
	private int fileType;
	private String fileName;
	private double fileSize;
	private Timestamp fileTime;
	private int transferUploadaAndDownloadFlag;
	private int status;
	private String path;
	private int fileId;


	public FileTransferLsit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FileTransferLsit(int fileTransferLsitId, int fileType,
			String fileName, double fileSize, Timestamp fileTime,
			int transferUploadaAndDownloadFlag, int status, String path, int fileId) {
		super();
		this.fileTransferLsitId = fileTransferLsitId;
		this.fileType = fileType;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileTime = fileTime;
		this.transferUploadaAndDownloadFlag = transferUploadaAndDownloadFlag;
		this.status = status;
		this.path = path;
		this.fileId = fileId;
	}
	@Override
	public String toString() {
		return "FileTransferLsit [fileTransferLsitId=" + fileTransferLsitId
				+ ", fileType=" + fileType + ", fileName=" + fileName
				+ ", fileSize=" + fileSize + ", fileTime=" + fileTime
				+ ", transferUploadaAndDownloadFlag="
				+ transferUploadaAndDownloadFlag + ", status=" + status + ", path="
				+ path + ", fileId=" + fileId + "]";
	}
	public int getFileTransferLsitId() {
		return fileTransferLsitId;
	}
	public void setFileTransferLsitId(int fileTransferLsitId) {
		this.fileTransferLsitId = fileTransferLsitId;
	}
	public int getFileType() {
		return fileType;
	}
	public void setFileType(int fileType) {
		this.fileType = fileType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public double getFileSize() {
		return fileSize;
	}
	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}
	public Timestamp getFileTime() {
		return fileTime;
	}
	public void setFileTime(Timestamp fileTime) {
		this.fileTime = fileTime;
	}
	public int getTransferUploadaAndDownloadFlag() {
		return transferUploadaAndDownloadFlag;
	}
	public void setTransferUploadaAndDownloadFlag(int transferUploadaAndDownloadFlag) {
		this.transferUploadaAndDownloadFlag = transferUploadaAndDownloadFlag;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}



}
