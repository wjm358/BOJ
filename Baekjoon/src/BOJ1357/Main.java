package BOJ1357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		System.out.println(Rev(Rev(x) + Rev(y)));
	}

	static int Rev(int num) {
		
		int sum = 0;
		while(num !=0) {	
			sum = sum*10 + num%10;
			num /= 10;
		}
		return sum;
	}
}
