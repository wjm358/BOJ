package BOJ5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		long[][] dp = new long[n][21];

		int arr[] = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		dp[0][arr[0]] = 1;
		for (int i = 0; i <= n - 2; i++) {
			for (int j = 0; j <= 20; j++) {
				if (dp[i][j] != 0) {
					int a = j + arr[i+1];
					int b = j - arr[i+1];

					if (a >= 0 && a <= 20)
						dp[i + 1][a] += dp[i][j];
					if (b >= 0 && b <= 20)
						dp[i + 1][b] += dp[i][j];
				}
			}
		}
		System.out.println(dp[n-2][arr[n-1]]);
	}
}
