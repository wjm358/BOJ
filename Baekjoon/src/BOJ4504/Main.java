package BOJ4504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringBuffer sb =new StringBuffer();
		
		int t;
		while((t = Integer.parseInt(in.readLine())) != 0) {
			
			if(t % n ==0)
				sb.append(t).append(" is a multiple of ").append(n).append(".\n");
			else
				sb.append(t).append(" is NOT a multiple of ").append(n).append(".\n");
		}
		
		System.out.println(sb.toString());
	}
}
