package controllers;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;

import spark.ModelAndView;
import java.util.HashMap;

import infrastructure.JobRepository;
import models.CategoryCollection;
import models.Job;

public class JobsController {
	private static final String PATH_TO_VIEW = "views/jobs/";
	
	private static FreeMarkerEngine freeMarkerEngine;
	
	private static JobRepository jobRepository=new JobRepository();
	
	public static void init(FreeMarkerEngine freeMarkerEngine) {
		JobsController.freeMarkerEngine=freeMarkerEngine;
		Index();	
		Detail();
	}

	private static void Index() {
		get("/jobs", (request, response) -> {
			CategoryCollection categories=jobRepository.findAll();
			HashMap<String, Object> root=new HashMap<String, Object>(); 
			root.put("categories", categories);
            return new ModelAndView(root, PATH_TO_VIEW+"index.ftl");
        }, freeMarkerEngine);
	}

	private static void Detail() {
		get("/jobs/:id", (request, response) -> {
			int jobId=Integer.parseInt(request.params(":id"));
			Job job=jobRepository.findById(jobId);
			HashMap<String, Object> root=new HashMap<String, Object>(); 
			root.put("job", job);
            return new ModelAndView(root, PATH_TO_VIEW+"detail.ftl");
        }, freeMarkerEngine);
	}

	
}
