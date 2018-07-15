package BOJ1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(in.readLine());
		int cnt = 0;
		int sum = 0;
		int stick = 64;
		if (x == 64) {
			System.out.println(1);
			return;
		}
		while (sum != x) {
			if (sum + stick / 2 > x)
				stick /= 2;
			else {
				cnt++;
				sum += stick / 2;
			}
		}
		System.out.println(cnt);
	}
}
