package com.test.web.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application.xml");
		Teacher teacher = applicationContext.getBean("teacher", Teacher.class);
		Student student = teacher.getStudent();
//		System.out.println(teacher.getTeacherName());
//		System.out.println("studentName :" + student.getName() + "==studentId :" + student.getId());
//		System.out.println(teacher.getLists());
//		System.out.println(teacher.getMaps());
//		System.out.println(teacher.getSets());
		for(Student s : teacher.getsList()){
			System.out.println("name:" + s.getName() + ", id=" + s.getId());
		}
	}
}