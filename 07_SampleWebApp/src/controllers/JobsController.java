package controllers;
import spark.TemplateEngine;
import static spark.Spark.*;

import java.util.ArrayList;
import java.util.HashMap;

import infrastructure.JobRepository;
import models.Category;
import models.CategoryCollection;
import models.Job;

public class JobsController extends Controller {
	private final static String PATH_TO_VIEW = "views/jobs/";
	
	private static JobRepository jobRepository=JobRepository.getInstance();

	public JobsController(TemplateEngine templateEngine) {
		super(templateEngine, PATH_TO_VIEW);
		//The order is important for routing purposes
		index();	
		create();
		detail();
	}

	private void index() {
		get("/jobs", (request, response) -> {
			CategoryCollection categories=jobRepository.findAll();
			return renderView("index.ftl", "categories", categories);
        }, getTemplateEngine());
	}


	private void create() {
		get("/jobs/create", (request, response) -> {
			CategoryCollection categories=jobRepository.findAllCategories();
			return renderView("create.ftl", "categories", categories);		
        }, getTemplateEngine());
		
		post("/jobs/create", (request, response) -> {
			Job newJob=new Job();
			newJob.setTitle(request.queryParams("title"));
			newJob.setDescription(request.queryParams("description"));
			newJob.setCategoryName(request.queryParams("category"));
			newJob.setCompany(request.queryParams("company"));
			newJob.setLocation(request.queryParams("location"));
			jobRepository.save(newJob);
			
			//Post/Redirect/Get Pattern
			response.status(301);
			response.redirect("/jobs/"+newJob.getId());
			return "";
        });
	}

	private void detail() {
		get("/jobs/:id", (request, response) -> {
			int jobId=Integer.parseInt(request.params(":id"));
			Job job=jobRepository.findById(jobId);
			return renderView("detail.ftl", "job", job);		
        }, getTemplateEngine());
	}
		
}
