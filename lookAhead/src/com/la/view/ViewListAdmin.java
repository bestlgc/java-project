package com.la.view;

import java.util.List;

public class ViewListAdmin {
	private List<ViewAdmin> viewAdmins;
	private int pageIndex;
	private int pageNum;
	private int size;
	public ViewListAdmin(List<ViewAdmin> viewAdmins, int pageNum2, int pageIndex2,int size) {
		this.viewAdmins = viewAdmins;
		this.pageIndex = pageIndex2;
		this.pageNum = pageNum2;
		this.size = size;
	}
	public  ViewListAdmin() {
		
	}
	public List<ViewAdmin> getViewAdmins() {
		return viewAdmins;
	}
	public void setViewAdmins(List<ViewAdmin> viewAdmins) {
		this.viewAdmins = viewAdmins;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
