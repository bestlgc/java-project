package com.la.dao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.la.domain.Teacher;
@Repository
public class TeacherLoginDao {
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * �����жϵ�¼�û����û����������Ƿ���ȷ
	 * @param username �û���
	 * @param password ����
	 * @return �����ɹ����ٴ���ʧ��
	 */
	public Boolean validUserByName(String username, String password) {
		
		String hql = "select count(*) from  Teacher o ";
		hql += "where o.account ='" + username + "' and  o.password = '"
				+ password + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		long count = ((Long) query.uniqueResult()).longValue();
		if (count > 0){
			return true;
			}
		else
			return false;
	}

	public Teacher validUserByName2(String account, String password) {
		String hql = "from Teacher o ";
		hql += "where o.account ='" + account + "' and  o.password = '"
				+ password + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Teacher teacher = (Teacher) query.uniqueResult();
		return teacher;
	}
}
