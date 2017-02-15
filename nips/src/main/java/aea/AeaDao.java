package aea;

import java.util.List;

public class AeaDao {
	
	private String title;
	private String category;
	private String date;
	private String time;
	private String location;
	private String hostedBy;
	private String felClassfiation;
	private String nextLink;
	private String chair;
	private List<String> jelClf;
	
	public List<String> getJelClf() {
		return jelClf;
	}
	public void setJelClf(List<String> jelClf) {
		this.jelClf = jelClf;
	}
	private List<SubAea> subAeas;
	
	public List<SubAea> getSubAeas() {
		return subAeas;
	}
	public void setSubAeas(List<SubAea> subAeas) {
		this.subAeas = subAeas;
	}
	public String getChair() {
		return chair;
	}
	public void setChair(String chair) {
		this.chair = chair;
	}
	public String getNextLink() {
		return nextLink;
	}
	public void setNextLink(String nextLink) {
		this.nextLink = nextLink;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getHostedBy() {
		return hostedBy;
	}
	public void setHostedBy(String hostedBy) {
		this.hostedBy = hostedBy;
	}
	public String getFelClassfiation() {
		return felClassfiation;
	}
	public void setFelClassfiation(String felClassfiation) {
		this.felClassfiation = felClassfiation;
	}
	
}
