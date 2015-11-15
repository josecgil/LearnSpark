package models;

import java.util.ArrayList;
import java.util.Collections;

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
	
	public void addJob(Job randomJob) {
		for(Category category:categories)
		{
			if (randomJob.has(category)) {
				category.add(randomJob);
				break;
			}
		}
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

}
