package com.la.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.la.domain.Student;

@Repository
public class StudentDao {
	@Autowired
	private  SessionFactory sessionFactory;
	public void merge(Student student)throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.merge(student);
		session.flush();
	}
	public Student getById(Integer sid) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Student student = (Student) session.get(Student.class, sid);
		return student;
	}
	public void update(Student vstudent) {
		Session session = sessionFactory.getCurrentSession();
		session.update(vstudent);
		session.flush();
	}
}
