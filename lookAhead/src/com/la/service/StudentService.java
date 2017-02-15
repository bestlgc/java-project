package com.la.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.la.dao.StudentDao;
import com.la.domain.Student;



@Service
public class StudentService {
	@Autowired
	private StudentDao dao;
	public void merge(Student student) throws Exception{
		dao.merge(student);
}
	public Student getById(Integer sid) throws Exception{
		Student student = dao.getById(sid);
		return student;
	}
	public void update(Student vstudent) throws Exception{
		dao.update(vstudent);
	}
}
