package BOJ1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static Queue<Pair> q = new LinkedList<>();
	static int move[][] = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } }; // 좌우상하
	static int map[][];
	static int dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로 크기
		N = Integer.parseInt(st.nextToken()); // 세로 크기

		map = new int[M][N];
		dp = new int[M][N];
		
		
		/*
		 * -1로 초기화 하는것이 중요
		 * dp값을 0으로 초기화하면 내리막길을 타다보면 경로에따라 멈추는 지점이 존재하는데,
		 * 그지점에서의 dp값은 0이 된다. 그러면 dp배열의 초기값과 같기때문에 다시 그지점에 왔을때 연산을 다시 수행하게된다.
		 * 그러므로 -1로 초기화해서 0을 처리할 수 있게 한다.
		 */
		for(int i=0; i<M;i++) {
			Arrays.fill(dp[i],-1);
		}
		
		// 각 지점의 높이 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(dfs(0, 0));
	}

	public static int dfs(int i, int j) {
		if (i == M - 1 && j == N - 1)
			return 1;
		
		if (dp[i][j] != -1)
			return dp[i][j];
		
		dp[i][j] = 0;
		
		for (int dir = 0; dir < 4; dir++) {
			if (isInside(i + move[dir][0], j + move[dir][1]))
				if (map[i + move[dir][0]][j + move[dir][1]] < map[i][j])
					dp[i][j] += dfs(i + move[dir][0], j + move[dir][1]);
		}

		return dp[i][j];
	}

	// h: 가로 , v: 세로
	public static boolean isInside(int h, int v) {
		return (h >= 0 && h < M && v >= 0 && v < N);
	}

	static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}