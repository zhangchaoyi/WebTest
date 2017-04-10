package com.test.web.di;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
/**
 * 注入集合
 * @author chris
 *
 */
@Component("qiufeng")
public class Teacher {
	private String teacherName;
	private Student student;
	private List<String> lists;
	private Set<Integer> sets;
	private Map<Integer, Integer> maps;
	private List<Student> sList;
	
	public List<Student> getsList() {
		return sList;
	}

	public void setsList(List<Student> sList) {
		this.sList = sList;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public Set<Integer> getSets() {
		return sets;
	}

	public void setSets(Set<Integer> sets) {
		this.sets = sets;
	}

	public Map<Integer, Integer> getMaps() {
		return maps;
	}

	public void setMaps(Map<Integer, Integer> maps) {
		this.maps = maps;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
