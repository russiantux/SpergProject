import javax.swing.JOptionPane;

public class Characters {
	

	private String charName = " ";
	private int HealthNum = 0;
	private int ManaNum = 0;
	public String[] CharList = new String [5];
	private int[] HealthList = new int [5];
	private int[] ManaList = new int[5];
	private int[] StrengthList = new int[5];
	public char[] listStats;
	private int arrNum = 1;
	public int ListNum = 0;
	
	
	public Characters(){
		
	}
	
	public void addChar(String name, int health, int mana, int strength){
	
		if(ListNum == 5){
			
			
			
			System.out.println("error: CharList maxed out, reseting back to one");
			ListNum = 0;
			
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
		return "Name: " + CharList[arrayNum] + "  |  HP: " + HealthList[arrayNum] + "  |  Mana: "  +  ManaList[arrayNum] + "  |  Strength: " + StrengthList[arrayNum];
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
	
	public int getStrength(int arrNum){
		return StrengthList[arrNum];
	}
	
	public void setHealth(int healthNum, int arrNum){
		HealthList[arrNum] = healthNum;
	}
	public void setMana(int manaNum, int arrNum){
		ManaList[arrNum] = manaNum;
	}
	public void setStrength(int StrengthNum, int arrNum){
		StrengthList[arrNum] = StrengthNum;
	}
	
	public int attack(int arrNum)  {
		
		
		HealthList[arrNum] = (HealthList[arrNum] - ((StrengthList[arrNum]) *= 5));
		return HealthList[arrNum];
		
	}
	public void WrittingtoFile() {
		//
		
	}

}