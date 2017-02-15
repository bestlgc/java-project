package com.la.view;

import java.util.Date;

import com.la.domain.Work;

public class ViewTeacherTask {
	private String title;
	private String senderName;
	private String subject;
	private Integer workID;
	private Date startDate;
	private Integer senderId;
	private String content;
	public ViewTeacherTask() {
		
	}
	public ViewTeacherTask(Work work) {
		this.title = work.getWorkDeadTime();
		this.content = work.getWorkState();
		this.senderName = work.getWorkSender().getGroupLeaderName();
		this.subject = work.getWorkSubject();
		this.startDate = work.getWorkSendTime();
		this.senderId = work.getWorkSender().getId();
		this.workID = work.getWorkReceiver().getId();
	}
	
	
	public Integer getWorkID() {
		return workID;
	}
	public void setWorkID(Integer workID) {
		this.workID = workID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
