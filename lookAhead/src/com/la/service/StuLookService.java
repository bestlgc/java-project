package com.la.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.la.dao.StuLookDao;
import com.la.domain.Student;

@Service
@Transactional
public class StuLookService {
	@Autowired 
	StuLookDao lookdao;
	public List<Student> getList(Student student){
		return lookdao.getList(student);	
	}
	public Student getByAccount(String account) throws Exception{
		Student student = lookdao.getByAccount(account);
		return student;
	}
}
