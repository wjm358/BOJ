package BOJ2010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		int sum=0;
		
		for (int i = 0; i < n - 1; i++) {
			int num = Integer.parseInt(in.readLine());
			sum += (num-1);
		}
		int num = Integer.parseInt(in.readLine());
		sum += num;
		
		System.out.println(sum);

	}
}
