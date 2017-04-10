package com.test.web.service.impl;

import org.springframework.stereotype.Service;

import com.test.web.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService{

	public String getResult() {
		String result = "a";
		return result;
	}
	
}
