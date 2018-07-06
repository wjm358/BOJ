package BOJ1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] dp = new int[1000000];
		dp[0] =1;
		dp[1] =2;
		for(int i=2; i<n;i++) {
			dp[i] = (dp[i-1]+dp[i-2]) % 15746;
		}

		System.out.println(dp[n-1]);
	}
}
