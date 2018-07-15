package BOJ10886;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int isCute = 0, isNotCute = 0;
		
		for (int i = 0; i < n; i++) {
			int cute = Integer.parseInt(in.readLine());
			if(cute == 0 ) isNotCute++;
			else
				isCute++;
		}
		
		if(isNotCute > isCute) 
			System.out.println("Junhee is not cute!");
		else
			System.out.println("Junhee is cute!");
	}
}
