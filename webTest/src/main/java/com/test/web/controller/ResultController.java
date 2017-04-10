package com.test.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.test.web.service.UserService;

@Controller
@RequestMapping("/test")
public class ResultController {
	@Resource(name="userService")
	private UserService us;

	@ResponseBody
	@RequestMapping("/result")
	public String getResult(){
		return us.getResult();
	}
}
