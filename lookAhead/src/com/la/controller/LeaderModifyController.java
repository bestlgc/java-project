package com.la.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.la.service.LeaderModifyService;
import com.la.service.LeaderService;
import com.la.view.ViewLeader;



@Controller
public class LeaderModifyController {
	@Autowired
	LeaderModifyService modifyService;
	@Autowired
	private LeaderService lservice;
	@RequestMapping(value="/leader_edit_Admin")
	public  ModelAndView leadermodify(HttpServletRequest request,HttpSession httpSession){
		try {
			Integer id = (Integer) httpSession.getAttribute("id");
			ViewLeader vleader= lservice.getById(id);
			ModelAndView mv = new ModelAndView("/leader/leader_editAdmin");
			mv.addObject("leader", vleader);
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mv = new ModelAndView("/leader/error");
			return mv;
		}
		
		
	}
	
	@RequestMapping(value="/savePW")
	public  ModelAndView savePW(String password,HttpServletRequest request,HttpSession httpSession){
		try {
			Integer id = (Integer) httpSession.getAttribute("id");
			ViewLeader vleader= lservice.getById(id);
			vleader.setPassword(password);
			lservice.merge(vleader);
			ModelAndView mv = new ModelAndView("/leader/success");
			return mv;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mv = new ModelAndView("/leader/failed");
			return mv;
		}
		
		
	}
	
}
