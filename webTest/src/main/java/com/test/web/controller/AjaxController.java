package com.test.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.test.web.util.Constants;

@Controller
public class AjaxController {
	
	@RequestMapping(value="test",method = RequestMethod.GET)
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response){
		
		return "{\"code\":0}"; 				
	}
	
	@RequestMapping(value="test",method = RequestMethod.POST)
	@ResponseBody
	public String testPost(HttpServletRequest request, HttpServletResponse response){
		String name = ServletRequestUtils.getStringParameter(request, "Name", "");
		String password = ServletRequestUtils.getStringParameter(request, "Password", "");
		JsonObject json = new JsonObject();
		
		String date = Constants.gson.toJson(new ArrayList<Integer>(Arrays.asList(0,1,2)));
		String data = Constants.gson.toJson(new ArrayList<Double>(Arrays.asList(1.1,2.2,3.3)));
		if(name.equals("sanmao") && password.equals("sanmaoword")){
			Map<String ,String> map = new HashMap<String ,String>();
			map.put(data,date);
			json.addProperty("0", Constants.gson.toJson(map));						
		}
		return Constants.gson.toJson(json); 				
	}
}
