package controllers;
import static spark.Spark.get;
import java.util.HashMap;
import java.util.Map;

import adapters.ClaimsCounterRepository;
import adapters.ClaimsRepository;
import model.ClaimsResult;
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
	
	private ClaimsResult generateRandomClaimResults(int numberOfClaims) {
		ClaimsResult claimResult=new ClaimsResult();
        claimResult.randomClaims=claimsRepository.findAll().selectRandom(numberOfClaims);
		claimsCounterRepository.increment();
		claimResult.count=claimsCounterRepository.get();
		return claimResult;		
	}
	
	private void index() {
		get("/claims", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            ClaimsResult claimResults=generateRandomClaimResults(3);
            attributes.put("numberOfClaimsSelected", claimResults.count);
            attributes.put("randomClaims", claimResults.randomClaims);
            return new ModelAndView(attributes, "views/claims/index.ftl");
        }, templateEngine);
	}

	private void select() {
		get("/claims/select/:count", "application/json", (request, response) -> {
			String countParam = request.params(":count");
			int count=Integer.parseInt(countParam);
            ClaimsResult claimsResult=generateRandomClaimResults(count);
			return claimsResult.randomClaims;
        }, jsonTransformer);
	}

	private void count() {
		get("/claims/count", "application/json", (request, response) -> {
			return claimsCounterRepository.get();
        }, jsonTransformer);
	}

	
}
