package controllers;
import static spark.Spark.get;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.TemplateEngine;

public class UsersController {
	private TemplateEngine templateEngine;
	
	public UsersController(TemplateEngine templateEngine) {
		this.templateEngine=templateEngine;
		Login();
		Logout();
	}

	private void Login() {
		get("/users/login", (request, response) -> {
            return new ModelAndView(null, "views/users/login.ftl");
        }, templateEngine);

	}

	private void Logout() {
		get("/users/logout", (request, response) -> {
			response.redirect("/");
			return "Redirecting to home...";
        });
		
	}

}
