package com.la.logic.common.model;

import com.la.logic.ann.Table;
import com.la.logic.ann.TableField;
import com.la.logic.ann.TableKey;
import com.la.logic.ann.TableKey.Strategy;

@Table(tablename="admin_table")
public class PersistenceAdmin {
	@TableKey(strategy=Strategy.NORMAL)
	@TableField(columnName="admin_name")
	private String adminName;
	
	@TableField(columnName="admin_password")
	private String adminpassword;
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	
	
}
