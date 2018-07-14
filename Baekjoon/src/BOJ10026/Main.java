package BOJ10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int resultA = 0;
	static int resultB = 0;
	static int n;
	static int xdir[] = { -1, 1, 0, 0 };
	static int ydir[] = { 0, 0, -1, 1 };
	static boolean v[][];
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		map = new char[n][n];
		v = new boolean[n][n];
		for (int i = 0; i < n; i++)
			map[i] = in.readLine().toCharArray();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[i][j]) {
					resultA++;
					a(i, j);
				}
			}
		}

		v = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!v[i][j]) {
					resultB++;
					b(i, j);
				}
			}
		}

		System.out.println(resultA + " " + resultB);
	}

	// 적색과 녹색 따로구분
	static void a(int x, int y) {
		v[x][y] = true;
		char cntColor = map[x][y];
		for (int i = 0; i < 4; i++) {
			int nX = x + xdir[i];
			int nY = y + ydir[i];
			if (inside(nX, nY) && cntColor == map[nX][nY] && !v[nX][nY]) {
				a(nX, nY);
			}
		}
	}

	// 적색과 녹색 같이 구분
	static void b(int x, int y) {
		v[x][y] = true;
		char cntColor = map[x][y];
		for (int i = 0; i < 4; i++) {
			int nX = x + xdir[i];
			int nY = y + ydir[i];
			if (inside(nX, nY) && !v[nX][nY]) {
				if (cntColor == map[nX][nY])
					b(nX, nY);
				else if ((cntColor == 'R' && map[nX][nY] == 'G') || (cntColor == 'G' && map[nX][nY] == 'R'))
					b(nX, nY);
			}
		}
	}

	static boolean inside(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}
