package BOJ1977;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(in.readLine());
		int n = Integer.parseInt(in.readLine());
		int sum = 0;
		boolean flag = false;
		int min = Integer.MAX_VALUE;

		for (int i = 1; i * i <= n; i++) {
			if (i * i >= m) {
				sum += i * i;
				if (!flag) {
					flag = true;
					min = i * i;
				}
			}
		}
		if (!flag)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
