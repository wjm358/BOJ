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

		//����
		Collections.sort(arr);
		
		//�ַ��
		check(sum);
		
	}

	//9���� Ű�� ��� ���� �հ迡�� ����Ž������ 2���� ���� 100�� �Ǵ°��� ���� 
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
	
	//2���� �������� �ε����� ������ ������ �����̵��� Ű ���� ���
	public static void print(int x, int y) {
		for(int i=0; i<9;i++) {
			if (i == x || i == y) continue;
			System.out.println(arr.get(i));
		}
	}
}
