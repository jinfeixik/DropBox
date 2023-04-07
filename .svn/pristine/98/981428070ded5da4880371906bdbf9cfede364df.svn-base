package com.qst.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qst.entity.FileShare;
import com.qst.entity.UserInfo;
import com.qst.service.FileShareService;
import com.qst.service.FindAllFileService;
import com.qst.util.CurrentTimeUtil;
import com.qst.util.FourRandomUtil;
import com.qst.util.ShareLinkUtil;

@Controller
public class FileShareController {
	
	@Autowired 
	FileShareService fileShareService;
	@Autowired
	FindAllFileService fileService;
	
	/**
	 * function:把文件添加到我的分享
	 * @param request
	 * @return
	 */
	@RequestMapping("addShare.form")
	@ResponseBody
	public FileShare addShare(HttpServletRequest request) {
		int fileId = Integer.parseInt(request.getParameter("fileId"));
		HttpSession session = request.getSession(true);
		UserInfo user = (UserInfo) session.getAttribute("user");
		int userId = user.getUserId();
		//int userId = 1;
		//System.out.println("user " +user.toString());
		String shareLink = ShareLinkUtil.getShareLink();
		String shareCode = FourRandomUtil.getFourRandom();
		
		FileShare fileShare = new FileShare();
		fileShare.setUserId(userId);
		fileShare.setFileId(fileId);
		fileShare.setShareLink(shareLink);
		fileShare.setShareCode(shareCode);
		fileShare.setShareStatus(0);
		fileShare.setShareViewNumber(0);
		fileShare.setShareDownloadNumber(0);
		fileShare.setShareTime(CurrentTimeUtil.getCurrentTime());
		fileShareService.addFileShare(fileShare);
		
		fileShare.setShareLink("http://localhost:8080/DropBox/shareLink.form?shareLink="+shareLink);
		
		return fileShare;
	}
	
	/**
	 * function:生成四位提取码，发送到前端
	 * @param request
	 * @return
	 */
	@RequestMapping("getShareCode.form")
	@ResponseBody
	public String getShareCode(HttpServletRequest request) {
		String shareCode = FourRandomUtil.getFourRandom();

		return shareCode;
	}
	/**
	 * function:通过外链找到真实文件
	 * @param request
	 * @return
	 */
	@RequestMapping("shareLink.form")
	public ModelAndView shareLink(HttpServletRequest request) {
		String shareLink = request.getParameter("shareLink");
		ModelAndView map = new ModelAndView("file");
		HttpSession session = request.getSession(true);
		UserInfo user = (UserInfo) session.getAttribute("user");
		int userId = user.getUserId();
		//int userId = 1;
		FileShare fileShare = fileShareService.findFileShareByShareLink(shareLink);
		System.out.println("通过外链找到的文件 "+fileShare.toString());
		List<FileShare> fileShares = new ArrayList<FileShare>();
		fileShares.add(fileShare);
		map.addObject("fileShares", fileShares);
		
		return map;
	}
	/**
	 * function:删除我的分享里某个文件
	 * @param request
	 * @return
	 */
	@RequestMapping("deleteShare.form")
	public String deleteShare(HttpServletRequest request) {
		int fileId = Integer.parseInt(request.getParameter("fileId"));
		HttpSession session = request.getSession(true);
		UserInfo user = (UserInfo) session.getAttribute("user");
		int userId = user.getUserId();
		//int userId = 1;
		fileShareService.deleteFileShare(fileId, userId);

		return "share";
	}
	
	/**
	 * function:清空我的分享
	 * @param request
	 * @return
	 */
	@RequestMapping("clearShare.form")
	public String clearShare(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		UserInfo user = (UserInfo) session.getAttribute("user");
		int userId = user.getUserId();
		//int userId = 1;
		fileShareService.clearFileShare(userId);

		return "share";
	}
	
	/**
	 * function:获取我的分享列表
	 * @param request
	 * @return
	 */
	@RequestMapping("getAllShare.form")
	public ModelAndView getAllShare(HttpServletRequest request) {
		ModelAndView map = new ModelAndView("share");
		double volume = fileService.findVolume(request);
		HttpSession session = request.getSession(true);
		UserInfo user = (UserInfo) session.getAttribute("user");
		int userId = user.getUserId();
		//int userId = 1;
		List<FileShare> fileShares = fileShareService.findAllFileShare(userId);
		map.addObject("fileShares", fileShares);
		map.addObject("user", user);
		map.addObject("volume", volume);

		return map;
	}
	
	/**
	 * function:修改分享文件的状态（1公开0加密）
	 * @param request
	 * @return
	 */
	@RequestMapping("updateShareStatus.form")
	public String updateShareStatus(HttpServletRequest request) {
		int fileId = Integer.parseInt(request.getParameter("fileId"));
		HttpSession session = request.getSession(true);
		UserInfo user = (UserInfo) session.getAttribute("user");
		int userId = user.getUserId();
		//int userId = 1;
		fileShareService.updateFileShareStatus(fileId, userId);

		return "share";
	}
}
