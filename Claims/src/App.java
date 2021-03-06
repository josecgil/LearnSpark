import static spark.Spark.*;

import controllers.WordsController;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;


public class App {

	private static final String RESOURCES_PATH = "/resources";

	public static void main(String[] args) {
		staticFileLocation(RESOURCES_PATH);
		
		FreeMarkerEngine freeMarkerEngine=createTemplateEngine();
		
		get("/", (request, response) ->{
			response.redirect("/words", 301);
			return "Redirecting to /words...";
		});
		
		WordsController wordsController=new WordsController(freeMarkerEngine);
		
	}
	
	private static FreeMarkerEngine createTemplateEngine() {
		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, RESOURCES_PATH);
		freeMarkerEngine.setConfiguration(configuration);
		return freeMarkerEngine;
	}

	

}
