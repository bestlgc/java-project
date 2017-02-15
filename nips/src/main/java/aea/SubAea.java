package aea;

import java.util.List;

public class SubAea {
	private String title;
	private String text;
	List<Attendee> listAttendees;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Attendee> getListAttendees() {
		return listAttendees;
	}
	public void setListAttendees(List<Attendee> listAttendees) {
		this.listAttendees = listAttendees;
	}
	
	
}
