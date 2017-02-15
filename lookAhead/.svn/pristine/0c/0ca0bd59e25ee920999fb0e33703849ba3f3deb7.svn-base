package com.la.controller;

import com.la.domain.Student;
import com.la.service.StudentRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentRegisterController {
	@Autowired
	StudentRegisterService registerService;
   @RequestMapping(value="/stuRegister")
   public String stuRegister(Student student){
	   registerService.stuRegister(student);
	   return "login";
  }
   
   @ResponseBody
   @RequestMapping(value="/user_check")
   public String user_check(String username){	   
	
	 if(  registerService.getStudentByName(username)){
		 return "true";
		 
	 }else 
		 return "false";
   
  }
   @RequestMapping(value="/stu_main")
   public String stu_main(Student student){
	   //registerService.stuRegister(student);
	   return "stu_main";
  }
   
}
