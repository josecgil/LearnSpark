package controllers;

import static spark.Spark.*;

import spark.template.freemarker.FreeMarkerEngine;

public class ContactsController {

	public ContactsController(FreeMarkerEngine freeMarkerEngine) {
		get("/contacts/create", (request, response)-> {
			return modelAndView(null, "contact_form.ftl");
		}, freeMarkerEngine);		
		
		post("/contacts/create", (request, response)-> {
			//Store contact
			
			response.redirect("/contacts/thankyou/", 301);
			return "";
		});		

	}
	
}
