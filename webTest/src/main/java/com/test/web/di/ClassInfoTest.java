package com.test.web.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 演示构造器注入
 * @author chris
 *
 */
public class ClassInfoTest {
	public static void main(String[] args){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application.xml");
		ClassInfo classInfo = applicationContext.getBean("classInfo", ClassInfo.class);  
		System.out.println("classInfo.getClassName():"+classInfo.getClassName());  
		System.out.println("studentId:"+classInfo.getStudent().getId()+"==studentName:"+classInfo.getStudent().getName()); 
	}
}
