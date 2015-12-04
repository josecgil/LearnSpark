package controllers;

import static spark.Spark.*;

import java.util.HashMap;

import adapters.ContactRepository;
import models.Contact;
import spark.Request;
import spark.template.freemarker.FreeMarkerEngine;

public class ContactsController {

	private ContactRepository contactRepository = new ContactRepository();

	public ContactsController(FreeMarkerEngine freeMarkerEngine) {
		get("/contacts/create", (request, response)-> {
			return modelAndView(null, "contact_form.ftl");
		}, freeMarkerEngine);		
		
		post("/contacts/create", (request, response)-> {
			
			String name=request.queryParams("name");
			String email=request.queryParams("email");
			String message=request.queryParams("message");

			Contact newContact=contactRepository.save(new Contact(name, email, message));

			response.redirect("/contacts/thankyou/"+newContact.getId(), 301);
			return "";
		});		

		get("/contacts/thankyou/:id", (request, response)-> {
			String paramId=request.params("id");
			int id=Integer.parseInt(paramId);
			Contact contact=contactRepository.findById(id);
			HashMap<String, Contact> model=new HashMap<String, Contact>();
			model.put("contact", contact);
			return modelAndView(model, "thank_you.ftl");
		}, freeMarkerEngine);		

	}

}
