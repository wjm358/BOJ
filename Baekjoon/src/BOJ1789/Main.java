package BOJ1789;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(in.readLine());
		long count = 0;
		long sum = 0;
		int i = 1;

		while (sum < n) {
			sum += i;
			count++;
			i++;
		}

		if (sum == n)
			System.out.println(count);
		else {
			System.out.println(count - 1);
		}

	}
}
