import static spark.Spark.*;

public class App {

	public static void main(String[] args) {
        staticFileLocation("/resources");
        JsonTransformer json2Transformer = new JsonTransformer();
		ClaimsController claimsController=new ClaimsController(json2Transformer);
	}

}
