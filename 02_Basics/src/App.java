import static spark.Spark.*;

public class App {

	public static void main(String[] args) {

		//port(5678); //<- Uncomment this if you want spark to listen on a port
		// different than 4567

		get("/hello", (request, response) -> "Hello World!");
		
		//You can check post requests with "Postman App"
		post("/hello", (request, response) -> "Hello World: " + request.body());

		//https://httpstatuses.com/401
		//401 UNAUTHORIZED
		get("/private", (request, response) -> {
			response.status(401);
			return "Go Away!!!";
		});

		get("/users/:name", (request, response) -> "Selected user: " + request.params(":name"));

		get("/news/:section", (request, response) -> {
			response.type("text/xml");
			return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><news>" + request.params("section") + "</news>";
		});

		//https://httpstatuses.com/403
		//403 FORBIDDEN
		get("/protected", (request, response) -> {
			//Halting: to immediately stop a request			
			halt(403, "I don't think so!!!");
			return null;
		});

		
		//https://httpstatuses.com/301
		//301 MOVED PERMANENTLY
		get("/redirect", (request, response) -> {
			response.redirect("/news/world");
			return null;
		});

		get("/", (request, response) -> "root");
	}
}
