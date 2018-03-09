package BOJ2390;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		arr = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			int tmp = Integer.parseInt(reader.readLine());
			arr.add(tmp);
			sum += tmp;
		}

		//정렬
		Collections.sort(arr);
		
		//솔루션
		check(sum);
		
	}

	//9명의 키를 모두 더한 합계에서 완전탐색으로 2개씩 빼서 100이 되는것을 구함 
	public static void check(int sum) {
		for (int i = 0; i < 8; i++) {
			for (int j = i + 1; j < 9; j++) {
				if(sum - arr.get(i) - arr.get(j) == 100) 
				{
					print(i,j);
					return;
				}
			}
		}
	}
	
	//2명의 난쟁이의 인덱스를 제외한 나머지 난쟁이들의 키 값을 출력
	public static void print(int x, int y) {
		for(int i=0; i<9;i++) {
			if (i == x || i == y) continue;
			System.out.println(arr.get(i));
		}
	}
}
