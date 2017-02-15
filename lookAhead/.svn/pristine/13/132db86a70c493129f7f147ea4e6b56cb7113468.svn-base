package com.la.domain;

import java.util.HashSet;
import java.util.Set;

//课件
public class Courseware {
	private Integer id;
	private String coursewareName;//课件名称
	private String coursewareSubject;//课件所属科目
	private Teacher coursewareOwner;//课件的所有者（上传者），即某位教师
	private GroupLeader groupLeader;//课件的审核者，教研组长
	private String downloadNum;//课件下载量
	private String coursewareScore;//课件的总评分
	private String coursewareState;//课件的状态，教师上传课件后，coursewareState为0表示课件处于“未审核”状态；教师发布课件后，coursewareState值为1表示课件“审核通过”；若课件还需修改，则coursewareState值为2表示该课件”无效“。
	private Set<Score> scores=new HashSet<Score>();//一个课件可以有多个评分
	private Set<Student> students=new HashSet<Student>();//一个课件可以被多个学生下载
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
