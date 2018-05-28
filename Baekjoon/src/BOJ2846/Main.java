package BOJ2846;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		int hill[] = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		int max = 0;

		for (int i = 0; i < n; i++) {
			hill[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n - 1; i++) {
			int t = hill[i];
			int cnt = 1;
			int last = 0;

			for (int j = i + 1; j < n; j++) {
				int tmp = hill[j];
			
				if (tmp > hill[j - 1]) {
					tmp = hill[j];
					last = tmp;
					cnt++;
				} else 
					break;
			}

			if (cnt >= 2) {
				int diff = last - t;
				max = Math.max(diff, max);
			}
		}

		System.out.println(max);
	}
}
