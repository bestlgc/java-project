package com.la.dao;
import org.hibernate.SessionFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.la.domain.GroupLeader;



@Repository
public class LeaderModifyDao {
	@Autowired
	SessionFactory sessionFactory;
	public Boolean modifypassword(GroupLeader groupleader)throws Exception{
		Session session=sessionFactory.getCurrentSession();
		session.update(groupleader);
		return true;
	}
	public List<GroupLeader> getList(GroupLeader groupleader){
		String queryString  = "from GroupLeader";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<GroupLeader> list = query.list();
		return list;
	}
	
}
