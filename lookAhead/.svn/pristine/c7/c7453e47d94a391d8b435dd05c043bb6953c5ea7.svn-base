package com.la.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.la.dao.LeaderModifyDao;
import com.la.domain.GroupLeader;

@Service
@Transactional
public class LeaderModifyService {
	@Autowired 
	LeaderModifyDao modifydao;
	public Boolean leaderModify(GroupLeader groupleader) throws Exception{
		return modifydao.modifypassword(groupleader);	
		}
	public List<GroupLeader> getList(GroupLeader groupleader){
		return modifydao.getList(groupleader);	
	}
}
