package com.la.domain;

import com.la.view.ViewAdmin;

//ϵͳ����Ա
public class CourseFile {
	private Integer id;
	private String fileName;//����Ա�˺�
	private String path;//����Ա�˺�
	private String author;//����Ա����
	private String comment;
	public CourseFile(ViewAdmin admin) {
		this.id = admin.getId();
		this.fileName = admin.getUsername();
		this.author = admin.getPassword();
	}
	
	public CourseFile(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
