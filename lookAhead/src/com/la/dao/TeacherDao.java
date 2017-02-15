package com.la.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.la.domain.GroupLeader;
import com.la.domain.Teacher;
import com.la.domain.Work;
@Repository
public class TeacherDao {
	@Autowired
	private  SessionFactory sessionFactory;
	
	public  void save(Teacher teacher) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		session.save(teacher);
	}


	@SuppressWarnings("unchecked")
	public  List<Teacher> getList(int pageNum, int pageIndex) throws Exception{
		int start = (pageIndex-1)*pageNum;
//		int end  = pageIndex*pageNum;
		String queryString  = "from Teacher";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setMaxResults(pageNum);
		query.setFirstResult(start);
		List<Teacher> list = query.list();
		return list;
	}
	public int sizeof()throws Exception{
		String queryString  = "SELECT count(*) FROM GroupLeader";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		Long size=  (Long) query.uniqueResult();
		String result = size.toString();
		return Integer.parseInt(result);
	}

	public void merge(Teacher teacher)throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.merge(teacher);
		session.flush();
	}
	public void update(Teacher teacher)throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.update(teacher);
		session.flush();
	}


	public Teacher getById(Integer id) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Teacher teacher = (Teacher) session.get(Teacher.class, id);
		return teacher;
	}


	public void delete(Teacher teacher) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		session.delete(teacher);
		session.flush();
	}


	@SuppressWarnings("unchecked")
	public List<Teacher> getByLeaderId(Integer id) throws Exception{
		String queryString  = "from Teacher where group_leader=?";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter(0, id);
		List<Teacher> list = query.list();
		return list;
	}


	public void saveWork(Work work) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(work);
		tx.commit();
	}


	@SuppressWarnings("unchecked")
	public List<Work> getTaskList(Integer id) {
		String queryString  = "from Work where work_receiver=?";
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		query.setParameter(0, id);
		query.setMaxResults(10);
		query.setFirstResult(1);
		List<Work> list = query.list();
		return list;
	}
	
}