package com.la.view;

import org.springframework.web.multipart.MultipartFile;

public class ViewScore {
	private String collegeName;
	private String year;
	private String professionName;
	private String professionNumber;
	private MultipartFile scoreFile;
	
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getProfessionName() {
		return professionName;
	}
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}
	public String getProfessionNumber() {
		return professionNumber;
	}
	public void setProfessionNumber(String professionNumber) {
		this.professionNumber = professionNumber;
	}
	public MultipartFile getScoreFile() {
		return scoreFile;
	}
	public void setScoreFile(MultipartFile scoreFile) {
		this.scoreFile = scoreFile;
	}
	
	
	
}
