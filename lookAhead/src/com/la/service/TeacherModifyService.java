package com.la.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.la.dao.TeacherModifyDao;
import com.la.domain.Teacher;

@Service
@Transactional
public class TeacherModifyService {
	@Autowired 
	TeacherModifyDao modifydao;
	public Boolean TeacherModify(Teacher teacher) throws Exception{
		return modifydao.modifypassword(teacher);	
		}
	public List<Teacher> getList(Teacher teacher){
		return modifydao.getList(teacher);	
	}
}
