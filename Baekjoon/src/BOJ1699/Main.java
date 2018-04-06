package BOJ1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 조심할 점 : 가장 큰 제곱값으로만 비교할경우
 * 12 = 3^2 + 1^2 + 1^2 + 1^2 (4개)로 입력되는데
 * 12 = 2^2+ 2^2 + 2^2(3개)가 최소개수가 되는것을 발견하지 못함
 * 따라서 1부터 제곱수들을 모두 해봐야함
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int dp[] = new int[n + 1];
		
		for(int i=1;i<=n;i++)
			dp[i] = i;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
			}
		}
		
		System.out.println(dp[n]);
	}
}
