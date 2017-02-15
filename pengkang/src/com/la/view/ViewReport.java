package com.la.view;

import java.util.List;

public class ViewReport {
	//专业总人数
	private int studentCount;
	//平均分
	private double averageScore;
	//班级个数
	private int classCount;
	//优良率
	private double excellentRate;
	//不及格率
	private double failurerate;
	//班级列表
	private List<String> listClass;
	//科目列表json字符串
	private String listSubject;
	//科目列表的挂科人数，json字符串
	private String listSubjectFailure;
	
	//每个班级的成绩分布，每个字符串为一个班级的成绩分布json字符串。
	private List<String> distribution;
	//每个班级的总人数
	
	//每个班级的挂科率
	
	//每个班级优良率
		
	//每个班级的平均分
	private String dis59Json;
	private String dis79Json;
	private String dis100Json;
	
	private String goodRate;
	private String badRate;
	
	private List<ViewClassAverage> listAverages;
	
	private String filename;
	private String collegeName;
	private String professionName;
	private String year;
	
	
	
	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getProfessionName() {
		return professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<ViewClassAverage> getListAverages() {
		return listAverages;
	}

	public void setListAverages(List<ViewClassAverage> listAverages) {
		this.listAverages = listAverages;
	}

	public String getGoodRate() {
		return goodRate;
	}

	public void setGoodRate(String goodRate) {
		this.goodRate = goodRate;
	}

	public String getBadRate() {
		return badRate;
	}

	public void setBadRate(String badRate) {
		this.badRate = badRate;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void setStudentCount(int studentCount) {
		this.studentCount = studentCount;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public int getClassCount() {
		return classCount;
	}

	public void setClassCount(int classCount) {
		this.classCount = classCount;
	}

	public double getExcellentRate() {
		return excellentRate;
	}

	public void setExcellentRate(double excellentRate) {
		this.excellentRate = excellentRate;
	}

	public double getFailurerate() {
		return failurerate;
	}

	public void setFailurerate(double failurerate) {
		this.failurerate = failurerate;
	}

	public List<String> getListClass() {
		return listClass;
	}

	public void setListClass(List<String> listClass) {
		this.listClass = listClass;
	}

	public String getListSubject() {
		return listSubject;
	}

	public void setListSubject(String listSubject) {
		this.listSubject = listSubject;
	}

	public String getListSubjectFailure() {
		return listSubjectFailure;
	}

	public void setListSubjectFailure(String listSubjectFailure) {
		this.listSubjectFailure = listSubjectFailure;
	}

	public List<String> getDistribution() {
		return distribution;
	}

	public void setDistribution(List<String> distribution) {
		this.distribution = distribution;
	}

	public String getDis59Json() {
		return dis59Json;
	}

	public void setDis59Json(String dis59Json) {
		this.dis59Json = dis59Json;
	}

	public String getDis79Json() {
		return dis79Json;
	}

	public void setDis79Json(String dis79Json) {
		this.dis79Json = dis79Json;
	}

	public String getDis100Json() {
		return dis100Json;
	}

	public void setDis100Json(String dis100Json) {
		this.dis100Json = dis100Json;
	}

	
	
	
	
}
