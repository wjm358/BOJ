package BOJ2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int testCase = Integer.parseInt(reader.readLine());
		
		while(testCase >0) {
			int k = Integer.parseInt(reader.readLine()); //층의 수
			int n = Integer.parseInt(reader.readLine()); //호의 수
			int arr[][] = new int[k+1][n+1]; //아파트는 0층부터있고, 호는 1호부터 있다
			
			//0층의 i호에는 i명이 산다
			for(int i=1; i<=n; i++) 
				arr[0][i] = i;
			
			for(int i=1; i<=k;i++) {
				for(int j=1; j<=n;j++) {
					//1호부터 j호까지 더함
					for(int t=1; t<=j;t++)
						arr[i][j] += arr[i-1][t];
				}
			}
			
			testCase--;
			sb.append(arr[k][n] + "\n");
		}
		System.out.println(sb.toString());
		
	}
}
