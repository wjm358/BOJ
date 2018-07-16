package BOJ5988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String str = in.readLine();

			int a = str.charAt(str.length() - 1) - '0';
			if (a % 2 == 0)
				System.out.println("even");
			else
				System.out.println("odd");
		}

	}
}
