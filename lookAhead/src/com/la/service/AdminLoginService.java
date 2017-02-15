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
	 * 判断用户账号和密码是否正确
	 * @param username
	 * @param password
	 * @return
	 */
	public  Boolean ValideLogin(String username, String password) {
		return logindao.validUserByName(username, password);
	}
}
