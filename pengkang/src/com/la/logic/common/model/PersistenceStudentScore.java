package com.la.logic.common.model;

import com.la.logic.ann.Table;
import com.la.logic.ann.TableField;
import com.la.logic.ann.TableKey;
import com.la.logic.ann.TableKey.Strategy;

/**
 * @author liugc
 * 学生成绩表
 *
 */
@Table(tablename="student_score")
public class PersistenceStudentScore {
	@TableField(columnName="stu_no")
	@TableKey(strategy=Strategy.NORMAL)
	private String stu_no;
	
	@TableKey(strategy=Strategy.NORMAL)
	@TableField(columnName="course_id")
	private String course_id;
	
	@TableField (columnName="stu_score")
	private double stu_score;

	
	public String getStu_no() {
		return stu_no;
	}

	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}

	public String getCourse_id() {
		return course_id;
	}

	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}

	public double getStu_score() {
		return stu_score;
	}

	public void setStu_score(double stu_score) {
		this.stu_score = stu_score;
	}
	
	
}
