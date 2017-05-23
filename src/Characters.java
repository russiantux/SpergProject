

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
	
		if(ListNum == 6){
			System.out.println("error: CharList maxed out");
		}
		else
		{
			CharList[ListNum] = name;
			 HealthList[ListNum] = health;
			 ManaList[ListNum] = mana;
			 ListNum++;
			
		}
	}
	
	public String listStats(int arrayNum){
		return "Name: " + CharList[arrayNum] + "  |  HP: " + HealthList[arrayNum] + "  |  Mana: "  +  ManaList[arrayNum];
	}
	
	public int getHealth(int arrNum){
		return HealthList[arrNum];
	}
	
	public String getName(int arrNum){
		return CharList[arrNum];
	}
	
	public int getMana(int arrNum){
		return ManaList[arrNum];
	}
	
	public void WrittingtoFile() {
		
		
	}

}