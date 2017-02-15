package com.la.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.la.domain.Admin;
import com.la.domain.CourseFile;
@Repository
public class CourseFileDao {
	@Autowired
	private  SessionFactory sessionFactory;
	
	public  void save(CourseFile course) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		System.out.println(course.getPath().length());
		session.save(course);
	}


	@SuppressWarnings("unchecked")
	public  List<CourseFile> getList(int pageNum, int pageIndex) throws Exception{
		int start = (pageIndex-1)*pageNum;
		String queryString  = "from CourseFile";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setMaxResults(pageNum);
		query.setFirstResult(start);
		List<CourseFile> list = query.list();
		return list;
	}
	public int sizeof()throws Exception{
		String queryString  = "SELECT count(*) FROM CourseFile";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		Long size=  (Long) query.uniqueResult();
		String result = size.toString();
		return Integer.parseInt(result);
	}


	public void update(CourseFile course)throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.update(course);
		session.flush();
	}


	public CourseFile getById(Integer id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		CourseFile gLeader = (CourseFile) session.get(CourseFile.class, id);
		return gLeader;
	}


	public void delete(CourseFile course) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		session.delete(course);
		session.flush();
	}


		
}
