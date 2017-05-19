
public class dice {
	//
	private int dNumSides;
	private int dNum = 1;

	
	public dice(int numSides, int numD) {
		//Lets the number of sides on dice and the number of dice vary. Default is 1 die.
		numSides = dNumSides;
		numD = dNum;
		}
	public dice(int numSides){
		numSides = dNumSides;
	}
	
	//establishes subclasses of the dice class so that rolling a different sided die can be done easily.
	
	dice d2 = new dice(2);
	dice d4 = new dice(4);
	dice d6 = new dice(6);
	dice d10 = new dice(10);
	dice d20 = new dice(20);
	dice d100 = new dice(100);
	
	public int roll(int numSides){
		
		return (int)(Math.random() * (numSides + 1) );
		
	}
	
}
