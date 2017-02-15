package com.la.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.la.domain.Teacher;
import com.la.service.TeacherLookService;

@Controller
public class TeacherlookController {
	@Autowired
	TeacherLookService lookService;
	@RequestMapping(value="/tc_lookKey")
	public ModelAndView teacherlook(Teacher teacher,HttpServletRequest request){
		List<Teacher> list=lookService.getList(teacher);
		ModelAndView mv = new ModelAndView("/teacher/tc_lookKey");
		mv.addObject("users", list);
		return mv;
	}
	
}
