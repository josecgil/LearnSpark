import static spark.Spark.*;

public class App {

	public static void main(String[] args) {
        staticFileLocation("/resources");
        get("/onlytoruntheserver", (request, response) -> "?");
    }

}
