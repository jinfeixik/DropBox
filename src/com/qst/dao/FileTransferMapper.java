package com.qst.dao;

import java.util.List;

import com.qst.entity.FileTransfer;

/**
 * @author 赵海庭（zhaohaiting）
 * @date 2019-8-30下午2:36:35
 * @version v1.0
 * 传输管理
 */
public interface FileTransferMapper {

	public List<FileTransfer> findUserAllFileTransferList(int i) ;

	public void addTransferDao(FileTransfer ft);

	public void delTransferList(int fileTransferLsitId);

	public void delUserAllTransferList(int userId);
		

}
