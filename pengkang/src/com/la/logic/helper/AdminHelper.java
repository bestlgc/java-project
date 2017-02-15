package com.la.logic.helper;

import org.apache.ibatis.session.SqlSession;

import com.la.logic.common.model.PersistenceAdmin;
import com.la.logic.dao.SqlSessionManager;
import com.la.logic.mapper.PersistenceAdminMapper;

public class AdminHelper {
	public static PersistenceAdmin getAdmin(String adminName) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession();
		PersistenceAdminMapper mapper = session.getMapper(PersistenceAdminMapper.class);
		PersistenceAdmin admin = mapper.selectByName(adminName);
		return admin;
	}
	
	public static void main(String[] args) {
		PersistenceAdmin admin = getAdmin("haha");
		System.out.println(admin.getAdminpassword());
	}
}
