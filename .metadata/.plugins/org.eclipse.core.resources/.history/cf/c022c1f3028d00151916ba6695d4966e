import java.util.ArrayList;
import java.util.Random;

public class ClaimsRepository {

	private ArrayList<String> claims=new ArrayList<String>();
	private Random random=new Random();

	public ClaimsRepository() {
		claims.add("Heuristic");
		claims.add("Balanced");
		claims.add("Focused");
		claims.add("COLLABORATIVE");
		claims.add("CUTTING-EDGE");
		claims.add("QUALITY-FOCUSED");
		claims.add("FULL-RANGE");
		claims.add("FLEXIBILITY");
		claims.add("DYNAMIC");
		claims.add("INTERACTIVE");
		claims.add("EPIC");
		claims.add("EFFICIENCY");
	}
	
	private int numberOfRandomSelections=0;
	
	public ArrayList<String> selectRandom(int count) {
		numberOfRandomSelections++;
		ArrayList<String> selectedClaims=new ArrayList<String>();
		int numberOfClaims = claims.size();
		while(selectedClaims.size()<3) {
			int index=random.nextInt(numberOfClaims);
			String claim=claims.get(index);
			if (!selectedClaims.contains(claim)) {
				selectedClaims.add(claim);
			}
		}
		return selectedClaims;
	}

	public int numberOfRandomSelections() {
		return numberOfRandomSelections;
	}

}
