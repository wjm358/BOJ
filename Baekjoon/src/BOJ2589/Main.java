package BOJ2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, max, m;
	static char[][] map;
	static int visited[][];
	static Queue<Point> q;
	static int xDir[] = { -1, 1, 0, 0, };
	static int yDir[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = in.readLine();
			map[i] = str.toCharArray();

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					bfs(i, j);
				}
			}
		}
		System.out.println(max-1);
	}

	static void bfs(int i, int j) {
		visited = new int[n][m];
		q = new LinkedList<>();
		q.add(new Point(i, j));
		visited[i][j] = 1;

		while (!q.isEmpty()) {
			Point p = q.poll();
			int x = p.x;
			int y = p.y;

			max = Math.max(max, visited[x][y]);
			for (int idx = 0; idx < 4; idx++) {
				int newX = x + xDir[idx];
				int newY = y + yDir[idx];
				if (inside(newX, newY)) {
					if (visited[newX][newY] == 0 && map[newX][newY] == 'L') {
						q.add(new Point(newX, newY));
						visited[newX][newY] = visited[x][y] + 1;
					}
				}
			}
		}

	}

	static boolean inside(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
