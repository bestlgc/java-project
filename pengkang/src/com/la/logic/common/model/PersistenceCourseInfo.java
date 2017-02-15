package com.la.logic.common.model;

import com.la.logic.ann.Table;
import com.la.logic.ann.TableField;
import com.la.logic.ann.TableKey;
import com.la.logic.ann.TableKey.Strategy;

@Table(tablename="course_info")
public class PersistenceCourseInfo {
	@TableKey(strategy=Strategy.NORMAL)
	@TableField(columnName="course_id")
	//课程id
	private String course_id;
	//课程名称
	@TableField(columnName="course_name")
	private String course_name;
	//课程所开设的年级 
	@TableField(columnName="course_grade")
	private String course_grade;
	//课程所开设的专业
	@TableField(columnName="course_profession")
	private String course_profession;
	
	//课程的学分
	@TableField(columnName="course_credit")
	private String course_credit;

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_grade() {
		return course_grade;
	}

	public void setCourse_grade(String course_grade) {
		this.course_grade = course_grade;
	}

	public String getCourse_profession() {
		return course_profession;
	}

	public void setCourse_profession(String course_profession) {
		this.course_profession = course_profession;
	}

	public String getCourse_credit() {
		return course_credit;
	}

	public void setCourse_credit(String course_credit) {
		this.course_credit = course_credit;
	}
	
	
}
