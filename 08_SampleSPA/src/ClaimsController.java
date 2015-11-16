

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.TemplateEngine;

public class ClaimsController {
	
	private JsonTransformer jsonTransformer;
	private TemplateEngine templateEngine;
	
	private static ClaimsRepository claimsRepository=new ClaimsRepository();



	public ClaimsController(TemplateEngine templateEngine, JsonTransformer jsonTransformer) {
		this.templateEngine=templateEngine;
		this.jsonTransformer=jsonTransformer;
        index();
        select();
        count();
	}

	private void index() {
		get("/claims", (request, response) -> {
            return new ModelAndView(null, "views/claims/index.ftl");
        }, templateEngine);
	}

	private void select() {
		get("/claims/select/:count", "application/json", (request, response) -> {
			String countParam = request.params(":count");
			int count=Integer.parseInt(countParam);
			return claimsRepository.selectRandom(count);
        }, jsonTransformer);
	}

	private void count() {
		get("/claims/count", "application/json", (request, response) -> {
			return claimsRepository.numberOfRandomSelections();
        }, jsonTransformer);
	}

	
}
