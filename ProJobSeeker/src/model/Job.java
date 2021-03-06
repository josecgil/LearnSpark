package model;

import java.text.SimpleDateFormat;

import org.joda.time.*;

public class Job {
	private static int _lastId=0;
	
	public Job() {
		_lastId++;
		id=_lastId;
		dateTime=new DateTime();
	}
	
	private int id;
	private String title;
	private String company;
	private String location;
	private String description;
	
	private String firstLetterToUpperCase(String str) {
		return str.substring(0,1).toUpperCase()+str.substring(1);
	}
	
	public String getShortDate() {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MMM dd");
		String dateAsString=simpleDateFormat.format(this.dateTime.toDate());
		return firstLetterToUpperCase(dateAsString);
	}

	private static final int DAYS_TO_BE_NEW = 15;

	public boolean isNew() {
		DateTime now=new DateTime();
		Days daysBetweenDateAndNow= Days.daysBetween(dateTime, now);
		int days=daysBetweenDateAndNow.getDays();
		return days<=DAYS_TO_BE_NEW;
	}

	
	private DateTime dateTime;

	private String categoryName;
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getCategory() {
		return categoryName;
	}
	
	public void setCategoryName(String category) {
		this.categoryName = category;
	}

	public void setId(int id) {
		this.id=id;
	}

	public void setCategory(String category) {
		this.categoryName=category;
		
	}

}
