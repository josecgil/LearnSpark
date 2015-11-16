package models;

import java.text.SimpleDateFormat;
import org.joda.time.DateTime;
import org.joda.time.Days;

public class Job implements Comparable<Job>{
	private static int _lastId=0;
	
	public Job() {
		_lastId++;
		id=_lastId;
		dateTime=new DateTime();
	}
	
	private int id;
	private String title;
	private DateTime dateTime;
	private String company;
	private String location;
	private String description;
	
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
	
	public DateTime getDateTime() {
		return dateTime;
	}
	
	private static final int DAYS_TO_BE_NEW = 15;

	public boolean isNew() {
		DateTime now=new DateTime();
		Days daysBetweenDateAndNow= Days.daysBetween(dateTime, now);
		int days=daysBetweenDateAndNow.getDays();
		return days<=DAYS_TO_BE_NEW;
	}
	
	public String getTimeFromNow() {
		DateTime now=new DateTime();
		Days daysBetweenDateAndNow= Days.daysBetween(dateTime, now);
		int days=daysBetweenDateAndNow.getDays();
		if (days==0) return "Today";
		int months=days/30;
		if (months==0) {
			if (days==1) return "about 1 day ago";
			return "about "+days+" days ago";
		}
		if (months==1) return "about 1 month ago";
		return "about "+months+" months ago";
	}
	
	private String firstLetterToUpperCase(String str) {
		return str.substring(0,1).toUpperCase()+str.substring(1);
	}
	
	public String getShortDate() {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MMM dd");
		String dateAsString=simpleDateFormat.format(this.dateTime.toDate());
		return firstLetterToUpperCase(dateAsString);
	}
	
	public void setDateTime(DateTime date) {
		this.dateTime = date;
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
	
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String category) {
		this.categoryName = category;
	}

	@Override
	public int compareTo(Job otherJob) {
	    return otherJob.getDateTime().compareTo(dateTime);
	}

	public boolean has(Category category) {
		return this.categoryName.equals(category.getName());
	}

	public boolean has(int id) {
		return this.id==id;
	}


}
