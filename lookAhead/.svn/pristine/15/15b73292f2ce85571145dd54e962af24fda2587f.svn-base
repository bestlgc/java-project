package com.la.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.la.dao.LeaderLookDao;
import com.la.dao.LeaderModifyDao;
import com.la.domain.GroupLeader;

@Service
@Transactional
public class LeaderLookService {
	@Autowired 
	LeaderLookDao lookdao;
	public List<GroupLeader> getList(GroupLeader groupleader){
		return lookdao.getList(groupleader);	
	}

}
