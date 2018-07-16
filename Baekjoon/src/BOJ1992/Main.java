package BOJ1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char map[][];
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = in.readLine();
			map[i] = str.toCharArray();
		}
		dfs(0,0,n);
		System.out.println(sb.toString());

	}

	static void dfs(int x, int y, int size) {
		char first = map[x][y];
		boolean same = true;
		for (int i = x; i < x + size && same; i++) {
			for (int j = y; j < y + size && same; j++) {
				if (first != map[i][j])
					same = false;
			}
		}

		if (same)
			sb.append(first);
		else {
			sb.append("(");
			dfs(x, y, size / 2);
			dfs(x, y + size / 2, size / 2);
			dfs(x + size / 2, y, size / 2);
			dfs(x + size / 2, y + size / 2, size / 2);
			sb.append(")");
		}
	}

}
