
public class dice {
	//
	private int dNumSides;
	private int dNum;

	
	public dice(int numSides, int numD) {
		//Lets the number of sides on dice and the number of dice vary
		numSides = dNumSides;
		numD = dNum;
		}
	public dice(int numSides){
		numSides = dNumSides;
	}
	
	dice d2 = new dice(2);
	
	public int roll(int rollNum){
		
		return (int)(Math.random() * (rollNum + 1) );
		
	}
	
}
