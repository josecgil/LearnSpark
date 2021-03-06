package controllers;
import spark.TemplateEngine;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;

import infrastructure.JobRepository;
import models.Category;
import models.CategoryCollection;
import models.Job;

public class CategoriesController extends Controller {
	private final static String PATH_TO_VIEW = "views/categories/";
	
	private static JobRepository jobRepository=JobRepository.getInstance();

	public CategoriesController(TemplateEngine templateEngine) {
		super(templateEngine, PATH_TO_VIEW);
		detail();
	}

	private void detail() {
		get("/categories/:name", (request, response) -> {
			String name=request.params(":name");
			Category category=jobRepository.findCategoryByName(name);
			return renderView("detail.ftl", "category", category);		
        }, getTemplateEngine());
	}


		
}
