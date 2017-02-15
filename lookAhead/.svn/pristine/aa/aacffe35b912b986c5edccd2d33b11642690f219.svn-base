package com.la.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.la.dao.StuModifyDao;
import com.la.domain.Student;

@Service
@Transactional
public class StuModifyService {
	@Autowired 
	StuModifyDao modifydao;
	public Boolean StuModify(Student student) throws Exception{
		return modifydao.modifypassword(student);	
		}
	public List<Student> getList(Student student){
		return modifydao.getList(student);	
	}
}
