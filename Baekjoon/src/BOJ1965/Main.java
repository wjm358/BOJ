package BOJ1965;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int box[] = new int[n];
		int dp[] = new int[n];
		int max =1;
		for (int i = 0; i < n; i++)
			box[i] = Integer.parseInt(st.nextToken());

		Arrays.fill(dp, 1);
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (box[j] < box[i])
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(dp[i], max);
			}
		}
	
		System.out.println(max);
	}
}
