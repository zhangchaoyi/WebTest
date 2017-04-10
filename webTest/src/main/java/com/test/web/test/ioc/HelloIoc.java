package com.test.web.test.ioc;

public class HelloIoc {
	private String name = "";  
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HelloIoc() {
		System.out.println("HelloIoc has been init");
	}

	public void helloIoc() {
		System.out.println("hello ioc first");
	}
	
	public void init() {  
        System.out.println("init runs ...");  
    }  
      
    public void destroy() {  
        System.out.println("destroy runs ...");  
    }  
}
