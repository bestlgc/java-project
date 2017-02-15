package com.la.view;

import com.la.domain.Admin;

public class ViewAdmin {
	private Integer id;
	private String username;
	private String password;
	public ViewAdmin(Admin admin) {
		this.id = admin.getId();
		this.password = admin.getPassword();
		this.username = admin.getAccount();
	}
	public ViewAdmin(){
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
}
