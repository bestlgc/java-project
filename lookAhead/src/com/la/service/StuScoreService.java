package com.la.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.la.dao.StuScoreDao;
import com.la.domain.*;
@Service
public class StuScoreService {
	@Autowired
	StuScoreDao stuScoreDao;
	public List<Courseware> queryCourseware(){
		return stuScoreDao.queryCourseware();
	}
	
	public void updateScore(String id,String score,HttpServletRequest request){
		stuScoreDao.updateScore(id, score, request);
	}
	 public Courseware getStuScore(String id){
		
		return stuScoreDao.getStuScore(id);
	}
	 
	public List<Courseware> queryhisScore(){
		return stuScoreDao.queryhisScore();
	}
}
