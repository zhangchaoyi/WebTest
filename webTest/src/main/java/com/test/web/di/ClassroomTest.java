package com.test.web.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassroomTest {
	public static void main(String[] args){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application.xml");
//		Classroom classroom = applicationContext.getBean("classroom", Classroom.class);  
//		Student s = classroom.getStudent();
//		Teacher t = classroom.getTeacher();
//		System.out.println(s.getName() + ":" + s.getId());
//		System.out.println("teacherName:" + t.getTeacherName() + " studentName:" + t.getStudent().getName() + " studentId:" + t.getStudent().getId());
//		Classroom classroom = applicationContext.getBean("senior", Classroom.class);
//		System.out.println(classroom.getStudent().getName());
//		System.out.println(classroom.getTeacher().getTeacherName());
		Student chris = applicationContext.getBean("chris", Student.class);
		System.out.println("name:" + chris.getName() + " id:" + chris.getId());
	}
}
