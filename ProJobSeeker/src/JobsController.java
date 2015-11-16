import static spark.Spark.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class JobsController {
	
	public JobsController(FreeMarkerEngine freeMarkerEngine) {
		get("/jobs", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            ArrayList<Job> jobs=new ArrayList<Job>();
            Job aJob=new Job();
            aJob.setCategoryName("Programming");
            aJob.setCompany("Company");
            aJob.setDescription("Description");
            aJob.setLocation("location");
            aJob.setTitle("title");
            jobs.add(aJob);
            Job aJob2=new Job();
            aJob2.setCategoryName("Programming");
            aJob2.setCompany("Company2");
            aJob2.setDescription("Description2");
            aJob2.setLocation("location2");
            aJob2.setTitle("title2");
            jobs.add(aJob2);
            
            attributes.put("jobs", jobs);

            return new ModelAndView(attributes, "views/jobs/index.ftl");
        }, freeMarkerEngine);		
	}

}