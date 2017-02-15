package com.la.domain;

import java.util.HashSet;
import java.util.Set;

//�μ�
public class Courseware {
	private Integer id;
	private String coursewareName;//�μ�����
	private String coursewareSubject;//�μ�������Ŀ
	private Teacher coursewareOwner;//�μ��������ߣ��ϴ��ߣ�����ĳλ��ʦ
	private GroupLeader groupLeader;//�μ�������ߣ������鳤
	private String downloadNum;//�μ�������
	private String coursewareScore;//�μ���������
	private String coursewareState;//�μ���״̬����ʦ�ϴ��μ���coursewareStateΪ0��ʾ�μ����ڡ�δ��ˡ�״̬����ʦ�����μ���coursewareStateֵΪ1��ʾ�μ������ͨ���������μ������޸ģ���coursewareStateֵΪ2��ʾ�ÿμ�����Ч����
	private Set<Score> scores=new HashSet<Score>();//һ���μ������ж������
	private Set<Student> students=new HashSet<Student>();//һ���μ����Ա����ѧ������
	private Advice advice;
	public Advice getAdvice() {
		return advice;
	}
	public void setAdvice(Advice advice) {
		this.advice = advice;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<Score> getScores() {
		return scores;
	}
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCoursewareName() {
		return coursewareName;
	}
	public void setCoursewareName(String coursewareName) {
		this.coursewareName = coursewareName;
	}
	public String getCoursewareSubject() {
		return coursewareSubject;
	}
	public void setCoursewareSubject(String coursewareSubject) {
		this.coursewareSubject = coursewareSubject;
	}
	public Teacher getCoursewareOwner() {
		return coursewareOwner;
	}
	public void setCoursewareOwner(Teacher coursewareOwner) {
		this.coursewareOwner = coursewareOwner;
	}
	public GroupLeader getGroupLeader() {
		return groupLeader;
	}
	public void setGroupLeader(GroupLeader groupLeader) {
		this.groupLeader = groupLeader;
	}
	public String getDownloadNum() {
		return downloadNum;
	}
	public void setDownloadNum(String downloadNum) {
		this.downloadNum = downloadNum;
	}
	public String getCoursewareScore() {
		return coursewareScore;
	}
	public void setCoursewareScore(String coursewareScore) {
		this.coursewareScore = coursewareScore;
	}
	public String getCoursewareState() {
		return coursewareState;
	}
	public void setCoursewareState(String coursewareState) {
		this.coursewareState = coursewareState;
	}
}
