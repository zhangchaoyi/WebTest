package com.test.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@MultipartConfig
@Controller
public class UploadFileController {
	static final String filename = "filename";
	@RequestMapping(value="/import",method=RequestMethod.GET)
	public String uploadFile(HttpServletRequest request, HttpServletResponse response){
		return "singleUpload";
	}
	@ResponseBody
	@RequestMapping(value="/import",method=RequestMethod.POST)
	public String importFile(HttpServletRequest request, HttpServletResponse response,@RequestParam("filename") MultipartFile[] files){
		if(files!=null&&files.length>0){  
			System.out.println(files.length);
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[i];  
                
                //保存文件  
                saveFile(request,file);  
            }  
        }  	
		
		return "{\"code\":0}";
	}
	
	private boolean saveFile(HttpServletRequest request,MultipartFile file) {  
        // 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {  
                // 文件保存路径  
                String filePath = request.getSession().getServletContext().getRealPath("/")
                        + file.getOriginalFilename();  
                // 转存文件  
                System.out.println(filePath);
                file.transferTo(new File(filePath));  
                return true;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    }  
}