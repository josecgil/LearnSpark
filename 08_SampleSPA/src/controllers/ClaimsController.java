package controllers;
import static spark.Spark.get;
import java.util.HashMap;
import java.util.Map;

import adapters.ClaimsCounterRepository;
import adapters.ClaimsRepository;
import spark.ModelAndView;
import spark.TemplateEngine;

public class ClaimsController {
	
	private JsonTransformer jsonTransformer;
	private TemplateEngine templateEngine;
	
	private static ClaimsRepository claimsRepository=new ClaimsRepository();
	private static ClaimsCounterRepository claimsCounterRepository=new ClaimsCounterRepository();

	public ClaimsController(TemplateEngine templateEngine, JsonTransformer jsonTransformer) {
		this.templateEngine=templateEngine;
		this.jsonTransformer=jsonTransformer;
        index();
        select();
        count();
	}

	private void index() {
		get("/claims", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
			claimsCounterRepository.increment();
            attributes.put("numberOfClaimsSelected", claimsCounterRepository.get());
            attributes.put("randomClaims", claimsRepository.findAll().selectRandom(3));
            return new ModelAndView(attributes, "views/claims/index.ftl");
        }, templateEngine);
	}

	private void select() {
		get("/claims/select/:count", "application/json", (request, response) -> {
			String countParam = request.params(":count");
			int count=Integer.parseInt(countParam);
			claimsCounterRepository.increment();
			return claimsRepository.findAll().selectRandom(count);
        }, jsonTransformer);
	}

	private void count() {
		get("/claims/count", "application/json", (request, response) -> {
			return claimsCounterRepository.get();
        }, jsonTransformer);
	}

	
}
