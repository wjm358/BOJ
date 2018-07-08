package BOJ11060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int arr[] = new int[n];
		int dp[] = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			if (dp[i] != Integer.MAX_VALUE) {
				for (int j = 1; j <= arr[i] && i + j < n; j++) {
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				}
			}
		}
		
		if (dp[n - 1] != Integer.MAX_VALUE)
			System.out.println(dp[n - 1]);
		else
			System.out.println(-1);
	}
}
