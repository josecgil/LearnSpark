package adapters;

import model.ClaimCollection;

public class ClaimsRepository {

	private ClaimCollection claims=new ClaimCollection();

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

	public ClaimCollection findAll() {
		return claims;
	}


}
