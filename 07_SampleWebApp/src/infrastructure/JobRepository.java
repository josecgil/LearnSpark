package infrastructure;

import models.CategoryCollection;

public class JobRepository {

	private static CategoryCollection categories=RandomJobCreator.create(20);
	
	public CategoryCollection findAll() {
		
		return categories;
	}

}
