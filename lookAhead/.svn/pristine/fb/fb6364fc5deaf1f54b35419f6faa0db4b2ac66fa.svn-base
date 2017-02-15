package com.la.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.la.domain.Courseware;
import com.la.service.StuScoreService;


@Controller
public class StuScoreController {
	@Autowired
	StuScoreService stuScoreService;

	@RequestMapping(value = "/stu_score")
	public String stu_score(HttpServletRequest request) {
		List<Courseware> coursewares = stuScoreService.queryCourseware();
		request.setAttribute("coursewares", coursewares);
		return "stu_score";
	}

	@ResponseBody
	@RequestMapping(value = "/stu_scoresubmit")
	public String stu_scoresubmit(String id, String score, HttpServletRequest request) {
		
		// 1. 通过ID获取 课程信息，
		// 2. 修改分数（原分数+现有分数）,存入评分历史记录表中
		// 3. 保存信息,并将新的分数信息传到前台页面显示

		// ID不存在 msg : -1 ,成功 ：msg =1, 失败 :msg:0
		stuScoreService.updateScore(id, score, request);
		
		Courseware courseware=stuScoreService.getStuScore(id);
		int newscore=Integer.parseInt(courseware.getCoursewareScore())+Integer.parseInt(score);
		return "{\"msg\":1,\"score\":"+newscore+"}";
	}
	
	@RequestMapping(value = "/stu_score2")
	public String stu_score2(HttpServletRequest request) {
		List<Courseware> hisscores = stuScoreService.queryhisScore();
		request.setAttribute("hisscores", hisscores);
		return "stu_score2";
	}
}
