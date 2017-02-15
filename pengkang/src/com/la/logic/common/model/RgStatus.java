package com.la.logic.common.model;

public enum RgStatus {
	s0("创建"), s1("发布"), s2("暂停"), s3("下线");

	private String desc;

	RgStatus(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
}
