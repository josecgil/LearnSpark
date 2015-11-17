package controller;

import model.Category;
import model.Job;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;

import static spark.Spark.get;

public class JobsController {

    private HashMap<String, ArrayList<Job>> jobsGroupedByCategory;

    public JobsController(FreeMarkerEngine freeMarkerEngine) {
        get("/jobs", (request, response) -> {
            HashMap<String, Object> attributes = new HashMap<>();

            setupJobs();
            attributes.put("jobsGroupedByCategory", jobsGroupedByCategory);

            return new ModelAndView(attributes, "views/jobs/index.ftl");
        }, freeMarkerEngine);
    }

    private void setupJobs() {
        ArrayList<Job> jobs = new ArrayList<Job>();

        Job job;
        for (int i = 0; i < 5; i++) {
            job = new Job();
            job.setId(0);
            job.setTitle("Job"+i);
            job.setCompany("Company"+i);
            job.setLocation("Location"+i);
            if (i % 2 == 0) {
                job.setCategory(Category.CATEGORIES[0]);
            } else {
                job.setCategory(Category.CATEGORIES[1]);
            }
            jobs.add(job);

            addJobToCategory(job);
        }
    }

    private void addJobToCategory(Job job) {
        if (jobsGroupedByCategory == null) {
            jobsGroupedByCategory = new HashMap<>();
        }

        ArrayList<Job> jobsByCategory = jobsGroupedByCategory.get(job.getCategory());
        if (jobsByCategory == null) {
            jobsByCategory = new ArrayList<>();
        }

        jobsByCategory.add(job);
        jobsGroupedByCategory.put(job.getCategory(), jobsByCategory);
    }
}
