package BOJ10164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int map[][] = new int[n + 1][m + 1];

		int cnt = 1;
		int r = 0, c = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (cnt == k) {
					r = i + 1;
					c = j + 1;
				}
				cnt++;
			}
		}

		map[0][1] = 1;

		if (k == 0) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				}
			}

		} else {
			for (int i = 1; i <= r; i++) {
				for (int j = 1; j <= c; j++) {
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				}
			}
			for (int i = r; i <= n; i++) {
				for (int j = c; j <= m; j++) {
					if (i == r && j == c)
						continue;
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				}
			}
		}

		System.out.println(map[n][m]);
	}
}
