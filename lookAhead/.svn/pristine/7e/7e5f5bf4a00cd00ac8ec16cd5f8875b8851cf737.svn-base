package com.la.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.la.domain.Student;

@Repository
public class StudentRegisterDao {
	@Autowired
	SessionFactory sessionFactory;
	public void addStudent(Student student){	
	
		Session session=sessionFactory.getCurrentSession();
		session.save(student);
	}
	public Boolean getStudentByName(String name)
	{
		String hql = "select count(*) from Student o ";
		hql += "where o.username ='" + name+ "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		long count = ((Long) query.uniqueResult()).longValue();
		if (count > 0){
			return true;
		}
		else{		
	       	        
		    return false;
		}
	}

}
