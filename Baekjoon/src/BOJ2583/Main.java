package BOJ2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int xMove[] = { 0, 0, -1, 1 };
	static int yMove[] = { -1, 1, 0, 0 };
	static boolean v[][];
	static int cnt;

	static int m, n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		StringBuffer sb = new StringBuffer();

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayList<Integer> result = new ArrayList<>();
		v = new boolean[m][n];

		while (k > 0) {
			st = new StringTokenizer(reader.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			/*
			 * 문제에서는 모눈종이가 뒤짚혀져 있는 상태이므로 180도 뒤집어서 입력해야함 좌하단이 좌상단, 우상단이 우하단이 되게
			 */
			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {

					v[i][j] = true;
				}
			}
			k--;
		}

		// 칠해지지 않은 영역부분에 대해서 DFS
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (v[i][j] == false) {
					cnt = 0;
					dfs(i, j);
					result.add(cnt);
				}
			}
		}

		Collections.sort(result);

		sb.append(result.size() + "\n");
		for (int c : result) {
			sb.append(c + " ");
		}

		System.out.println(sb.toString());
	}

	public static void dfs(int x, int y) {
		if (v[x][y] == false)
			cnt++;
		v[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int newX = x + xMove[i];
			int newY = y + yMove[i];
			if (inside(newX, newY) && v[newX][newY] == false) {
				dfs(newX, newY);
			}
		}

	}

	public static boolean inside(int x, int y) {
		return (x >= 0 && x < m && y >= 0 && y < n);
	}
}
