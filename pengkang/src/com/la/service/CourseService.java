package com.la.service;

import org.apache.ibatis.session.SqlSession;

import com.la.logic.common.model.PersistenceCourseInfo;
import com.la.logic.dao.SqlSessionManager;
import com.la.logic.mapper.PersistenceCourseInfoMapper;
import com.la.view.ViewCourse;

public class CourseService {

	public static void save(ViewCourse course) throws Exception{
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		PersistenceCourseInfo courseInfo = new PersistenceCourseInfo();
		courseInfo.setCourse_id(course.getCourseId());
		courseInfo.setCourse_grade(course.getCourseGrade());
		courseInfo.setCourse_name(course.getCourseName());
		courseInfo.setCourse_profession(course.getCourseProfession());
		courseInfo.setCourse_credit(course.getCourseCredit());
		PersistenceCourseInfoMapper mapper = session.getMapper(PersistenceCourseInfoMapper.class);
		mapper.save(courseInfo);
		
	}

}
