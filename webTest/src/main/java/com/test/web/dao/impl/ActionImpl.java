package com.test.web.dao.impl;

import java.util.List;
import com.test.web.dao.IAction;
import com.test.web.po.Person;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;  

public class ActionImpl extends SqlMapClientDaoSupport implements IAction {

	public boolean insertPerson(Person person) {
		getSqlMapClientTemplate().insert("insertPerson",person);  
		return false;
	}

	public boolean deleteById(int id) {
		getSqlMapClientTemplate().delete("deleteById", id); 
		return false;
	}

	public boolean updatePerson(Person person) {
		return getSqlMapClientTemplate().update("updatePerson", person) > 0 ? true : false;
	}

	public Person queryById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> queryAllPerson() {
		@SuppressWarnings("unchecked")
		List<Person> persons = getSqlMapClientTemplate().queryForList("queryAllPerson"); 
		return persons;
	}

	
	

}
