package com.la.view;

import com.la.domain.GroupLeader;

public class ViewLeader {
	private Integer vid;
	private String account;
	private String password;
	private String name;
	private String sex;
	private String state;
	private String subject;
	private String email;
	public  ViewLeader() {
		
	}
	public ViewLeader(GroupLeader groupLeader) {
		this.account = groupLeader.getAccount();
		this.password = groupLeader.getPassword();
		this.name = groupLeader.getGroupLeaderName();
		this.sex = groupLeader.getGroupLeaderSex();
		this.state = groupLeader.getGroupLeaderState();
		this.subject = groupLeader.getGroupLeaderSubject();
		this.email = groupLeader.getGroupLeaderEmail();
		this.vid = groupLeader.getId();
	}
	
	public Integer getVid() {
		return vid;
	}
	public void setVid(Integer vid) {
		this.vid = vid;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
