package BOJ1075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int f = Integer.parseInt(in.readLine());
		int i;
		n= (n/100) * 100;
		
		for(i=0; i<=99;i++) {
			if((n+i) % f ==0) break;
		}
		
		if(i <10) System.out.println("0"+i);
		else System.out.println(i);
	}
}
