package BOJ2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n, tmp;

		n = tmp = Integer.parseInt(in.readLine());
		int cnt = 0; // 자리 수 카운트
		int sum; //생성자 합
		int ans = 0; // 결과 값 

		while (tmp != 0) {
			tmp /= 10;
			cnt++;
		}

		for (int i = n - (cnt * 9); i < n; i++) {
			int tmpNum = i;
			sum = tmpNum;
			
			while (tmpNum != 0) {
				sum = sum + (tmpNum % 10);
				tmpNum /= 10;
			}
			if (sum == n) {
				ans = i;
				break;
			}
		}

		System.out.println(ans);

	}

}
