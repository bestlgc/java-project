package com.la.service;
import com.la.dao.LeaderLoginDao;
import com.la.domain.GroupLeader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class LeaderLoginService {
	@Autowired
	LeaderLoginDao logindao;

	/**
	 * �ж��û��˺ź������Ƿ���ȷ
	 * @param username
	 * @param password
	 * @return
	 */
	public  Boolean ValideLogin(String username, String password) {
		return logindao.validUserByName(username, password);
	}
	public  GroupLeader ValideLogin2(String username, String password) {
		return logindao.validUser(username, password);
	}
}
