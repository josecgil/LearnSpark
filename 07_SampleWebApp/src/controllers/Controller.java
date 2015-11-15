package controllers;

import java.util.HashMap;

import spark.ModelAndView;
import spark.TemplateEngine;

public class Controller {

	public Controller(TemplateEngine templateEngine, String pathToView) {
		this.templateEngine=templateEngine;
		this.pathToView=pathToView;
	}

	private TemplateEngine templateEngine;
	private String pathToView;

	protected ModelAndView renderView(String viewName, String modelName, Object model) {
		HashMap<String, Object> root=new HashMap<String, Object>(); 
		root.put(modelName, model);
		return new ModelAndView(root, this.pathToView+viewName);
	}

	protected ModelAndView renderView(String viewName) {
		return renderView(viewName, null, null);
	}

	protected TemplateEngine getTemplateEngine() {
		return templateEngine;
	}

}