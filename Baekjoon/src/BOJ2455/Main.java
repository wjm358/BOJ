package BOJ2455;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int max =0;
		
		for(int i=0; i<4;i ++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int down = Integer.parseInt(st.nextToken());
			int up = Integer.parseInt(st.nextToken());
			max = Math.max(max, max+(up-down));
			}
		System.out.println(max);
	}
}
