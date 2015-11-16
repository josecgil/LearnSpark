package models;

import java.util.ArrayList;
import java.util.Collections;

import models.Job;

public class CategoryCollection {
	public static final Category PROGRAMMING = new Category("Programming");
	public static final Category DESIGN = new Category("Design");
	public static final Category EXECUTIVE = new Category("Executive");
	public static final Category OTHER = new Category("Other");
	
	private ArrayList<Category> categories=new ArrayList<Category>();
	
	public CategoryCollection() {
		categories.add(PROGRAMMING);
		categories.add(DESIGN);
		categories.add(EXECUTIVE);
		categories.add(OTHER);
	}
	
	public void addJob(Job job) {
		for(Category category:categories)
		{
			if (job.has(category)) {
				category.add(job);
				return;
			}
		}
		OTHER.add(job);
	}
	
	public ArrayList<Category> toList() {
		return categories;
	}

	public void sortJobs() {
		Collections.sort(categories);
		for(Category category:categories)
		{
			category.sortJobs();
		}
		
	}

	public Job findJobById(int id) {
		for(Category category:categories)
		{
			Job job=category.findJobById(id);
			if (job!=null) return job;
		}
		return null;
	}

}
