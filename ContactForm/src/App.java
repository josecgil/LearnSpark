import static spark.Spark.*;

import controllers.ContactsController;
import freemarker.template.Configuration;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

import freemarker.template.Configuration;


public class App {

	public static void main(String[] args) {
		staticFileLocation("/resources");
		
		FreeMarkerEngine freeMarkerEngine = initFreeMarkerEngine();

		ContactsController contactsController=new ContactsController(freeMarkerEngine);

	}

	private static FreeMarkerEngine initFreeMarkerEngine() {
		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, "/resources");
		freeMarkerEngine.setConfiguration(configuration);
		return freeMarkerEngine;
	}

}
