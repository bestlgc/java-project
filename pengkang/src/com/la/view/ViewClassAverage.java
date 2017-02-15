package com.la.view;

import java.util.ArrayList;
import java.util.List;

public class ViewClassAverage {
	private String subject;
	private String subjectBanJiScore;
	private List<Double> banjiSocreList;
	
	public  ViewClassAverage() {
		banjiSocreList = new ArrayList<Double>();
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSubjectBanJiScore() {
		return subjectBanJiScore;
	}
	public void setSubjectBanJiScore(String subjectBanJiScore) {
		this.subjectBanJiScore = subjectBanJiScore;
	}
	public List<Double> getBanjiSocreList() {
		return banjiSocreList;
	}
	public void setBanjiSocreList(List<Double> banjiSocreList) {
		this.banjiSocreList = banjiSocreList;
	}
	
	
}
