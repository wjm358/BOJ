package BOJ2480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuffer sb = new StringBuffer();

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int max = Math.max(a, Math.max(b, c));

		if (a == b && b == c)
			System.out.println((10000 + (a * 1000)));
		else if (a == b)
			System.out.println((1000 + (a * 100)));
		else if (b == c)
			System.out.println((1000 + (b * 100)));
		else if (c == a)
			System.out.println((1000 + (c * 100)));
		else
			System.out.println(max * 100);
	}
}
