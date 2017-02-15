package com.la.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.la.domain.Teacher;

@Repository
public class TeacherModifyDao {
	@Autowired
	SessionFactory sessionFactory;
	public Boolean modifypassword(Teacher teacher)throws Exception{
		Session session=sessionFactory.getCurrentSession();
		session.update(teacher);
		return true;
	}
	public List<Teacher> getList(Teacher teacher){
		String queryString  = "from Teacher";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<Teacher> list = query.list();
		return list;
	}

}
