package BOJ1834;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(in.readLine());
		long sum=0;
		
		for(int i=1;i<=n-1;i++) {
			sum +=(n*i+i);
		}
		
		System.out.println(sum);
	}
}
