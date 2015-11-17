import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class App {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		List<Client> clients=new ArrayList<Client>();
		
		Client carlos = new Client();
		carlos.setName("Carlos");
		carlos.setSurName("Gil");
		carlos.setBirthDate(formatter.parse("26/03/1974"));
		clients.add(carlos);
		
		Client jose = new Client();
		jose.setName("Jose");
		jose.setSurName("Huerta");
		jose.setBirthDate(formatter.parse("26/03/1970"));
		clients.add(jose);
		
		Collections.sort(clients);
		

	}

}
