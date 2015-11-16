

import static spark.Spark.get;

import java.util.ArrayList;

public class ClaimsController {
	
	private JsonTransformer jsonTransformer;
	
	public ClaimsController(JsonTransformer jsonTransformer) {
		this.jsonTransformer=jsonTransformer;
        create();
        count();
	}

	private void create() {
		get("/claims/create", "application/json", (request, response) -> {
            ArrayList<String> claims = new ArrayList<String>();
            claims.add("BALANCED");
            claims.add("SYNERGIES");
            claims.add("MODULAR");
			return claims;
        }, jsonTransformer);
	}

	private void count() {
		get("/claims/count", "application/json", (request, response) -> {
			return 6;
        }, jsonTransformer);
	}

	
}
