package com.la.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.la.service.TeacherService;
import com.la.view.ViewTeacherTask;

@Controller
@RequestMapping(value="teacher")
public class TeacherController {
	@Autowired
	private TeacherService service;
	@RequestMapping(value="page/{pagename}",method = RequestMethod.GET)
	public ModelAndView getPage(@PathVariable(value="pagename")String pagename){
		String path = "/teacher/" + pagename;
		ModelAndView mv = new ModelAndView(path);
		return mv;
	}
	
	@RequestMapping(value="getTask",method=RequestMethod.GET)
	public ModelAndView getTask(HttpSession session)
	{
		try {
			ModelAndView mv = new ModelAndView("/teacher/ld_message");
			Integer id = (Integer) session.getAttribute("id");
			List<ViewTeacherTask> list = service.getTaskList(id);
			mv.addObject("tasklist", list);
			return mv;
		} catch (Exception e) {
			return new ModelAndView("failed");
		}
		
	}
}
