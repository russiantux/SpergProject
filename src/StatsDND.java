
public class StatsDND  {
	
	
	public StatsDND(){
		
	}
	public static void main(String[] args) {      
		Characters test1 = new Characters();
		
		
		test1.addChar("testname", 100, 10);
		test1.addChar("test2", 50, 30);
		test1.addChar("Name test Three to see how far char can go", 1, 100);
		
		System.out.print(test1.listStats(0));
		System.out.println("     ");
		System.out.println("d20 value: " + dice.roll(20));
		System.out.println("     ");
		System.out.println("d2 value: " + dice.roll(2));
		System.out.println(test1.listStats(1));
		System.out.println("     ");
		System.out.println("d10 value: " + dice.roll(10));
		System.out.println(test1.listStats(2));
		System.out.println("     ");
		System.out.println("d6 value: " + dice.roll(6));
		
	
		
	}


}
	