package BOJ9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(in.readLine());

		while (testCase-- > 0) {
			int n = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			int coin[] = new int[n];

			for (int i = 0; i < n; i++)
				coin[i] = Integer.parseInt(st.nextToken());

			int money = Integer.parseInt(in.readLine());
			int dp[] = new int[money + 1];
			dp[0] = 1;

			for (int i = 0; i < n; i++) {
				for (int j = coin[i]; j <= money; j++) {
					dp[j] += dp[j - coin[i]];
				}
			}
			
			System.out.println(dp[money]);

		}
	}
}
