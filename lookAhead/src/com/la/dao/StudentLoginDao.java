package com.la.dao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class StudentLoginDao {
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * �����жϵ�¼�û����û����������Ƿ���ȷ
	 * @param username �û���
	 * @param password ����
	 * @return �����ɹ����ٴ���ʧ��
	 */
	public Boolean validUserByName(String username, String password) {
		
		String hql = "select count(*) from  Student ";
		hql += "where username ='" + username + "' and  password = '"
				+ password + "'";

		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		long count = ((Long) query.uniqueResult()).longValue();
		if (count > 0){
			return true;
			}
		else
			return false;
	}
}
