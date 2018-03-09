package BOJ1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int cnt=0;
		
		for(int i=0; i<n;i++) {
			int t = Integer.parseInt(st.nextToken());
			if(isPrime(t) == true) cnt++;
		}
		
		System.out.println(cnt);
	}
	
	public static boolean isPrime(int num) {
		if (num <=1) return false;
		if(num ==2) return true;
		if( num %2 == 0) return false;
				
		for(int i=2; i<=Math.sqrt(num);i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}
}
