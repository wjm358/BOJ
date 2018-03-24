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
	static int move[][] = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } }; // �¿����
	static int map[][];
	static int dp[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		M = Integer.parseInt(st.nextToken()); // ���� ũ��
		N = Integer.parseInt(st.nextToken()); // ���� ũ��

		map = new int[M][N];
		dp = new int[M][N];
		
		
		/*
		 * -1�� �ʱ�ȭ �ϴ°��� �߿�
		 * dp���� 0���� �ʱ�ȭ�ϸ� ���������� Ÿ�ٺ��� ��ο����� ���ߴ� ������ �����ϴµ�,
		 * ������������ dp���� 0�� �ȴ�. �׷��� dp�迭�� �ʱⰪ�� ���⶧���� �ٽ� �������� ������ ������ �ٽ� �����ϰԵȴ�.
		 * �׷��Ƿ� -1�� �ʱ�ȭ�ؼ� 0�� ó���� �� �ְ� �Ѵ�.
		 */
		for(int i=0; i<M;i++) {
			Arrays.fill(dp[i],-1);
		}
		
		// �� ������ ���� �Է�
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

	// h: ���� , v: ����
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