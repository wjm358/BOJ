package BOJ1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int r, c, n;
	static int cnt = 0;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		dfs(0, 0, (int) Math.pow(2, n));
	}

	static void dfs(int x, int y, int size) {
		if (x == r && y == c) {
			System.out.println(cnt);
			return;
		}

		if (r < x + size && r >= x && c < y + size && c >= y) {
			dfs(x, y, size / 2);
			dfs(x, y + size / 2, size / 2);
			dfs(x + size / 2, y, size / 2);
			dfs(x + size / 2, y + size / 2, size / 2);
		} else {
			cnt += size * size;
		}
	}

}
