package com.qst.controller;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qst.entity.FileTransfer;
import com.qst.entity.UserInfo;
import com.qst.service.FileInfoService;
import com.qst.service.FileTransferService;
import com.qst.util.TimeUtil;

@Controller
public class zipController {
	@Autowired
	FileInfoService fileInfoService;
	
	@Autowired
	FileTransferService fileTransferService;
	
	
	/**
	 *文件压缩下载
	 *billname:文件名
	 *filename：文件存放路径
	 */
	 @RequestMapping(value="zip.form",method=RequestMethod.GET)
	 public String zipfileDownload_workerCard(HttpServletRequest request, HttpServletResponse response) throws Exception{  
		  
		 /*//1获取findid初始化传输列表值
		 //1.1得到前台传递过来的文件ID并进行分割
			String[] fileId=request.getParameter("fileId").split(" ");
			
		 //1.2 初始化传输列表值
		    List<FileTransfer>  fileTransfers=fileTransferService.startValue(fileId);
			
			*/
		 //2.下载文件	  
			
		    //响应头的设置
	        response.reset();
	        response.setCharacterEncoding("utf-8");
	        response.setContentType("multipart/form-data");
	       
	        //设置压缩包的名字
	        //解决不同浏览器压缩包名字含有中文时乱码的问题           
	        String filename=request.getParameter("filename");
	        
	        String billname =filename.replace(" ", "_");
	        String downloadName = billname+".zip";
	        //返回客户端浏览器的版本号、类型
	        String agent = request.getHeader("USER-AGENT");  
	        try {
	        	//针对IE或者以IE为内核的浏览器：  
	            if (agent.contains("MSIE")||agent.contains("Trident")) {
	                downloadName = java.net.URLEncoder.encode(downloadName, "UTF-8");
	            } else {
	            	//非IE浏览器的处理：
	                downloadName = new String(downloadName.getBytes("UTF-8"),"ISO-8859-1");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");

	        //设置压缩流：直接写入response，实现边压缩边下载
	        ZipOutputStream zipos = null;
	        try {
	            zipos = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
	            zipos.setMethod(ZipOutputStream.DEFLATED); //设置压缩方法 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        //循环将文件写入压缩流
	        DataOutputStream os = null;
	       
			System.out.println("进入下载文件zip2");
			String[] allfilename=filename.split(" "); 
			
	
        //从数据库中取出要下载的图片路径、并循环写入压缩
	   System.out.println(allfilename.toString());
	        for (String f1:allfilename) {
	                    System.out.println("f1"+f1);
	        		String modipath = request.getSession().getServletContext().getRealPath("upload"+"\\"+f1);
	        		 File file = new File(modipath);
	        		if(file.exists()){
	        			try {
	        				//添加ZipEntry，并ZipEntry中写入文件流
	        				//这里，加上i是防止要下载的文件有重名的导致下载失败
	        				zipos.putNextEntry(new ZipEntry(f1));
	        				os = new DataOutputStream(zipos);
	        				InputStream is = new FileInputStream(file);
	        				byte[] b = new byte[100];
	        				int length = 0;
	        				while((length = is.read(b))!= -1){
	        					os.write(b, 0, length);
	        				}
	        				is.close();
	        				zipos.closeEntry();
	        			} catch (IOException e) {
	        				e.printStackTrace();
	        			} 
	        		}
	   
	    	}
	      
		     //关闭流
	        try {
	            os.flush();
	            os.close();
	            zipos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }  
	        
	        HttpSession session = request.getSession();
			UserInfo user=(UserInfo) session.getAttribute("user");
			int userId=user.getUserId();
	        FileTransfer ft=new FileTransfer();
			ft.setFileId(0);
			ft.setTransferFileSize(-1.0);
			ft.setTransferProgress(100);
			ft.setTransferStatus(2);
			ft.setTransferTime(TimeUtil.time2Timestamp());
			ft.setTransferUploadaAndDownloadFlag(2);
			ft.setUserId(userId);
			ft.setTransferFileName(filename);
			fileTransferService.addTrandsferDao(ft);
			  
	        
			return "down";
	 }  
}
