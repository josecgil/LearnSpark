package controllers;
import spark.TemplateEngine;
import static spark.Spark.*;

import infrastructure.JobRepository;
import models.CategoryCollection;
import models.Job;

public class JobsController extends Controller {
	private final static String PATH_TO_VIEW = "views/jobs/";
	
	private static JobRepository jobRepository=new JobRepository();

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
			return renderView("create.ftl");		
        }, getTemplateEngine());
	}

	private void detail() {
		get("/jobs/:id", (request, response) -> {
			int jobId=Integer.parseInt(request.params(":id"));
			Job job=jobRepository.findById(jobId);
			return renderView("detail.ftl", "job", job);		
        }, getTemplateEngine());
	}
	


	
}
