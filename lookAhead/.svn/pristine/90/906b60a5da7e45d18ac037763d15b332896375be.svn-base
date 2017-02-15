package com.la.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.la.dao.TeacherLookDao;
import com.la.domain.Teacher;

@Service
@Transactional
public class TeacherLookService {
	@Autowired 
	TeacherLookDao lookdao;
	public List<Teacher> getList(Teacher teacher){
		return lookdao.getList(teacher);	
	}
}
