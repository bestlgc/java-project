package com.la.logic.common.model;


public enum AppStatus {
	s0("创建"), s1("测试"), s2("发布"), s3("暂停"), s4("下线");

	private String desc;

	AppStatus(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
}
