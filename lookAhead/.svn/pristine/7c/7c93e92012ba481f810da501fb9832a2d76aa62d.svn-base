package com.la.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.la.dao.LeaderDao;
import com.la.domain.Admin;
import com.la.domain.GroupLeader;
import com.la.view.ViewAdmin;
import com.la.view.ViewLeader;
import com.la.view.ViewListAdmin;
import com.la.view.ViewListLeader;
import com.la.view.ViewTask;

@Service
public class LeaderService {
	@Autowired
	private LeaderDao dao;
	public  void save(ViewLeader vleader) throws Exception {
			GroupLeader leader = new GroupLeader(vleader);
			dao.save(leader);
	}
	
	public ViewListLeader getList(int pageNum, int pageIndex)throws Exception {
		List<GroupLeader> lgroup = dao.getList(pageNum,pageIndex);
		List<ViewLeader> list = new ArrayList<ViewLeader>();
		for (GroupLeader groupLeader : lgroup) {
			ViewLeader leader = new ViewLeader(groupLeader);
			list.add(leader);
		}
		int totalSize = dao.sizeof();
		ViewListLeader viewListLeader = new ViewListLeader(list,pageNum,pageIndex,totalSize);
		return viewListLeader;
	}

	public void update(ViewLeader leader) throws Exception{
		GroupLeader gleader = new GroupLeader(leader);
		dao.update(gleader);
	}

	public ViewLeader getById(Integer id) throws Exception{
		GroupLeader gLeader = dao.getById(id);
		ViewLeader vLeader = new ViewLeader(gLeader);
		return vLeader;
	}

	public void delete(Integer id) throws Exception{
		GroupLeader leader = new GroupLeader();
		leader.setId(id);
		dao.delete(leader);
	}

	public void save(ViewAdmin vadmin) throws Exception{
		Admin admin = new Admin();
		admin.setAccount(vadmin.getUsername());
		admin.setPassword(vadmin.getPassword());
		dao.save(admin);
	}

	public ViewListAdmin getAdminList(int pageNum, int pageIndex) throws Exception{
		List<Admin> lgroup = dao.getAdminList(pageNum,pageIndex);
		List<ViewAdmin> list = new ArrayList<ViewAdmin>();
		for (Admin admin : lgroup) {
			ViewAdmin vAdmin = new ViewAdmin(admin);
			list.add(vAdmin);
		}
		//int totalSize = dao.sizeof();
		ViewListAdmin vlaAdmin = new ViewListAdmin(list,pageNum,pageIndex,20);
		return vlaAdmin;
	}

	public ViewAdmin getAdminById(Integer id) throws Exception{
		Admin admin = dao.getAdminById(id);
		ViewAdmin vAdmin = new ViewAdmin(admin);
		return vAdmin;
	}

	public void update(ViewAdmin admin) throws Exception{
		Admin gleader = new Admin(admin);
		dao.update(gleader);
	}

	public void deleteAdmin(Integer id) {
		Admin admin = new Admin();
		admin.setId(id);
		dao.delete(admin);
	}

	public void merge(ViewLeader vleader) throws Exception{
		GroupLeader gleader = new GroupLeader(vleader);
		dao.merge(gleader);
	}	
	}


