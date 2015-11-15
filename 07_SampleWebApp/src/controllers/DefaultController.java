package controllers;
import static spark.Spark.*;

public class DefaultController extends Controller {
	private final static String PATH_TO_VIEW = "views/";

	public DefaultController() {
		super(null, PATH_TO_VIEW);
		index();	
	}

	private void index() {
		get("/", (request, response) -> {
			response.status(301);
			response.redirect("/jobs");
			return "Redirecting to /jobs ...";
		});
	}

}
