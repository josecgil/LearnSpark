import static spark.Spark.*;

import java.util.*;

import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;

public class App {
	
	/*
	 	<dependency>
    			<groupId>com.sparkjava</groupId>
    			<artifactId>spark-template-freemarker</artifactId>
    			<version>2.3</version>
		</dependency>
	 */

	public static void main(String[] args) {
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(App.class, "/resources/templates");
		freeMarkerEngine.setConfiguration(configuration);
		get("/hello", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Hello World!");

            // The hello.ftl file is located in directory:
            // src/test/resources/spark/template/freemarker
            return new ModelAndView(attributes, "hello.ftl");
        }, freeMarkerEngine);	}
}
