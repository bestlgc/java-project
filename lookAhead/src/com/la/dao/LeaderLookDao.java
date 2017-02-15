package com.la.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.la.domain.GroupLeader;

@Repository
public class LeaderLookDao {
	@Autowired
	SessionFactory sessionFactory;
	public List<GroupLeader> getList(GroupLeader groupleader){
		String queryString  = "from GroupLeader";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		List<GroupLeader> list = query.list();
		return list;
	}
}
