package com.la.domain;
//���
public class Advice {
	private Integer id;
	private String title;//����ı���
	private String content;//���������
	private GroupLeader adviceGiver;//���������ߣ���ĳλ�����鳤
	private Teacher adviceReceiver;//����Ľ����ߣ���ĳλ��ʦ
	private Courseware courseware;//�������Ե�ĳ���μ�
	private String adviceState;//�����״̬��0��ʾδ���գ�1��ʾ���գ�
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public GroupLeader getAdviceGiver() {
		return adviceGiver;
	}
	public void setAdviceGiver(GroupLeader adviceGiver) {
		this.adviceGiver = adviceGiver;
	}
	public Teacher getAdviceReceiver() {
		return adviceReceiver;
	}
	public void setAdviceReceiver(Teacher adviceReceiver) {
		this.adviceReceiver = adviceReceiver;
	}
	public Courseware getCourseware() {
		return courseware;
	}
	public void setCourseware(Courseware courseware) {
		this.courseware = courseware;
	}
	public String getAdviceState() {
		return adviceState;
	}
	public void setAdviceState(String adviceState) {
		this.adviceState = adviceState;
	}
	
}
