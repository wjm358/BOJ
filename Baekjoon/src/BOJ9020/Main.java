package BOJ9020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean isPrime[] = new boolean[10001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(in.readLine());
		Arrays.fill(isPrime, true);
		isPrime[0] = isPrime[1] = false;
		prime();
		
		while (testCase > 0) {
			int num = Integer.parseInt(in.readLine());
		
			int n = num/2;
			
			for(int i=n,j=n; i>=0; i--,j++) {
				if(isPrime[i] && isPrime[j]) {
					System.out.println(i + " " + j);
					break;
				}
			}
			testCase--;

		}

	}

	static void prime() {

		for(int i= 2; i*i <=10000; i++) {
			if(isPrime[i]) {
			for(int j=i*i; j<=10000; j+=i) 
				isPrime[j] = false;
			}
		}
	}
	
}
