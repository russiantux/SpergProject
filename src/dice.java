
public class dice {
	//
	private int dNumSides;
	private int dNum;

	
	public dice(int numSides, int numD) {
		numSides = dNumSides;
		numD = dNum;
		}
	public dice(int numSides){
		numSides = dNumsides;
	}
	
	dice d2 = new dice(2);
	
	private int roll(int rollNum){
		
		return (int)(Math.random() * (rollNum + 1) );
		
	}
	
}
