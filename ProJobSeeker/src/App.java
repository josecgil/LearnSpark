import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import controller.JobsController;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class App {

	public static void main(String[] args) {
        
		staticFileLocation("/resources");
        
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, "/resources");
		freeMarkerEngine.setConfiguration(configuration);

		JobsController jobController=new JobsController(freeMarkerEngine);

	}
}
