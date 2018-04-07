package BOJ11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ∫π¿‚µµ : O(n^2)
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		int a[] = new int[n];
		int dp[] = new int[n];
		
		Arrays.fill(dp, 1);
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n;i++) 
			a[i] = Integer.parseInt(st.nextToken());
	
		int max =dp[0];
		for(int i=1; i<n;i++) {
			for(int j=0; j<i;j++) {
				if(a[j] > a[i]) 
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}
	
		System.out.println(max);
			
	}
}
