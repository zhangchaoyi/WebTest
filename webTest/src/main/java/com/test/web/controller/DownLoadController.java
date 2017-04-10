package com.test.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class DownLoadController {
	public static final Logger logger = LoggerFactory.getLogger(DownLoadController.class);
	@RequestMapping(value="/download")
	public void downloadFile(HttpServletResponse response){
		String data = "{test:{test:hello}}";
        byte[] bytes = data.getBytes();
        
        response.setContentType("application/x-msdownload");
        response.addHeader("Content-Disposition","attachment;filename=data.json");
        response.setContentLength(bytes.length);
        response.addHeader("Content-Length", "" + bytes.length);
        
        try {
            response.getOutputStream().write(bytes);
            response.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void testLog(){
		logger.info("test");
	}
	public static void main(String[] args){
		new DownLoadController().testLog();
	}
}
