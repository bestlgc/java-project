package com.la.controller;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.la.service.LeaderService;
import com.la.service.TeacherService;
import com.la.view.ViewTaskList;
import com.la.view.ViewTeacher;
import com.la.view.ViewListTeacher;
import com.la.view.ViewWork;
@Controller
@RequestMapping(value = "/leader")
public class LeaderController {
	@Autowired
	private TeacherService service;
	@Autowired
	private LeaderService lService;
	
	@RequestMapping(value = "/new",method = RequestMethod.POST)
	public ModelAndView newTeacher(HttpServletResponse response,ViewTeacher vteacher,Integer glId){
		ModelAndView mv = null;
		System.out.println(vteacher.getAccount());
		try {
			service.save(vteacher,glId);
			mv = new ModelAndView("/leader/success");
			return mv;
		} catch (Exception e) {
			mv = new ModelAndView("/leader/failed");
			e.printStackTrace();
			return mv;
		}	
	}
	
	@RequestMapping(value = "/list/{pageNum}/{pageIndex}",method = RequestMethod.GET)
	public ModelAndView showTeacherList(@PathVariable(value="pageNum") int pageNum,@PathVariable(value="pageIndex") int pageIndex){
		ModelAndView mv = null;
		System.out.println(pageNum);
		try {
			ViewListTeacher teacher = service.getList(pageNum,pageIndex);
			mv = new ModelAndView("/leader/leader_lookUser");
			mv.addObject("vlist", teacher);
			return mv;
		} catch (Exception e) {
			mv = new ModelAndView("/leader/failed");
			e.printStackTrace();
			return mv;
		}	
	}
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ModelAndView save(ViewTeacher teacher){
		try {
			service.update(teacher);
			ModelAndView mv = new ModelAndView("/leader/success");
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("/leader/failed");
			e.printStackTrace();
			return mv;
		}
	}
	
	@RequestMapping(value="/saveTask",method=RequestMethod.POST)
	public ModelAndView saveTask(ViewWork work,HttpSession session){
		try {
			ModelAndView mv =  new ModelAndView("/leader/success");
			java.util.Date startDate = new java.util.Date();
			Integer senderId = (Integer) session.getAttribute("id");
			work.setStartDate(startDate);
			work.setSender(senderId);
			service.saveWork(work);
			return mv;
		} catch (Exception e) {
			ModelAndView mv =  new ModelAndView("/leader/failed");
			e.printStackTrace();
			return mv;
		}
		
	}
	
	@RequestMapping(value = "/update/{vid}",method = RequestMethod.GET)
	public ModelAndView gotoUpdate(@PathVariable(value="vid")Integer vid){
		try {
			ViewTeacher teacher = service.getById(vid);
			ModelAndView mv = new ModelAndView("/leader/leader_editUser");
			mv.addObject("viewteacher", teacher);
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("/leader/failed");
			e.printStackTrace();
			return mv;
		}
	}
	
	@RequestMapping(value = "/delete/{vid}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable(value="vid")Integer vid){
		try {
			service.delete(vid);
			ModelAndView mv = new ModelAndView("/leader/success");
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("/leader/failed");
			e.printStackTrace();
			return mv;
		}
	}
	
	@RequestMapping(value="taskDivide",method = RequestMethod.GET)
	public ModelAndView taskDivide(HttpSession session){
		try {
			ModelAndView mv = new ModelAndView("/leader/ld_message");
			Integer id = (Integer) session.getAttribute("id");
			ViewTaskList vtasklist = service.getViewtask(id);
			mv.addObject("teacherlist", vtasklist);
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("/leader/error");
			e.printStackTrace();
			return mv;
		}
		
	}
	
	@RequestMapping(value="page/{pagename}",method = RequestMethod.GET)
	public ModelAndView getPage(@PathVariable(value="pagename")String pagename){
		String path = "/leader/" + pagename;
		ModelAndView mv = new ModelAndView(path);
		return mv;
	}
}
