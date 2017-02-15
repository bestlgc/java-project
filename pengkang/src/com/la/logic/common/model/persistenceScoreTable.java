package com.la.logic.common.model;

import com.la.logic.ann.Table;
import com.la.logic.ann.TableField;
import com.la.logic.ann.TableKey;
import com.la.logic.ann.TableKey.Strategy;

@Table(tablename="score_table")
public class persistenceScoreTable {
	@TableKey( strategy = Strategy.SEQ)
	@TableField(columnName="id")
	private int id;
	@TableField(columnName="collegeName")
	private String collegeName;
	
	@TableField(columnName="year")
	private String year;
	
	@TableField(columnName="professionName")
	private String professionName;
	
	@TableField(columnName="professionNumber")
	private String professionNumber;
	
	@TableField(columnName="scoreFile")
	private byte[] scoreFile;
	
	@TableField(columnName="fileName")
	private String fileName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public byte[] getScoreFile() {
		return scoreFile;
	}
	public void setScoreFile(byte[] scoreFile) {
		this.scoreFile = scoreFile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
