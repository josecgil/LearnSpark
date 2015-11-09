import static spark.Spark.*;

public class App {
	/*
	 * <dependency> 
	 * 		<groupId>com.sparkjava</groupId>
	 * 		<artifactId>spark-core</artifactId>
	 * 		<version>2.3</version>
	 * </dependency>
	 */
	public static void main(String[] args) {
		get("/hello", (request, response) -> "Hello World");
	}
}
