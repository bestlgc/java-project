package com.la.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.la.domain.Student;

@Repository
public class StuModifyDao {
	@Autowired
	SessionFactory sessionFactory;
	public Boolean modifypassword(Student student)throws Exception{
		Session session=sessionFactory.getCurrentSession();
		session.update(student);
		return true;
	}
	public List<Student> getList(Student student){
		String queryString  = "from Student";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<Student> list = query.list();
		return list;
	}

}
