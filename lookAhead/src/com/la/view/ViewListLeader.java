package com.la.view;

import java.util.List;

public class ViewListLeader {
	private List<ViewLeader> viewll;
	private int pageIndex;
	private int pageNum;
	private int size;
	public ViewListLeader(List<ViewLeader> list, int pageNum2, int pageIndex2,int size) {
		this.viewll = list;
		this.pageIndex = pageIndex2;
		this.pageNum = pageNum2;
		this.size = size;
	}
	public  ViewListLeader() {
		
	}
	public List<ViewLeader> getViewll() {
		return viewll;
	}
	public void setViewll(List<ViewLeader> viewll) {
		this.viewll = viewll;
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
