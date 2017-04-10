package com.test.web.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Constants {
	 public static final Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss")
	            .create();
}
