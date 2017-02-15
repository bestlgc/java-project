package com.la.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.la.domain.Student;
import com.la.service.StuLookService;

@Controller
public class StuLookController {
	@Autowired
	StuLookService lookService;
	@RequestMapping(value="/stu_lookAdmin")
	public ModelAndView studentlook(HttpSession session){
		try {
			String account = (String) session.getAttribute("lgcount");
			Student student=lookService.getByAccount(account);
			ModelAndView mv = new ModelAndView("stu_lookAdmin");
			mv.addObject("student", student);
//			mv.addObject("inf", list);
			return mv;
		} catch (Exception e) {
			return new ModelAndView("failed");
		}
		
	}
	
}
