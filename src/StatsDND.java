
public class StatsDND  {
	
	
	public StatsDND(){
		
	}
	public static void main(String[] args) {      
		Characters test1 = new Characters();

		test1.addChar("testname", 100, 10);
		
		System.out.print(test1.listStats(1));
		
	}


}
