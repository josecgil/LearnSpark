import static spark.Spark.*;
import controllers.DefaultController;
import controllers.JobsController;
import freemarker.template.Configuration;
import spark.template.freemarker.FreeMarkerEngine;

public class App {
	private static final String RESOURCES_PATH = "/resources";

	public static void main(String[] args) {
        FreeMarkerEngine freeMarkerEngine = createTemplateEngine();

		staticFileLocation(RESOURCES_PATH);
		
		DefaultController.init();
		JobsController.init(freeMarkerEngine);
	}

	private static FreeMarkerEngine createTemplateEngine() {
		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, RESOURCES_PATH);
		freeMarkerEngine.setConfiguration(configuration);
		return freeMarkerEngine;
	}
}