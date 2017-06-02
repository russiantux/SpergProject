import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Characters {
	

	private String charName = " ";
	private int HealthNum = 0;
	private int ManaNum = 0;
	public ArrayList<String> CharList = new ArrayList<String>();
	public ArrayList HealthList = new ArrayList();
	private int[] ManaList = new int[5];
	public ArrayList StrengthList = new ArrayList();
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
			 CharList.add(ListNum,name);
			 HealthList.add(ListNum,health);
			 StrengthList.add(ListNum,strength);
			 ListNum++;
			
		}
	}
	
	//public String listStats(int arrayNum){
		//return "Name: " + CharList[arrayNum] + "  |  HP: " + HealthList[arrayNum] + "  |  Mana: "  +  ManaList[arrayNum] + "  |  Strength: " + StrengthList[arrayNum];
	//}
	
	public int getHealth(int arrNum){
		return (int) HealthList.get(arrNum);
	}
	
	public String getName(int arrNum){
		return CharList.get(arrNum);
	}
	
	//public int getMana(int arrNum){
		//return ManaList[arrNum];
	//}
	
	public int getStrength(int arrNum){
		return (int) StrengthList.get(arrNum);
	}
	
	public void setHealth(int healthNum, int arrNum){
		HealthList.set(arrNum,healthNum);
		
	}
	//public void setMana(int manaNum, int arrNum){
		//ManaList[arrNum] = manaNum;
	//}
	public void setStrength(int StrengthNum, int arrNum){
		StrengthList.set(arrNum, StrengthNum);
	}
	
	public void attack(int arrNum)  {
		int five = 5;
		int strength = (int) StrengthList.get(arrNum);
		int health = (int) HealthList.get(arrNum);
		int attackNum = health - (strength * 5);
		
		//HealthList[arrNum] = (HealthList[arrNum] - ((StrengthList[arrNum]) *= 5));
		HealthList.set(arrNum, attackNum);
		
	}
	

}