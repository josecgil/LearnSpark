package models;

import java.util.ArrayList;
import java.util.Collections;

public class JobCollection {
	
	private ArrayList<Job> jobs=new ArrayList<Job>();
	
	public JobCollection() {
		
	}
	
	public void add(Job job) {
		jobs.add(job);
	}
	
	public JobCollection getJobsInCategory(String category) {
		JobCollection jobsInCategory=new JobCollection();
		for(Job job: jobs) {
			if (job.getCategoryName().equalsIgnoreCase(category)) {
				jobsInCategory.add(job);
			}
		}
		return jobsInCategory;
	}
	
	public void Sort() {
		Collections.sort(jobs);
	}
	
	public ArrayList<Job> toList() {
		return jobs;
	}

}
