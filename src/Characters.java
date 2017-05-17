public class dice{
	
	private int dNum = 0 ;
	private int CurNum = 0;

	
	public dice() {
		int DiceNum = dNum;
		
		//work in progress
	}
	
	private int roll(int rollNum){
		
		return (int)(Math.random() * (rollNum + 1) );
		
	}
	 
	
	
	
	
}


public class Characters {
	
	private String charName = " ";
	private int HealthNum = 0;
	private int ManaNum = 0;
	private String[] CharList = new String [5];
	private int[] HealthList = new int [5];
	private int[] ManaList = new int[5];
	
	
	public Characters(){
		String name = charName;
		int health = HealthNum;
		int mana = ManaNum;
		
	}
	
	private void addChar(String name, int health, int mana){
		int arrNum = 1;
		int ListNum = 0;
		
		if(arrNum > 6)
		{
			CharList[ListNum] = name;
			HealthList[ListNum] = health;
			ManaList[ListNum] = mana;
			ListNum++;
			arrNum++;
			
		}
		
	}
	private String listStats(int arrayNum){
		return CharList[arrayNum] + HealthList[arrayNum] + ManaList[arrayNum];
	}
	
	public void WrittingtoFile() {
		
		
	}

}
