package com.qst.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DownLoadFile{
	@RequestMapping("downlode.form")
	public void download(@RequestParam(value="filename")String filename, HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		System.out.println("进入下载文件Controller");
	    
				
    	//获取文件的绝对路径名称，这个只能获取根目录文件夹的绝对路径
        String path = request.getSession().getServletContext().getRealPath("images")+"\\"+filename;
        System.out.println(path);
    
        //得到要下载的文件
        File file = new File(path);
        if (!file.exists()) {
        	response.setContentType("text/html; charset=UTF-8");//注意text/html，和application/html
        	response.getWriter().print("<html><body><script type='text/javascript'>alert('您要下载的资源已被删除！');</script></body></html>");
        	response.getWriter().close(); 
            System.out.println("您要下载的资源已被删除！！"); 
		}
        //转码，免得文件名中文乱码  
        filename = URLEncoder.encode(filename,"UTF-8");  
  
        //设置文件下载头  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    

        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
        response.setContentType("multipart/form-data"); 
    	
        // 读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(path);

        // 创建输出流
        OutputStream out = response.getOutputStream();
    
        // 创建缓冲区
        byte buffer[] = new byte[1024]; // 缓冲区的大小设置是个迷  我也没搞明白

        int len = 0;
    	
        //循环将输入流中的内容读取到缓冲区当中
        while((len = in.read(buffer)) > 0){

        	out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
   
        // 关闭输出流
        out.close();
    	
	
    }

	}


	 