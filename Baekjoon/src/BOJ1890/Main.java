package BOJ1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  정답이 2^63-1 보다 작거나 같으므로 단순한 bfs, dfs로 해결할 수 없음
 *  -> dynamic programming 이용 
 *  경로 개수 계산 과정에서 int값의 범위를 넘어갈 수 있으므로 long 타입으로 선언
 */
public class Main {
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());

		int arr[][] = new int[n][n];
		long dp[][] = new long[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				arr[i][j] = tmp;
			}
		}

		dp[0][0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dp[i][j] == 0 || (i == n - 1 && j == n - 1))
					continue;
				
				int jump = arr[i][j];
				
				if (inSide(i, j + jump))
					dp[i][j + jump] += dp[i][j];
				if (inSide(i + jump, j))
					dp[i + jump][j] += dp[i][j];
			}
		}
		System.out.println(dp[n - 1][n - 1]);
	}

	public static boolean inSide(int x, int y) {
		return (x >= 0 && x < n && y >= 0 && y < n);
	}
}
