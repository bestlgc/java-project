package com.la.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.la.dao.LeaderDao;
import com.la.dao.TeacherDao;
import com.la.domain.GroupLeader;
import com.la.domain.Teacher;
import com.la.domain.Work;
import com.la.view.ViewListTeacher;
import com.la.view.ViewTask;
import com.la.view.ViewTaskList;
import com.la.view.ViewTeacher;
import com.la.view.ViewTeacherTask;
import com.la.view.ViewWork;

@Service
public class TeacherService {
	@Autowired
	private TeacherDao dao;
	@Autowired
	private LeaderDao leaderDao;
	
	public  void save(ViewTeacher vteacher, Integer glId) throws Exception {
			Teacher teacher = new Teacher(vteacher);
			GroupLeader groupLeader = leaderDao.getById(glId);
			teacher.setGroupLeader(groupLeader);
			dao.save(teacher);
	}
	
	public ViewListTeacher getList(int pageNum, int pageIndex)throws Exception {
		List<Teacher> ts = dao.getList(pageNum,pageIndex);
		List<ViewTeacher> list = new ArrayList<ViewTeacher>();
		for (Teacher teacher : ts) {
			ViewTeacher vTeacher = new ViewTeacher(teacher);
			list.add(vTeacher);
		}
		int totalSize = dao.sizeof();
		ViewListTeacher viewListTeacher = new ViewListTeacher(list,pageNum,pageIndex,totalSize);
		return viewListTeacher;
	}

	public void update(ViewTeacher teacher) throws Exception{
		Teacher gleader = new Teacher(teacher);
		dao.update(gleader);
	}

	public ViewTeacher getById(Integer id) throws Exception{
		Teacher teacher = dao.getById(id);
		ViewTeacher vteacher = new ViewTeacher(teacher);
		return vteacher;
	}

	public void delete(Integer id) throws Exception{
		Teacher teacher = new Teacher();
		teacher.setId(id);
		dao.delete(teacher);
	}
	public void merge(ViewTeacher vteacher) throws Exception{
			Teacher teacher = new Teacher(vteacher);
			dao.merge(teacher);
	}

	public ViewTaskList getViewtask(Integer id) throws Exception {
		List<Teacher> teachers = dao.getByLeaderId(id);
		ViewTaskList list = new ViewTaskList();
		List<ViewTask> lvt = new ArrayList<ViewTask>();
		if (teachers==null) {
			return null;
		}
		for (Teacher teacher : teachers) {
			ViewTask task = new ViewTask(teacher.getAccount(),teacher.getTeacherName(),teacher.getId());
			lvt.add(task);
		}
		list.setViewlist(lvt);
		return list;
	}

	public void saveWork(ViewWork vwork) throws Exception{
		GroupLeader gLeader = leaderDao.getById(vwork.getSender());
		String teacherIDs[] = vwork.getTeachers();
		for (String str : teacherIDs) {
			Work work = new Work(vwork);
			work.setWorkSender(gLeader);
			Teacher teacher = dao.getById(new Integer(str));
			work.setWorkReceiver(teacher);
			dao.saveWork(work);
		} 
		
	}

	public List<ViewTeacherTask> getTaskList(Integer id) throws Exception{
		List<ViewTeacherTask> teacherTasks = new ArrayList<ViewTeacherTask>();
		List<Work> works = dao.getTaskList(id);
		for (Work work : works) {
			ViewTeacherTask task = new ViewTeacherTask(work);
			teacherTasks.add(task);
		}
		return teacherTasks;
	}	
}
