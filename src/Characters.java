import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Characters {
	

	private String charName = " ";
	private int HealthNum = 0;
	private int ManaNum = 0;
	public ArrayList<String> CharList = new ArrayList<String>(5);
	public ArrayList<Integer> HealthList = new ArrayList<Integer>(5);
	private int[] ManaList = new int[5];
	public ArrayList<Integer> StrengthList = new ArrayList<Integer>(5);
	public char[] listStats;
	private int arrNum = 1;
	public int ListNum = 0;
	
	
	public Characters(){
		HealthList.add(0, 0);
		HealthList.add(1, 0);
		HealthList.add(2, 0);
		HealthList.add(3, 0);
		HealthList.add(4, 0);
		CharList.add(0, null);
		CharList.add(1, null);
		CharList.add(2, null);
		CharList.add(3, null);
		CharList.add(4, null);
		StrengthList.add(0, 1);
		StrengthList.add(1, 1);
		StrengthList.add(2, 1);
		StrengthList.add(3, 1);
		StrengthList.add(4, 1);
		
		
		
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