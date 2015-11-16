import static spark.Spark.*;

import freemarker.template.Configuration;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

public class App {

	private static final String RESOURCES_PATH = "/resources";

	public static void main(String[] args) {
        TemplateEngine templateEngine = createTemplateEngine();
        JsonTransformer json2Transformer = new JsonTransformer();

        staticFileLocation(RESOURCES_PATH);
        setDefaultRoute("/claims");

		ClaimsController claimsController=new ClaimsController(templateEngine, json2Transformer);
	}
	
	private static void setDefaultRoute(String defaultRoute) {
		get("/", (request, response) -> {
			response.status(301);
			response.redirect(defaultRoute);
			return "Redirecting to "+defaultRoute+" ...";
		});
	}


	private static FreeMarkerEngine createTemplateEngine() {
		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, RESOURCES_PATH);
		freeMarkerEngine.setConfiguration(configuration);
		return freeMarkerEngine;
	}

	
}
