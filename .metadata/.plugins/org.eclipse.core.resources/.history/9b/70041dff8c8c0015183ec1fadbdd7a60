

import static spark.Spark.get;

import java.util.ArrayList;

public class ClaimsController {

	public ClaimsController(JsonTransformer jsonTransformer) {
        get("/claims/create", "application/json", (request, response) -> {
            ArrayList<String> claims = new ArrayList<String>();
            claims.add("BALANCED");
            claims.add("SYNERGIES");
            claims.add("MODULAR");
			return claims;
        }, jsonTransformer);

	}

}
