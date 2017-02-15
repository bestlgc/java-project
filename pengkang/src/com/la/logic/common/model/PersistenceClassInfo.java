package com.la.logic.common.model;

import com.la.logic.ann.Table;
import com.la.logic.ann.TableField;
import com.la.logic.ann.TableKey;
import com.la.logic.ann.TableKey.Strategy;

/**
 * @author liugc
 * 班级表
 *
 */
@Table(tablename="class_info")
public class PersistenceClassInfo { 
	
	@TableKey(strategy=Strategy.NORMAL)
	@TableField(columnName="class_id")
	//班级id
	private String class_id;
	//专业名称
	@TableField(columnName="profession_name")
	private String profession_name;
	//班级名称
	@TableField(columnName="class_name")
	private String class_name;
	
	//学院id
	@TableField(columnName="academy_id")
	private String academy_id;
	//入学年份
	@TableField(columnName="start_time")
	private String start_time;

	public String getClass_id() {
		return class_id;
	}

	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}

	public String getProfession_name() {
		return profession_name;
	}

	public void setProfession_name(String profession_name) {
		this.profession_name = profession_name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getAcademy_id() {
		return academy_id;
	}

	public void setAcademy_id(String academy_id) {
		this.academy_id = academy_id;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	
	
}
