package com.la.controller;



import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.la.service.LeaderService;
import com.la.view.ViewAdmin;
import com.la.view.ViewLeader;
import com.la.view.ViewListAdmin;
import com.la.view.ViewListLeader;

@Controller
@RequestMapping(value = "/su")
public class SuController {
	@Autowired
	private LeaderService service;
	
	@RequestMapping(value = "/new",method = RequestMethod.POST)
	public ModelAndView newLeader(HttpServletResponse response,ViewLeader vleader){
		ModelAndView mv = null;
		System.out.println(vleader.getAccount());
		try {
			service.save(vleader);
			mv = new ModelAndView("/su/success");
			return mv;
		} catch (Exception e) {
			mv = new ModelAndView("/su/failed");
			e.printStackTrace();
			return mv;
		}	
	}
	
	@RequestMapping(value = "/newadmin",method = RequestMethod.POST)
	public ModelAndView newAdmin(HttpServletResponse response,ViewAdmin vadmin){
		ModelAndView mv = null;
		try {
			service.save(vadmin);
			mv = new ModelAndView("/su/success");
			return mv;
		} catch (Exception e) {
			mv = new ModelAndView("/su/failed");
			e.printStackTrace();
			return mv;
		}	
	}
	
	@RequestMapping(value = "/adminlist/{pageNum}/{pageIndex}",method = RequestMethod.GET)
	public ModelAndView showAdminList(@PathVariable(value="pageNum") int pageNum,@PathVariable(value="pageIndex") int pageIndex){
		ModelAndView mv = null;		
		try {
			ViewListAdmin vadmins = service.getAdminList(pageNum,pageIndex);
			mv = new ModelAndView("/su/su_lookAdmin");
			mv.addObject("admins", vadmins);
			return mv;
		} catch (Exception e) {
			mv = new ModelAndView("/su/failed");
			e.printStackTrace();
			return mv;
		}	
	}
	
	@RequestMapping(value = "/list/{pageNum}/{pageIndex}",method = RequestMethod.GET)
	public ModelAndView showLeaderList(@PathVariable(value="pageNum") int pageNum,@PathVariable(value="pageIndex") int pageIndex){
		ModelAndView mv = null;
		System.out.println(pageNum);
		
		try {
			ViewListLeader leader = service.getList(pageNum,pageIndex);
			mv = new ModelAndView("/su/su_lookUser");
			mv.addObject("vlist", leader);
			return mv;
		} catch (Exception e) {
			mv = new ModelAndView("/su/failed");
			e.printStackTrace();
			return mv;
		}	
	}
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public ModelAndView save(ViewLeader leader){
		try {
			service.merge(leader);
			ModelAndView mv = new ModelAndView("/su/success");
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("/su/failed");
			e.printStackTrace();
			return mv;
		}
	}
	
	@RequestMapping(value = "/saveAdmin",method = RequestMethod.POST)
	public ModelAndView saveAdmin(ViewAdmin admin){
		try {
			service.update(admin);
			ModelAndView mv = new ModelAndView("/su/success");
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("/su/failed");
			e.printStackTrace();
			return mv;
		}
	}
	
	@RequestMapping(value = "/update/{sid}",method = RequestMethod.GET)
	public ModelAndView gotoUpdate(@PathVariable(value="sid")Integer sid){
		try {
			ViewLeader leader = service.getById(sid);
			ModelAndView mv = new ModelAndView("/su/su_editUser");
			mv.addObject("viewleader", leader);
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("/su/failed");
			e.printStackTrace();
			return mv;
		}
	}
	
	@RequestMapping(value = "/updateAdmin/{vid}",method = RequestMethod.GET)
	public ModelAndView gotoUpdateAdmin(@PathVariable(value="vid")Integer vid){
		try {
			ViewAdmin admin = service.getAdminById(vid);
			ModelAndView mv = new ModelAndView("/su/su_editAdmin");
			mv.addObject("admin", admin);
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("/su/failed");
			e.printStackTrace();
			return mv;
		}
	}
	
	@RequestMapping(value = "/delete/{vid}",method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable(value="vid")Integer vid){
		try {
			service.delete(vid);
			ModelAndView mv = new ModelAndView("/su/success");
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("/su/failed");
			e.printStackTrace();
			return mv;
		}
	}
	
	@RequestMapping(value = "/deleteAdmin/{vid}",method = RequestMethod.GET)
	public ModelAndView deleteAdmin(@PathVariable(value="vid")Integer id){
		try {
			service.deleteAdmin(id);
			ModelAndView mv = new ModelAndView("/su/success");
			return mv;
		} catch (Exception e) {
			ModelAndView mv = new ModelAndView("/su/failed");
			e.printStackTrace();
			return mv;
		}
	}
	@RequestMapping(value = "/query",method = RequestMethod.POST)
	public void query(ViewLeader leader){
		
	}
	
	@RequestMapping(value="page/{pagename}",method = RequestMethod.GET)
	public ModelAndView getPage(@PathVariable(value="pagename")String pagename){
		String path = "/su/" + pagename;
		ModelAndView mv = new ModelAndView(path);
		return mv;
	}
	
}
