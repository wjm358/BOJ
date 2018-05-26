package BOJ1996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		n = Integer.parseInt(in.readLine());
		char[][] mine = new char[n][n];
		char[][] ans = new char[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(ans[i], '0');
		}

		for (int i = 0; i < n; i++) {
			mine[i] = in.readLine().toCharArray();

			for (int j = 0; j < n; j++) {

				if (mine[i][j] != '.') {
					for (int idx = 0; idx < 8; idx++) {
						if (inside(i + x[idx], j + y[idx]))
							ans[i + x[idx]][j + y[idx]] += (mine[i][j] - '0');
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (mine[i][j] != '.') {
					sb.append("*");
					continue;
				}

				if (ans[i][j] - '0' >= 10)
					sb.append("M");
				else
					sb.append((ans[i][j] - '0'));
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	static boolean inside(int x, int y) {
		return (x >= 0 && x < n && y >= 0 && y < n);

	}
}
