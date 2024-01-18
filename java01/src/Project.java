

public class Project {
	
	
	
	public static long timeCheck() {
		
		
		long start = System.currentTimeMillis();
		
		
		
		long end = System.currentTimeMillis();
		return 0;
	}

	public static void main(String[] args) {

		
		for (int i = 0; i < 3; i++) {
			for (int j = 5*i + 1; j <= 5*i+5; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}
