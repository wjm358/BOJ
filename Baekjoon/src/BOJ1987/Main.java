package BOJ1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int move[][] = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
	static char[][] board;
	static boolean[] alpha;
	static int r, c;
	static int ans = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		board = new char[r][c];
		alpha = new boolean[26];

		for (int i = 0; i < r; i++) {
			String tmp = reader.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}

		alpha[board[0][0]-'A'] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	public static void dfs(int x, int y, int cnt) {
		if (ans < cnt)
			ans = cnt;
		
		for (int i = 0; i < 4; i++) {
			int newX = x + move[i][0];
			int newY = y + move[i][1];

			if (newX >= 0 && newX < r && newY >= 0 && newY < c) {

				if (alpha[board[newX][newY] - 'A'] == false) {
					alpha[board[newX][newY] - 'A'] = true;
					dfs(newX, newY, cnt + 1);
					alpha[board[newX][newY] - 'A'] = false;
				}
			}

		}
	}

}
