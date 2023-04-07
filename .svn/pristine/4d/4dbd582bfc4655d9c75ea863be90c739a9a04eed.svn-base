package com.qst.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qst.dao.FileInfoMapper;
import com.qst.dao.FolderInfoMapper;
import com.qst.entity.FileInfo;
import com.qst.entity.FolderInfo;
import com.qst.entity.MemberInfo;
import com.qst.entity.UserInfo;
import com.qst.service.FindAllFileService;
import com.qst.service.FindAllFolderService;

/**
 * 
 * @author 李阳liyang
 * @date 2019-8-29下午9:28:53
 * @version v1.0
 */

@Controller
public class FindAllFileController {
	
	@Autowired
	FindAllFileService fileService;
	
	@Autowired
	FindAllFolderService folderService;
	
	@Autowired
	FileInfoMapper fileInfoDao;
	
	@Autowired
	FolderInfoMapper folderInfoDao;
	
	
	
	//int flag;
	
	
	@RequestMapping("listAllFile.form")
	public String ListAllFile(ModelMap map,HttpServletRequest request){
		
		UserInfo user=(UserInfo) request.getSession().getAttribute("user");
		
		double volume = fileService.findVolume(request);
		
		List<FolderInfo> folderInfos = folderService.findFolder(request);
		
		List<FileInfo> fileInfos=fileService.findFile(request);
		
		map.addAttribute("folderInfos", folderInfos);
		
		map.addAttribute("fileInfos", fileInfos);
		
		map.addAttribute("user", user);
		
		map.addAttribute("volume", volume);
		
		map.addAttribute("memberInfo",user.getUserMemberInfo());

		return "index";
	}
	
	
	
	@RequestMapping("listFileInfoYY.form")
	public String listFileInfoYY(Integer parentId, HttpServletRequest request){
		
		HttpSession session = request.getSession();
		UserInfo user = (UserInfo) session.getAttribute("user");
		FolderInfo folderInfo = new FolderInfo();
		folderInfo.setFolderParentFolderId(parentId);
		folderInfo.setUserId(user.getUserId());
		
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFolderId(parentId);
		fileInfo.setUserId(user.getUserId());
		
		List<FolderInfo> folderInfos = folderService.findFolder(folderInfo);
		List<FileInfo> fileInfos=fileService.findFile(fileInfo);
		
		request.setAttribute("folderInfos", folderInfos);
		request.setAttribute("fileInfos", fileInfos);

		return "index";
	}
	
	
	
	
	
	@RequestMapping(value="listFile.form",method = RequestMethod.POST)
	@ResponseBody
    public List<FileInfo> FindTypeInfo(ModelMap map,HttpServletRequest request){
    	
    	List<FileInfo> fileInfos=fileService.findFile1(request);
    	
    	System.out.println("flag:"+request.getParameter("flag"));
    	
    	int flag=Integer.parseInt(request.getParameter("flag"));
    	
    	List<FileInfo> fileInfos1=new ArrayList<FileInfo>(); 
    	
        for(FileInfo fileInfo:fileInfos){
			
			if(fileInfo.getFileType()==flag){
				
				fileInfos1.add(fileInfo);
			
			}
			
	    }
        
        System.out.println("分类后："+fileInfos1);
        
        //fileInfos1.get(0).setFileName("小芳");
        
        //map.addAttribute("fileInfo", fileInfos1);
        
    	return   fileInfos1;
    }
	
	@RequestMapping("listFolder.form")
	public String ListFolderFile(ModelMap map,HttpServletRequest request){
		
		//int userId=1;
			
		//request.getSession().setAttribute("userId", userId);
		
		int userId=(Integer) request.getSession().getAttribute("userId");
		
		System.out.println("userId为："+userId);
		
		System.out.println(request.getParameter("folderId"));
		
		int folderId=Integer.parseInt(request.getParameter("folderId"));
		
		FileInfo fileInfo=new FileInfo();
		
		fileInfo.setFolderId(folderId);
		
		fileInfo.setUserId(userId);
		
		FolderInfo folderInfo=new FolderInfo();
		
		folderInfo.setFolderParentFolderId(folderId);
		
		folderInfo.setUserId(userId);
		
		List<FileInfo> fileInfos=fileInfoDao.findAllFile(fileInfo);
		
		List<FolderInfo> folderInfos=folderInfoDao.findAllFolder(folderInfo);
		
        map.addAttribute("folderInfos", folderInfos);
		
		map.addAttribute("fileInfos", fileInfos);
		
		System.out.println(folderId+"下文件夹："+folderInfos);
		
		System.out.println(folderId+"下文件："+fileInfos);
		
		return "index";
	}
	
	@RequestMapping("searchFile.form")
	@ResponseBody
	public List<FileInfo> SearchFile(ModelMap map,HttpServletRequest request){
		
		System.out.println(request.getParameter("name")+"??"+request.getParameter("type")
				+"??"+request.getParameter("size")+"??"+request.getParameter("time"));
		
		//int userId=1;
		
		//request.getSession().setAttribute("userId", userId);
		
		int userId=(Integer) request.getSession().getAttribute("userId");
		
		FileInfo fileInfo=new FileInfo();
		
		fileInfo.setUserId(userId);
		
		if(request.getParameter("name")!=null&&request.getParameter("name")!=""){
		
		fileInfo.setFileName1(request.getParameter("name"));
		
		}
		
		fileInfo.setFileName(request.getParameter("sea"));
		
		if(request.getParameter("type")!=null&&request.getParameter("type")!=""){
			
			fileInfo.setFileType(Integer.parseInt(request.getParameter("type")));
			
		}
						
		if(request.getParameter("size")!=null&&request.getParameter("size")!=""){
			
			fileInfo.setFileSize(Double.parseDouble(request.getParameter("size")));
			
		}
		
		if(request.getParameter("time")!=null&&request.getParameter("time")!=""){
			
			fileInfo.setUploadTime(Timestamp.valueOf("2019-08-28 19:28:11"));
			
		}
		
		
        List<FileInfo> fileInfos=fileInfoDao.findFileBySearch(fileInfo);
		
		System.out.println("搜索后文件："+fileInfos);
		
		return fileInfos;
	}
	
	@RequestMapping("searchFolder.form")
	@ResponseBody
	public List<FolderInfo> SearchFolder(ModelMap map,HttpServletRequest request){
        //int userId=1;
		
		//request.getSession().setAttribute("userId", userId);
		
		int userId=(Integer) request.getSession().getAttribute("userId");
			
        FolderInfo folderInfo=new FolderInfo();
		
		folderInfo.setUserId(userId);
		
		folderInfo.setFolderName(request.getParameter("sea"));
		
		if(request.getParameter("name")!=null&&request.getParameter("name")!=""){
		
		folderInfo.setFolderName1(request.getParameter("name"));
		
		}
		
		List<FolderInfo> folderInfos=folderInfoDao.findFolderBySearch(folderInfo);
		
		//System.out.println("搜索后文件夹："+folderInfos);
		
		return folderInfos;
		
	}
	
	
	
	
	

}
