package BOJ2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean isPrime[] = new boolean[10001]; // 10000 이하의 자연수 까지 소수를 구함

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(reader.readLine());
		int n = Integer.parseInt(reader.readLine());

		Arrays.fill(isPrime, true);

		//에라토스 테네스의 체
		isPrime();

		int sum = 0;
		int min = 0;
		
		//최솟값 플래그
		boolean isFirst = true;

		for (int i = m; i <= n; i++) {
			if (isPrime[i]) {
				if (isFirst) {
					min = i;
					sum += i;
					isFirst = false;
				} else
					sum += i;
			}
		}

		if (sum == 0) {
			System.out.println("-1");
			return;
		}
		
		System.out.println(sum);
		System.out.println(min);
	}

	// 에라토스 테네스의 체
	public static void isPrime() {
		isPrime[0] = false;
		isPrime[1] = false;

		for (int i = 2; i * i <= 10000; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 10000; j += i)
					isPrime[j] = false;
			}
		}
	}

}
