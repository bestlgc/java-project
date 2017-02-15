package com.la.domain;

import java.util.HashSet;
import java.util.Set;

import com.la.view.ViewTeacher;

//��ʦ
public class Teacher {
	private Integer id;
	private String account;//��ʦ�˺�
	private String password;//��ʦ����
	private String teacherName;//��ʦ����
	private String teacherSex;//��ʦ�Ա�
	private String teacherSubject;//��ʦ���ڽ������Ŀ����Ӣ���飬��ѧ��ȣ�
	private String teacherState;//��ʦ״̬0��ʾ������1��ʾ����,���ý�ʦ������������鳤��ְʱ��teacherState��1��Ϊ0
	private String teacherEmail;//��ʦ������
	private GroupLeader groupLeader;//һ����ʦ����һ�������鳤����
	private Set<Work> works=new HashSet<Work>();//һ����ʦ���Խ��ն���μ��������
	private Set<CourseModel> models=new HashSet<CourseModel>();//һ����ʦ����ʹ�ö���μ�ģ��
	private Set<Courseware> coursewares=new HashSet<Courseware>();//һ����ʦ�����ϴ�����μ�
	private Set<Advice> advices=new HashSet<Advice>();//һ����ʦ���Խ��ܶ������
	
	public Teacher(ViewTeacher vteacher) {
		this.id = vteacher.getId();
		this.account = vteacher.getAccount();
		this.password = vteacher.getPassword();
		this.teacherName = vteacher.getName();
		this.teacherSex = vteacher.getSex();
		this.teacherSubject = vteacher.getSubject();
		this.teacherState = vteacher.getState();
		this.teacherEmail = vteacher.getEmail();
	}
	
	public Teacher() {
	}
	public Set<Advice> getAdvices() {
		return advices;
	}
	public void setAdvices(Set<Advice> advices) {
		this.advices = advices;
	}
	public Set<CourseModel> getModels() {
		return models;
	}
	public void setModels(Set<CourseModel> models) {
		this.models = models;
	}
	public Set<Courseware> getCoursewares() {
		return coursewares;
	}
	public void setCoursewares(Set<Courseware> coursewares) {
		this.coursewares = coursewares;
	}
	public GroupLeader getGroupLeader() {
		return groupLeader;
	}
	public void setGroupLeader(GroupLeader groupLeader) {
		this.groupLeader = groupLeader;
	}
	public Set<Work> getWorks() {
		return works;
	}
	public void setWorks(Set<Work> works) {
		this.works = works;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherSex() {
		return teacherSex;
	}
	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}
	public String getTeacherSubject() {
		return teacherSubject;
	}
	public void setTeacherSubject(String teacherSubject) {
		this.teacherSubject = teacherSubject;
	}
	public String getTeacherState() {
		return teacherState;
	}
	public void setTeacherState(String teacherState) {
		this.teacherState = teacherState;
	}
	public String getTeacherEmail() {
		return teacherEmail;
	}
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
	
}
