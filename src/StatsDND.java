
public class StatsDND  {
	
	
	public StatsDND(){
		
	}
	public static void main(String[] args) {      
		Characters test1 = new Characters();
		

		test1.addChar("testname", 100, 10);
		
		System.out.print(test1.listStats(0));
		System.out.println("     ");
		System.out.println("d20 value: " + dice.roll(20));
		System.out.println("     ");
		System.out.println("d20 value: " + dice.roll(2));
		System.out.println("     ");
		System.out.println("d20 value: " + dice.roll(10));
		System.out.println("     ");
		System.out.println("d20 value: " + dice.roll(6));
		
	
		
	}


}
	