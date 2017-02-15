package com.la.logic.common.model;

import com.la.logic.ann.Table;
import com.la.logic.ann.TableField;
import com.la.logic.ann.TableKey;
import com.la.logic.ann.TableKey.Strategy;

/**
 * @author liugc
 * 学生信息表
 *
 */
@Table(tablename="student_info")
public class PersistenceStudentInfo {
	@TableKey(strategy=Strategy.NORMAL)
	@TableField(columnName="stu_no")
	private String stu_no;
	
	@TableField(columnName="class_id")
	private String class_id;
	
	@TableField(columnName="stu_name")
	private String stu_name;
	
	@TableField(columnName="stu_address")
	private String stu_address;

	public String getStu_no() {
		return stu_no;
	}

	public void setStu_no(String stu_no) {
		this.stu_no = stu_no;
	}

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_address() {
		return stu_address;
	}

	public void setStu_address(String stu_address) {
		this.stu_address = stu_address;
	}
		
	
}
