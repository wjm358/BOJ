
package BOJ11066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	final static int MAX = 987654321;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCase = Integer.parseInt(in.readLine());
		
		while (testCase-- > 0) {
			int n = Integer.parseInt(in.readLine());
			int novel[] = new int[n];
			int sum[] = new int[n + 1];
			int dp[][] = new int[n + 1][n + 1];
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++) {
				novel[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= n; i++)
				sum[i] = sum[i - 1] + novel[i - 1];

			for (int k = 1; k < n; k++) {
				for (int i = 1; i + k <= n; i++) {
					dp[i][i + k] = MAX;
					for (int j = i; j < i + k; j++) {
						dp[i][i + k] = Math.min(dp[i][i + k], dp[i][j] + dp[j + 1][i + k]);
					}
					dp[i][i+k] += sum[i + k] - sum[i - 1];
				}
			}
			
			sb.append(dp[1][n]).append("\n");
		}
		System.out.println(sb.toString());

	}
}
