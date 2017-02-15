package com.la.logic.common.model;

import java.util.Date;

import com.la.logic.ann.Table;
import com.la.logic.ann.TableField;
import com.la.logic.ann.TableKey;
import com.la.logic.ann.TableKey.Strategy;
import com.la.logic.dao.JsonUtil;

/**
 * @author zhangxu
 *
 */
@Table(tablename = "POP_APP_INFO")
public class PersistenceApp {
	@TableKey(strategy = Strategy.NORMAL)
	@TableField(columnName = "APP_CODE")
	private String appCode;

	@TableField(columnName = "APP_NAME")
	private String appName;

	@TableField(columnName = "APP_DESC")
	private String appDesc;

	@TableField(columnName = "APP_CALLBACK")
	private String appCallback;

	@TableField(columnName = "APP_SECRET")
	private String appSecret;

	@TableField(columnName = "APP_C_NAME")
	private String appCName;

	@TableField(columnName = "APP_C_PHONE")
	private String appCphone;

	@TableField(columnName = "PARTNER_CODE")
	private String partnerCode;

	@TableField(columnName = "STATUS")
	private AppStatus status;
	
	@TableField(columnName = "LOGO_ATTACH_ID")
	private String logoAttachId;
    
	@TableField(columnName = "CREATE_TIME")
	private Date createTime;
	
	public String toString() {
		return JsonUtil.toJsonString(this);
	}

	public AppStatus getStatus() {
		return status;
	}

	public void setStatus(AppStatus status) {
		this.status = status;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public String getAppCallback() {
		return appCallback;
	}

	public void setAppCallback(String appCallback) {
		this.appCallback = appCallback;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getAppCName() {
		return appCName;
	}

	public void setAppCName(String appCName) {
		this.appCName = appCName;
	}

	public String getAppCphone() {
		return appCphone;
	}

	public void setAppCphone(String appCphone) {
		this.appCphone = appCphone;
	}


	public String getPartnerCode() {
		return partnerCode;
	}

	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}

	public String getLogoAttachId() {
		return logoAttachId;
	}

	public void setLogoAttachId(String logoAttachId) {
		this.logoAttachId = logoAttachId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
