package com.la.domain;

import java.util.HashSet;
import java.util.Set;

//课件模板
public class CourseModel {
	private Integer id;
	private String modelSubject;//课件模板所属科目(如数学课件模板，语文课件模板)
	private String modelDirectory;//课件模板存放的路径
	private GroupLeader groupOwner;//课件模板的拥有者（即某位教研组长） 
	private Set<Teacher> teachers=new HashSet<Teacher>();//一个课件模板可以被多个教师下载使用
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	public GroupLeader getGroupOwner() {
		return groupOwner;
	}
	public void setGroupOwner(GroupLeader groupOwner) {
		this.groupOwner = groupOwner;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModelSubject() {
		return modelSubject;
	}
	public void setModelSubject(String modelSubject) {
		this.modelSubject = modelSubject;
	}
	public String getModelDirectory() {
		return modelDirectory;
	}
	public void setModelDirectory(String modelDirectory) {
		this.modelDirectory = modelDirectory;
	}
	
}
