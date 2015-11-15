package models;

import java.util.ArrayList;
import java.util.Collections;

public class Category implements Comparable<Category> {

	public Category(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}
	
	public Job getLatestJob() {
		Collections.sort(jobs);
		return jobs.get(0);
	}

	private ArrayList<Job> jobs=new ArrayList<Job>();
	
	public void add(Job job) {
		jobs.add(job);
	}

	public ArrayList<Job> getJobs() {
		return jobs;
	}

	public void sortJobs() {
		Collections.sort(jobs);
	}

	@Override
	public int compareTo(Category otherCategory) {
		return Integer.compare(otherCategory.size(), size());
	}

	public int size() {
		return jobs.size();
	}
	
}
