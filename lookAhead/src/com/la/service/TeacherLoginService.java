package com.la.service;
import com.la.dao.TeacherLoginDao;
import com.la.domain.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class TeacherLoginService {
	@Autowired
	TeacherLoginDao logindao;

	/**
	 * �ж��û��˺ź������Ƿ���ȷ
	 * @param username
	 * @param password
	 * @return
	 */
	public  Boolean ValideLogin(String username, String password) throws Exception{
		return logindao.validUserByName(username, password);
	}

	public Teacher ValideLogin2(String account, String password)throws Exception {
		return logindao.validUserByName2(account, password);
	}
}
