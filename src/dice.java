
public class dice {
	//
	private int dNumSides;
	private int dNum;

	
	public dice(int numSides, int numD) {
		 numSides = dNumSides;
		 numD = dNum;
		
		//work in progress
	}
	
	public int roll(int rollNum){
		
		return (int)(Math.random() * (rollNum + 1) );
		
	}
	
}
