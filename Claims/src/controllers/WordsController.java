package controllers;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.HashMap;

import adapters.WordsRepository;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

public class WordsController {
	
	
	public WordsController (FreeMarkerEngine freeMarkerEngine) {
		get("/words", (request, response) ->{
			WordsRepository wordsRepository=new WordsRepository();
			ArrayList<String> randomWords=wordsRepository.retrieveRandom(3);
			return new ModelAndView(createParam("randomWords", randomWords), "/views/words/index.ftl");
		}, freeMarkerEngine);
	}

	private HashMap<String, Object> createParam(String paramName, Object object) {
		HashMap<String, Object> params=new HashMap<String, Object>();
		params.put(paramName, object);
		return params;
	}
	
}
