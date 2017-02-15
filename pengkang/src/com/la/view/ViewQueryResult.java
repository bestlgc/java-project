package com.la.view;

import java.util.List;

public class ViewQueryResult {
	private String stuNo;
	private String stuName;
	List<ViewSubjectScore> viewSubjectScores;
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public List<ViewSubjectScore> getViewSubjectScores() {
		return viewSubjectScores;
	}
	public void setViewSubjectScores(List<ViewSubjectScore> viewSubjectScores) {
		this.viewSubjectScores = viewSubjectScores;
	}
	
	
}
