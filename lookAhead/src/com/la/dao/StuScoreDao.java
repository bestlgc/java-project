package com.la.dao;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.la.domain.*;


@Repository
public class StuScoreDao {
	@Autowired
	SessionFactory sessionFactory;
	public List<Courseware> queryCourseware(){

		String hql=" from Courseware";
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		List<Courseware> coursewares=query.list();
		System.out.println(coursewares.size());
		return coursewares;
		
	}
	
	 public void updateScore(String id,String score,HttpServletRequest request){
		 Session session=sessionFactory.getCurrentSession();
		Courseware courseware=(Courseware)session.get(Courseware.class, Integer.parseInt(id));
		//新的分数=原来分数+本次评分分数
		Integer newScore=Integer.parseInt(courseware.getCoursewareScore())+Integer.parseInt(score);
		//将数据库中的分数更新
		String hql="update Courseware c set c.coursewareScore=? where c.id=?";
		Query query= session.createQuery(hql).setString(0,newScore.toString()).setString(1, id);
		query.executeUpdate();
		//将已经评分的课程id，分数信息写入tb_score表中，以便于浏览历史记录
		Score myScore= new Score();
		myScore.setId(Integer.parseInt(id));
		myScore.setScore(newScore.toString());
		session.save(myScore);
	}
	 public Courseware getStuScore(String id){
		 Session session=sessionFactory.getCurrentSession();
		Courseware courseware=(Courseware)session.get(Courseware.class, Integer.parseInt(id));
		return courseware;
	}
	
	public List<Courseware> queryhisScore(){
		//select h from Hytxbz as h,Tgbzk as t where h.hytxbzid=t.hytxbzid and t.bztgid=:bztgid
		String hql="select c from Courseware as c,Score as s where c.id=s.id";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Courseware> hisscores=query.list();
		return hisscores;
	}
}
