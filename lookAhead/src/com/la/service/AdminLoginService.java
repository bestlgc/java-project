package com.la.service;

import com.la.dao.AdminLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AdminLoginService {
	@Autowired
	AdminLoginDao logindao;

	/**
	 * �ж��û��˺ź������Ƿ���ȷ
	 * @param username
	 * @param password
	 * @return
	 */
	public  Boolean ValideLogin(String username, String password) {
		return logindao.validUserByName(username, password);
	}
}
