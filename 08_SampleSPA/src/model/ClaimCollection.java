package model;

import java.util.ArrayList;
import java.util.Random;

public class ClaimCollection {
	private ArrayList<String> claims=new ArrayList<String>();
	private Random random=new Random();

	public ArrayList<String> selectRandom(int count) {
		ArrayList<String> selectedClaims=new ArrayList<String>();
		int numberOfClaims = claims.size();
		while(selectedClaims.size()<count) {
			int index=random.nextInt(numberOfClaims);
			String claim=claims.get(index);
			if (!selectedClaims.contains(claim)) {
				selectedClaims.add(claim);
			}
		}
		return selectedClaims;
	}

	public void add(String claim) {
		claims.add(claim);		
	}

	
	
}
