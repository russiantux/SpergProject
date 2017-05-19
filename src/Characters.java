

public class Characters {
	
	private String charName = " ";
	private int HealthNum = 0;
	private int ManaNum = 0;
	public String[] CharList = new String [5];
	private int[] HealthList = new int [5];
	private int[] ManaList = new int[5];
	public char[] listStats;
	private int arrNum = 1;
	private int ListNum = 0;
	
	public Characters(){
		
	}
	
	public void addChar(String name, int health, int mana){
	
		
		 CharList[ListNum] = name;
		 HealthList[ListNum] = health;
		 ManaList[ListNum] = mana;
			
		
		
	}
	public String listStats(int arrayNum){
		return CharList[arrayNum] + " " + HealthList[arrayNum] + " "  +  ManaList[arrayNum];
		
	}
	
	public void WrittingtoFile() {
		
		
	}

}