package test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	

    
	public int solution(int[] mon) {
		
		int test = mon.length;
		int want = mon.length / 2;
		
		int max;
		

		
		for (int i = 0; i < mon.length; i++) {
			int check = 0;
			List<Integer> list = new ArrayList<Integer>();
			list.add(mon[i+check]);
			check++;
			if(i+check == want) break;
		}
		
//		for (int i = 0; i < test-1; i++) {
//			for (int j = i+1; j < test; j++) {
//				if(mon[i] != mon[j]) {
//					
//				}
//			}
//		}
		
		return 0;
	}

	
	
	
	public static void main(String[] args) {
		int[] mon = {3,1,2,3};
		
		Test test = new Test();
		System.out.println(test.solution(mon));
		

	}
	
}
