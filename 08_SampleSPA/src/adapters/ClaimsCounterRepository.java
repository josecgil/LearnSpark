package adapters;

public class ClaimsCounterRepository {
	private static int claimsCounter=0;
	
	public void increment() {
		claimsCounter++;
	}

	public int get() {
		return claimsCounter;
	}

}
