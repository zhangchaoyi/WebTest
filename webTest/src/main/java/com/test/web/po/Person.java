package com.test.web.po;

public class Person {
	private int id;
	private String name;
	private int sex;

	public Person(int id,String name,int sex){  
        this.id = id;  
        this.name = name;  
        this.sex = sex;  
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
}
