import static spark.Spark.*;
public class App {

	public static void main(String[] args) {
		//try http://localhost:4567/css/bootstrap.css 	
        staticFileLocation("/resources");
        get("/hello", (request, response) -> "Hello World!");
	}
}
