package adapters;
import java.util.ArrayList;
import java.util.Random;

public class ClaimsRepository {

	private ArrayList<String> claims=new ArrayList<String>();
	private Random random=new Random();

	public ClaimsRepository() {
		claims.add("Heuristic");
		claims.add("Balanced");
		claims.add("Focused");
		claims.add("Collaborative");
		claims.add("Cutting-Edge");
		claims.add("Quality-Focused");
		claims.add("Full-Range");
		claims.add("Flexible");
		claims.add("Dynamic");
		claims.add("Interactive");
		claims.add("Epic");
		claims.add("Efficient");
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
