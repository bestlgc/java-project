package com.la.dao;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.la.domain.GroupLeader;
@Repository
public class LeaderLoginDao {
	@Autowired
	SessionFactory sessionFactory;

	/**
	 * �����жϵ�¼�û����û����������Ƿ���ȷ
	 * @param username �û���
	 * @param password ����
	 * @return �����ɹ����ٴ���ʧ��
	 */
	public Boolean validUserByName(String username, String password) {
		
		String hql = "select count(*) from  GroupLeader o ";
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
	
	public GroupLeader validUser(String username, String password) {
			try {
				String hql = "from  GroupLeader o ";
				hql += "where o.account ='" + username + "' and  o.password = '"
						+ password + "'";
		
				Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
				GroupLeader leader =  (GroupLeader)query.uniqueResult();
				return leader;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			
	}
}
