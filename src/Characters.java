

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
		 ListNum++;
		 
			
		
		
	}
	public String listStats(int arrayNum){
		return "Name: " + CharList[arrayNum] + "  |  HP: " + HealthList[arrayNum] + "  |  Mana: "  +  ManaList[arrayNum];
		
	}
	
	public int getHealth(int arrNum){
		return HealthList[arrNum];
	}
	
	public String getName(int arNum){
		return CharList[arNum];
	}
	
	public void WrittingtoFile() {
		
		
	}

}