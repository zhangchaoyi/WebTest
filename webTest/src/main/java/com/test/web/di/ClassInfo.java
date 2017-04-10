package com.test.web.di;

public class ClassInfo {
	private String className;  
    private Student student;  
    public ClassInfo(String className, Student student) {  
        super();  
        this.className = className;  
        this.student = student;  
    }  
    public String getClassName() {  
        return className;  
    }  
    public Student getStudent() {  
        return student;  
    }
}
