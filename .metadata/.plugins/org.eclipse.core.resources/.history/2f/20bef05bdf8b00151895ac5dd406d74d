package controllers;
import static spark.Spark.*;

public class DefaultController {
	public static void init() {
		Index();	
	}

	private static void Index() {
		get("/", (request, response) -> {
			response.status(301);
			response.redirect("/jobs");
			return "Redirecting to /jobs ...";
		});
	}

}
