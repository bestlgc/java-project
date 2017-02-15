package com.la.domain;

import java.util.Date;
import com.la.view.ViewWork;

//�μ��������
public class Work {
	private Integer id;
	private GroupLeader workSender;//�μ�������񷢳��ߣ��������鳤
	private Teacher workReceiver;//�μ�����������վ������ʦ
	private String workSubject;//�μ��������������Ŀ
	private Date workSendTime;//�μ����������ʱ��
	private String workDeadTime;//�μ���������ֹ����
	private String workState;//�μ���������״̬��0��ʾδ���գ�1��ʾ�ѽ���
	
	public Work() {	
		}
	public Work(ViewWork vwork) {
		this.workSubject = vwork.getSubject();
		this.workSendTime = vwork.getStartDate();
		this.workDeadTime = vwork.getTitle();
		this.workState = vwork.getContent();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public GroupLeader getWorkSender() {
		return workSender;
	}
	public void setWorkSender(GroupLeader workSender) {
		this.workSender = workSender;
	}
	
	public Teacher getWorkReceiver() {
		return workReceiver;
	}
	public void setWorkReceiver(Teacher workReceiver) {
		this.workReceiver = workReceiver;
	}
	public String getWorkSubject() {
		return workSubject;
	}
	public void setWorkSubject(String workSubject) {
		this.workSubject = workSubject;
	}
	
	public Date getWorkSendTime() {
		return workSendTime;
	}
	public void setWorkSendTime(Date workSendTime) {
		this.workSendTime = workSendTime;
	}
	
	public String getWorkDeadTime() {
		return workDeadTime;
	}
	public void setWorkDeadTime(String workDeadTime) {
		this.workDeadTime = workDeadTime;
	}
	public String getWorkState() {
		return workState;
	}
	public void setWorkState(String workState) {
		this.workState = workState;
	}
	
}
