

public class Characters {
	
	private String charName = " ";
	private int HealthNum = 0;
	private int ManaNum = 0;
	private String[] CharList = new String [5];
	private int[] HealthList = new int [5];
	private int[] ManaList = new int[5];
	public char[] listStats;
	
	
	public Characters(){
		String name = charName;
		int health = HealthNum;
		int mana = ManaNum;
		
	}
	
	public void addChar(String name, int health, int mana){
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
		else{
			arrNum = 0;
			ListNum = 0;
		}
		
	}
	public String listStats(int arrayNum){
		return CharList[arrayNum] + " " + HealthList[arrayNum] + " "  +  ManaList[arrayNum];
	}
	
	public void WrittingtoFile() {
		
		
	}

}
