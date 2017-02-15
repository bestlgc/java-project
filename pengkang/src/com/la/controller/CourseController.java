package com.la.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.la.service.CourseService;
import com.la.view.ViewCourse;

@Controller
@RequestMapping("course")
public class CourseController {
	@RequestMapping(value="newcourse",method=RequestMethod.GET)
	public String newcourse(){
		return "pengkang/newcourse";
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String save(ViewCourse course){
		try {
			CourseService.save(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pengkang/newcourse";
	}
	
	@RequestMapping(value="listcourse",method=RequestMethod.GET)
	public String listcourse(){
		return "pengkang/listcourse";
	}
}
