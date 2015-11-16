import static spark.Spark.*;

import controllers.CategoriesController;
import controllers.DefaultController;
import controllers.JobsController;
import freemarker.template.Configuration;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

public class App {
	private static final String RESOURCES_PATH = "/resources";

	public static void main(String[] args) {
        TemplateEngine templateEngine = createTemplateEngine();

		staticFileLocation(RESOURCES_PATH);
		
		new DefaultController();
		new JobsController(templateEngine);
		new CategoriesController(templateEngine);
	}

	private static FreeMarkerEngine createTemplateEngine() {
		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, RESOURCES_PATH);
		freeMarkerEngine.setConfiguration(configuration);
		return freeMarkerEngine;
	}
}
