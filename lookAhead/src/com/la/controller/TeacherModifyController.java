package com.la.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.la.service.TeacherModifyService;
import com.la.service.TeacherService;

import com.la.view.ViewTeacher;

@Controller
public class TeacherModifyController {
	@Autowired
	TeacherModifyService modifyService;
	@Autowired
	private TeacherService lservice;
	@RequestMapping(value="/tc_edit_Key")
	public  ModelAndView teachermodify(HttpServletRequest request,HttpSession httpSession){
		try {
			Integer id = (Integer) httpSession.getAttribute("id");
			ViewTeacher vteacher= lservice.getById(id);
			ModelAndView mv = new ModelAndView("/teacher/tc_editKey");
			mv.addObject("teacher", vteacher);
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mv = new ModelAndView("/tea                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  cher/error");
			return mv;
		}
		
		
	}
	
	@RequestMapping(value="/savePE")
	public  ModelAndView savePE(String password,HttpServletRequest request,HttpSession httpSession){
		try {
			Integer id = (Integer) httpSession.getAttribute("id");
			ViewTeacher vteacher= lservice.getById(id);
			vteacher.setPassword(password);
			lservice.merge(vteacher);
			ModelAndView mv = new ModelAndView("/teacher/success");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mv = new ModelAndView("/teacher/failed");
			return mv;
		}
		
		
	}

}
