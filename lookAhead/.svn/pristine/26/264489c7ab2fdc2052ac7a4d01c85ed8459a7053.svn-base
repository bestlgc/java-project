package com.la.service;

import com.la.dao.StudentRegisterDao;
import com.la.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentRegisterService {
	@Autowired 
	StudentRegisterDao registerdao;
	
	public void stuRegister(Student student){
		 registerdao.addStudent(student);	  
	}
	public Boolean getStudentByName(String name)
	{
		return registerdao.getStudentByName(name);
	}
}
