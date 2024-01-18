package j01_basic;

import java.util.ArrayList;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] map1 = new String[arr1.length];
		String[] map2 = new String[arr1.length];
		String[] result = new String[arr1.length];

		String test = "";
		for (int i = 0; i < arr1.length; i++) {
			while (true) {
				if (arr1[i] >= 2) {
					test += arr1[i] % 2;
					arr1[i] = arr1[i] / 2;
				} else {
					test += arr1[i];
					map1[i] = test;
					test = "";
					break;
				}
			}
			while (true) {
				if (arr2[i] >= 2) {
					test += arr2[i] % 2;
					arr2[i] = arr2[i] / 2;
				} else {
					test += arr2[i];
					map2[i] = test;
					test = "";
					break;
				}
			}
		}

		for (int i = 0; i < map1.length; i++) {
			
			if (map1[i].length() != n) {
				while (n != map1[i].length()) {
					map1[i] += "0";
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append(map1[i]);
			map1[i] = sb.reverse().toString();
			if (map2[i].length() != n) {
				while (n != map2[i].length()) {
					map2[i] += "0";
				}
			}
			sb = new StringBuilder();
			sb.append(map2[i]);
			map2[i] = sb.reverse().toString();
		}
		
		for (int i = 0; i < map1.length; i++) {
			int change = 0;
			String a = "";
			for (int j = 0; j < map1[i].length(); j++) {
				change = Integer.valueOf(map1[i].substring(j, j + 1)) + Integer.valueOf(map2[i].substring(j, j + 1));
				if(change >= 2) {
					a += "#";
				} else {
					if(change == 1) {
						a += "#";
					} else {
						a += " ";
					}
				}
			}
			result[i] = a;
		}
		

		return result;
    }
}


public class Ex01_Hello {
	public static void main(String[] args) {
		
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(1);
		System.out.println(arr);
		
		int age = 32;
		// 기본형 변수(원시변수)들은 Stack영역에 저장되고 그 자체로 age = 32로 읽힐 수 있다.
		String name = "kang";
		// 참조형 변수 String의 경우는 위 그림과 같이
		// 주소값을 가진 변수 name 이 Stack에 쌓이고, Stack에 있는 해당 변수를 꺼내서
		// 읽게되면 해당주소를 참조해서 Heap 영역에 있는 kang 라는 값을 쓸 수 있게 된다.
		
	} // main
} // class 
