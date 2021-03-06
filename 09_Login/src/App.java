import static spark.Spark.*;

import java.util.HashMap;

import controllers.UsersController;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.TemplateEngine;
import spark.template.freemarker.FreeMarkerEngine;

public class App {

	private static final String RESOURCES_PATH = "/resources";

	public static void main(String[] args) {
		
		/*
		/				<-- Main Content
		/private 		<-- Private content
		/users/login		
		/users/logout
		*/
		
        TemplateEngine templateEngine = createTemplateEngine(RESOURCES_PATH);
        staticFileLocation(RESOURCES_PATH);
        
        before("private*", (request, response) -> {
            boolean authenticated = false;
            // ... check if authenticated
            if (!authenticated) {
                response.redirect("/users/login", 301);
            }
        });

		get("/", (request, response) -> {
            return new ModelAndView(null, "views/index.ftl");
        }, templateEngine);

		get("/private", (request, response) -> {
            return new ModelAndView(null, "views/private.ftl");
        }, templateEngine);
        
		UsersController usersController=new UsersController(templateEngine);
		
		
		
	}
	
	private static FreeMarkerEngine createTemplateEngine(String templatePath) {
		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, templatePath);
		freeMarkerEngine.setConfiguration(configuration);
		return freeMarkerEngine;
	}

	
}
