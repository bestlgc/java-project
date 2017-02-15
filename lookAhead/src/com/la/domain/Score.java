package com.la.domain;
//����
public class Score {
	private Integer id;
	private Student scoreGiver;//�����ˣ���ĳλѧ��
	private Courseware scoreCourseware;//�����ֵĿμ�
	private String score;//��������������1-5�֣�1�ִ���ǳ������⣻2�ִ������⣻3�ִ���һ�㣻4�ִ���������⣻5�ִ���ǳ����⡣���ݿ�Ŀμ����У��޸ĸÿμ��ķ���ֵ��
	//public Score(){}
	//public Score(Integer id,String score){}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Student getScoreGiver() {
		return scoreGiver;
	}
	public void setScoreGiver(Student scoreGiver) {
		this.scoreGiver = scoreGiver;
	}
	public Courseware getScoreCourseware() {
		return scoreCourseware;
	}
	public void setScoreCourseware(Courseware scoreCourseware) {
		this.scoreCourseware = scoreCourseware;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	
}
