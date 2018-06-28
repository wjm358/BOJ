package BOJ10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String num = in.readLine();
		int[] count = new int[10];
		int sum = 0;
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < num.length(); i++) {
			int t = num.charAt(i) - '0';
			count[t]++;
			sum += t;
		}

		if (count[0] == 0 || sum % 3 != 0)
			System.out.println(-1);
		else {
			for (int i = 9; i >= 0; i--) {
				while (count[i] != 0) {
					sb.append(i);
					count[i]--;
				}
			}
		}
		System.out.println(sb.toString());

	}
}
