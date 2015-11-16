package infrastructure;

import models.Job;
import models.Category;
import models.CategoryCollection;

public class JobRepository {

	private static CategoryCollection categories=RandomJobCreator.create(20);
	
	private JobRepository() {
		
	}
	
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

	private static JobRepository _JobRepository=null;
	public static JobRepository getInstance() {
		if (_JobRepository==null) {
			_JobRepository=new JobRepository();
		}
		return _JobRepository;
	}

	public Category findCategoryByName(String name) {
		return categories.findCategoryByName(name);
	}

}
