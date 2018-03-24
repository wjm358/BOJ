package BOJ2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static boolean isPrime[] = new boolean[10001]; // 10000 ������ �ڿ��� ���� �Ҽ��� ����

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(reader.readLine());
		int n = Integer.parseInt(reader.readLine());

		Arrays.fill(isPrime, true);

		//�����佺 �׳׽��� ü
		isPrime();

		int sum = 0;
		int min = 0;
		
		//�ּڰ� �÷���
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

	// �����佺 �׳׽��� ü
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
