import static spark.Spark.*;

public class App {

    public static void main(String args[]) {
        get("/hello", "application/json", (request, response) -> {
            Client client = new Client("Connor, Sara");
			return client;
        }, new JsonTransformer());
    }

}
