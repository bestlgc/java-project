package com.la.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.la.logic.common.model.persistenceScoreTable;
import com.la.logic.dao.JsonUtil;
import com.la.logic.model.Page;
import com.la.service.ScoreService;
import com.la.view.ViewQueryResult;
import com.la.view.ViewReport;
import com.la.view.ViewScore;

@Controller
@RequestMapping("score")
public class ScoreController {
	@RequestMapping(value="newscore",method=RequestMethod.GET)
	public String newScore(){
		return "pengkang/newscore";
	}
	
	@RequestMapping(value="save",method=RequestMethod.POST)
	public String save(ViewScore score){
		try {
			ScoreService.save(score);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:list.html?pageindex=0&pageNum=15";
	}
	
	@RequestMapping(value="list",method=RequestMethod.GET)
	public ModelAndView list(Integer pageindex,Integer pageNum){
		ModelAndView mv = new ModelAndView("pengkang/listscore");
		Page<persistenceScoreTable> page = ScoreService.getList(pageindex,pageNum);
		mv.addObject("page", page);
		return mv;
	}
	
	@RequestMapping(value="detail",method=RequestMethod.GET)
	public ModelAndView detail(Integer id){
		ModelAndView mv = new ModelAndView("pengkang/scoredetail");
		persistenceScoreTable score = ScoreService.getById( id);
		mv.addObject("score", score);
		return mv;
	}
	
	@RequestMapping(value="download",method=RequestMethod.GET)
	public ResponseEntity<byte[]> download(Integer id){
		HttpHeaders headers = new HttpHeaders();
		byte[] data = null;
		persistenceScoreTable score = ScoreService.getById( id);
		String filename = "default";
		try {
			filename = new String(score.getFileName().getBytes("utf-8"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		headers.setContentDispositionFormData("attachment", filename);
		data = score.getScoreFile();
		return new ResponseEntity<byte[]>(data,headers,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String delete(Integer id){
		ScoreService.deleteById(id);
		return "redirect:list.html?pageindex=0&pageNum=15";
	}
	
	@RequestMapping(value="report",method=RequestMethod.GET)
	public ModelAndView report(Integer id){
		ModelAndView mv = new ModelAndView("pengkang/report");
		ViewReport report = null;
		try {
			report = ScoreService.report(id);
			List<String> setClass  = report.getListClass();
			String classStrList = JsonUtil.toJsonString(setClass);
			
			mv.addObject("classStrList", classStrList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mv.addObject("viewreport", report);
		
		return mv;
	}
	
	@RequestMapping(value="newscore2",method=RequestMethod.GET)
	public String newScore2(){
		return "pengkang/app/new";
	}
	
	@RequestMapping(value="getQuerypage",method=RequestMethod.GET)
	public String getQueryPage(){
		return "pengkang/query";
	}
	
	@RequestMapping(value="query",method=RequestMethod.POST)
	public ModelAndView query(String stuNo){
		ModelAndView mv = new ModelAndView("pengkang/queryresult");
		try {
			ViewQueryResult queryResult = ScoreService.search(stuNo);
			mv.addObject("queryResult", queryResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
}
