package BOJ2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] isprime = new boolean[n + 1];
		Arrays.fill(isprime, true);

		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (isprime[i] == true) {
				for (int j = i; j <= n; j += i) {
					if (isprime[j] == true) {
						isprime[j] = false;
						count++;
						if (count == k) {
							System.out.println(j);
							return;
						}
					} else
						continue;
				}
			}
		}

	}

}
