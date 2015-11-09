import static spark.Spark.*;

public class App {

    public static void main(String args[]) {
        get("/hello", "application/json", (request, response) -> {
            return new Client("Connor, Sara");
        }, new JsonTransformer());
    }

}
