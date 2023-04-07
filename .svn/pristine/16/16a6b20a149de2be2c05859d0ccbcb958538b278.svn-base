package com.qst.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

import org.springframework.web.multipart.MultipartFile;

public class Office2Util {

	 private static final Log LOG = LogFactory.getLog(Office2Util.class);
	
	public static File converterFile(File file, String outputFilePath_end, OfficeDocumentConverter converter) { // 4
		File outputFile = new File(outputFilePath_end);
		// 假如目标路径不存在,则新建该路径
		if (!outputFile.getParentFile().exists()) {
			outputFile.getParentFile().mkdirs();
		}
		converter.convert(file, outputFile);
		System.out.println("文件：" + file.getName() + "转换为目标文件：" + outputFile
				+ "成功!");
		
		return outputFile;
	}
	
	
	public static String office2pdf(File file, HttpServletRequest request) {  //2
        OfficeManager officeManager = null;
        try {
            if (file==null) {
                LOG.info("输入文件地址为空，转换终止!");
                return null;
            }
System.out.println("文件名:" +file.getName());
System.out.println("文件名2:" +file.getName().lastIndexOf(".")+1);
            // 转换后的文件路径

			String fileName = file.getName();
			
			String outputFilePath_end_c = fileName.replaceAll("." + getPostfix(fileName), getString() +".pdf");
			
            String outputFilePath_end = request.getSession().getServletContext().getRealPath("upload")+"\\" + outputFilePath_end_c;
System.out.println("转换后的路径:" +outputFilePath_end);
            if (!file.exists()) {
                LOG.info("输入文件不存在，转换终止!");
                return null;
            }
 
            // 获取OpenOffice的安装路径
            officeManager = getOfficeManager();
            // 连接OpenOffice
            OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
 
            converterFile(file, outputFilePath_end, converter);
            return outputFilePath_end_c;
        } catch (Exception e) {
            LOG.error("转化出错!", e);
        } finally {
            // 停止openOffice
            if (officeManager != null) {
                officeManager.stop();
            }
        }
        return null;
    }
	
	 public static OfficeManager getOfficeManager() {
	        DefaultOfficeManagerConfiguration config = new DefaultOfficeManagerConfiguration();
	        // 设置OpenOffice.org 4的安装目录
	        config.setOfficeHome(getOfficeHome());
	        // 启动OpenOffice的服务
	        OfficeManager officeManager = config.buildOfficeManager();
	        officeManager.start();
	        return officeManager;
	    }
	 
	 
	 public static String getOfficeHome() {
	        String osName = System.getProperty("os.name");
	        System.out.println("操作系统名称:" + osName);
	        if (Pattern.matches("Linux.*", osName)) {
	            return "/opt/openoffice.org4";
	        } else if (Pattern.matches("Windows.*", osName)) {
	            return "C:/Program Files (x86)/OpenOffice 4";
	        } else if (Pattern.matches("Mac.*", osName)) {
	            return "/Applications/OpenOffice.org.app/Contents/";
	        }
	        return null;
	    }
	 
	  
	  public static String getPostfix(String inputFilePath) {
	        return inputFilePath.substring(inputFilePath.lastIndexOf(".") + 1);
	    }
	  
	 
	 public static String getString() {
		 
		 Date date = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		 String str = formatter.format(date);
		
		 return str;
	 }
	 
	 
	 public static String multipartFile2File(MultipartFile file, HttpServletRequest request) {
		 File toFile = null;
		 InputStream ins = null;
		 try {
			ins = file.getInputStream();
			toFile = new File(file.getOriginalFilename());
			 FileUtil.inputStreamToFile(ins, toFile);
			
			 return office2pdf(toFile, request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		 return null;
		 
	 }
	 
	 
	 
	 public static void main(String[] args) {
		
		  File file = new File("D:/aaa/test1.xls");
		  Office2Util.office2pdf(file, null);
	    }
	
	 
	 
	/* @RequestMapping("/upload1.form")
		public String uploadPDFFile(@RequestParam("some") MultipartFile file, HttpServletRequest request, ModelMap model) {
			
			//controller调用方式
				String endFile = Office2Util.multipartFile2File(file, request);
			
			    model.addAttribute("url", "upload/"+endFile);
			    System.out.println("文件路径:" +endFile);
			
			return "show";
		}*/

}
