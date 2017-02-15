package com.la.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.la.domain.GroupLeader;
import com.la.service.LeaderLookService;

@Controller
public class LeaderlookController {
	@Autowired
	LeaderLookService lookService;
	@RequestMapping(value="/leader_lookAdmin")
	public ModelAndView leaderlook(GroupLeader groupleader,HttpServletRequest request){
		List<GroupLeader> list=lookService.getList(groupleader);
		ModelAndView mv = new ModelAndView("/leader/leader_lookAdmin");
		mv.addObject("users", list);
		return mv;
	}
	
}
