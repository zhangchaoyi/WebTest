package com.test.web.dao;

import java.util.List;

import com.test.web.po.Person;

public interface IAction {
	boolean insertPerson(Person person); // 添加

	boolean deleteById(int id); // 删除

	boolean updatePerson(Person person); // 修改

	Person queryById(int id); // 根据ID查询

	List<Person> queryAllPerson(); // 查询全部
}
