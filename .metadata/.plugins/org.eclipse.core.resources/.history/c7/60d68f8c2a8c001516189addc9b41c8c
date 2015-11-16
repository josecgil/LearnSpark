package infrastructure;

import models.Job;
import models.CategoryCollection;

public class JobRepository {

	private static CategoryCollection categories=RandomJobCreator.create(20);
	
	public CategoryCollection findAll() {
		
		return categories;
	}

	public Job findById(int id) {
		return categories.findJobById(id);
	}

	public void save(Job newJob) {
		categories.addJob(newJob);
	}

	public CategoryCollection findAllCategories() {
		return new CategoryCollection();
	}

}
