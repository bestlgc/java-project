package com.la.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.la.domain.Student;
import com.la.service.StuModifyService;
import com.la.service.StudentService;

@Controller
public class StuModifyController {
	@Autowired
	StuModifyService modifyService;
	@Autowired
	private StudentService lservice;
	@RequestMapping(value="/stu_edit")
	public  ModelAndView stumodify(Student student){
		try {
			lservice.update(student);
			ModelAndView mv = new ModelAndView("success");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mv = new ModelAndView("failed");
			return mv;
		}
		
		
	}
	
}
