package com.test.web.di;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;
/**
 * @Resource 注解可以省略property或者 constructor-arg 的设置，@Resource(name="id") 表示根据bean id进行注入
 * 如果不带name参数则根据属性的名称
 * @author chris
 *
 */
@Component("senior")
public class Classroom {
//	@Resource  不指定name则在容器下.xml/@component 寻找 beanId = student的对象
	@Resource(name="chris")
	private Student student;
//	@Resource
	@Resource(name="qiufeng")
	private Teacher teacher;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
}
