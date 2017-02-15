package com.la.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.la.domain.Student;

@Repository
public class StuLookDao {
	@Autowired
	SessionFactory sessionFactory;
	public List<Student> getList(Student student){
		String queryString  = "from Student";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<Student> list = query.list();
		return list;
	}
	public Student getByAccount(String account) throws Exception{
		String queryString  = "from Student where username=?";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter(0, account);
		Student student = (Student)query.uniqueResult();
		return student;
	}
}
