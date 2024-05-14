package programmers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;

public class Test {

	public int[] solution(int[] answer) {
		int[] result = {0};
		
		int[] a = {1,2,3,4,5};
		int[] b = {2,1,2,3,2,4,2,5};
		int[] c = {3,3,1,1,2,2,4,4,5,5};
		
		int checkA = 0;
		int checkB = 0;
		int checkC = 0;
		for (int i = 0; i < answer.length; i++) {
			if(answer[i] == a[i]) {
				checkA++;
			}
			if(answer[i] == b[i]) {
				checkB++;
			}
			if(answer[i] == c[i]) {
				checkC++;
			}
		}
		
		int count = 0;
		for (int i : answer) {
		}
		
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("A", checkA);
		hash.put("B", checkB);
		hash.put("C", checkC);
		
		System.out.println(hash);
		
		
		return result;
		
	}

	

	public static void main(String[] args){
//		// 경우의 수 ?
		int[] answer = {1,2,3,4,5};
		Test test = new Test();

		
		System.out.println(test.solution(answer));
	}
}
